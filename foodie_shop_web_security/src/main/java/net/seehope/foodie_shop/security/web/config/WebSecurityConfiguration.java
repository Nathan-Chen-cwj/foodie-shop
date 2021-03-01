package net.seehope.foodie_shop.security.web.config;

import net.seehope.foodie_shop.authentication.sms.SmsCodeAuthenticationConfig;
import net.seehope.foodie_shop.common.ProjectConstant;
import net.seehope.foodie_shop.common.ProjectProperties;
import net.seehope.foodie_shop.validate.ValidateCodeFilter;
import net.seehope.foodie_shop.validate.ValidateCodeProcessor;
import net.seehope.foodie_shop.validate.config.FormAuthenticationConfig;
import net.seehope.foodie_shop.validate.config.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 10:47
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ProjectProperties properties;


    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationConfig smsCodeAuthenticationConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;

    @Autowired
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * 允许所有的请求接入以及关闭攻击防护策略
         * http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
         */


        //添加短信验证分链
        http.apply(smsCodeAuthenticationConfig);
        //添加验证码验证逻辑
        http.apply(validateCodeSecurityConfig);
        //加载表单登陆逻辑
        formAuthenticationConfig.configure(http);

        //设置当前应用使用表单登录方式
        http
                /*
                    添加记住我功能 本质上是个过滤器
                    实现过程解析：
                        浏览器发送登陆请求，成功后AbstractAuthentication
                        调用rememberMeService.loginSuccess服务保存登陆成功凭证,默认存储在session,
                        正是因为这样我们能正常处理后续的请求
                        而后,我们在这里改变了这个凭证的存储时间和位置使用了session+数据库保持登陆成功依据
                        首次请求：AbstractAuthentication->UPA F->rememberService->jdbcTokenRepository->将token存储到数据库
                        有效期内的请求：
                        RememberMeAuthenticationFilter->jdbcTokenRepository->查找token->取出username->调用userDetailsService进行验证
                 */
                .rememberMe()
                //保存策略 基于内存或基于数据库
                .tokenRepository(persistentTokenRepository())
                //用户名认证类
                .userDetailsService(userDetailsService)
                //设置token有效期
                .tokenValiditySeconds(properties.getBrowser().getTokenValiditySeconds())
            .and()// 返回http security对象配置目录
                .authorizeRequests() //以下都是对授权进行配置,记得放行！！！
                //请求符合该规则时，放行
                .antMatchers(properties.getBrowser().getLoginPage(),
                        properties.getBrowser().getLoginProcessingUrl(),
                        ProjectConstant.LOGIN_PATH,
                        "/css/bootstrap.min.css",
                        "/css/style.css",
                        "css/unicons.css",
                        properties.getBrowser().getSwaggerUrl(),
                        ProjectConstant.VALIDATE_CODE_URL_PREFIX+"*",
                        properties.getSmsValidateCodeProperties().getSmsValidateCodeProcessingUrl())
                .permitAll()//放行
                .anyRequest()//除上述请求外所有请求
                .authenticated()//都需要进行认证，不在乎认证形式，只要认证即可
            .and()//返回到http 配置目录层
                .csrf() //进入csrf配置
                .disable();//关闭csrf
    }
}
