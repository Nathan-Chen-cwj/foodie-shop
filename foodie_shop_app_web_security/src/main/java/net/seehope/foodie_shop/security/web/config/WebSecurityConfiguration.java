package net.seehope.foodie_shop.security.web.config;

import net.seehope.foodie_shop.common.ProjectConstant;
import net.seehope.foodie_shop.common.ProjectProperties;
import net.seehope.foodie_shop.validate.ValidateCodeFilter;
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
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

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
        //添加过滤器
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setProperties(properties);
        validateCodeFilter.setFailureHandler(failureHandler);
        validateCodeFilter.afterPropertiesSet();

        //设置当前应用使用表单登录方式
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                //设置会覆盖登录表单所在的位置,可以是个控制器等
                .loginPage(ProjectConstant.LOGIN_PATH)
                //设置会覆盖登录表单请求的路径
                .loginProcessingUrl(properties.getBrowser().getLoginProcessingUrl())
                // 认证成功处理器
                .successHandler(successHandler)
                // 认证失败处理器
                .failureHandler(failureHandler)
            .and()
                //添加记住我功能
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
                        "/validate/image",
                        "/css/bootstrap.min.css",
                        "/css/style.css",
                        "css/unicons.css",
                        properties.getBrowser().getSwagger())
                .permitAll()//放行
                .anyRequest()//除上述请求外所有请求
                .authenticated()//都需要进行认证，不在乎认证形式，只要认证即可
            .and()//返回到http 配置目录层
                .csrf() //进入csrf配置
                .disable();//关闭csrf
    }
}
