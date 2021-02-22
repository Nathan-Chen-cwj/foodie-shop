package net.seehope.foodie_shop.validate;

import net.seehope.foodie_shop.common.ProjectProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/21 16:20
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private ProjectProperties properties;

    /**
     * 只有当容器中缺少ImageValidateCodeGenerator 或者缺少其实现 bean才注册
     * 相当于
     * <bean id ="ImageValidateCodeGenerator" class="net.seehope.foodie_shop.validate.DefaultImageValidateCodeGenerator"/>
     */
    @Bean
    @ConditionalOnMissingBean(value = ImageValidateCodeGenerator.class)
    public ImageValidateCodeGenerator imageValidateCodeGenerator(){
        DefaultImageValidateCodeGenerator defaultImageValidateCodeGenerator = new DefaultImageValidateCodeGenerator();
        defaultImageValidateCodeGenerator.setProperties(properties);
        return defaultImageValidateCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(value = SmsValidateCodeGenerator.class)
    public SmsValidateCodeGenerator smsValidateCodeGenerator(){
        DefaultSmsValidateCodeGenerator defaultSmsValidateCodeGenerator = new DefaultSmsValidateCodeGenerator();
        defaultSmsValidateCodeGenerator.setProperties(properties);
        return defaultSmsValidateCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(value = EmailValidateCodeGenerator.class)
    public EmailValidateCodeGenerator emailValidateCodeGenerator(){
        DefaultEmailValidateCodeGenerator defaultEmailValidateCodeGenerator = new DefaultEmailValidateCodeGenerator();
        defaultEmailValidateCodeGenerator.setProperties(properties);
        return defaultEmailValidateCodeGenerator;
    }
}
