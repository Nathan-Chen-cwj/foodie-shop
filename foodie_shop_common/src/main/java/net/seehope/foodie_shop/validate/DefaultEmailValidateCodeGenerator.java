package net.seehope.foodie_shop.validate;

import net.seehope.foodie_shop.common.ProjectProperties;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/23 0:24
 */
public class DefaultEmailValidateCodeGenerator implements EmailValidateCodeGenerator{

    private ProjectProperties properties;

    @Override
    public ValidateCode generatorValidateCode() {
        ValidateCode validateCode = new ValidateCode(RandomStringUtils.randomNumeric(properties.getEmailValidateCodeProperties().getEmailValidateCodeLength()),
                properties.getEmailValidateCodeProperties().getEffectiveIn());
        return validateCode;
    }

    public ProjectProperties getProperties() {
        return properties;
    }

    public void setProperties(ProjectProperties properties) {
        this.properties = properties;
    }
}
