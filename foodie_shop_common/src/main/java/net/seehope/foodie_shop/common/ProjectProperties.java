package net.seehope.foodie_shop.common;

import net.seehope.foodie_shop.common.validateproperties.EmailValidateCodeProperties;
import net.seehope.foodie_shop.common.validateproperties.ImageValidateCodeProperties;
import net.seehope.foodie_shop.common.validateproperties.SmsValidateCodeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/2 09:47
 *
 * 项目相关配置类
 */
@Configuration
@ConfigurationProperties(prefix = "net.seehope")
public class ProjectProperties {

	private String baseStaticServerUrl = "http://127.0.0.1:8848";

	private QQProperties qq = new QQProperties();

	private BrowserProperties browser = new BrowserProperties();
	/**
	 * 使用条件装配来实现验证码的生产
	 */
	private ImageValidateCodeProperties imageValidateCodeProperties = new ImageValidateCodeProperties();

	private SmsValidateCodeProperties smsValidateCodeProperties = new SmsValidateCodeProperties();

	private EmailValidateCodeProperties emailValidateCodeProperties = new EmailValidateCodeProperties();

	public EmailValidateCodeProperties getEmailValidateCodeProperties() {
		return emailValidateCodeProperties;
	}

	public void setEmailValidateCodeProperties(EmailValidateCodeProperties emailValidateCodeProperties) {
		this.emailValidateCodeProperties = emailValidateCodeProperties;
	}

	public SmsValidateCodeProperties getSmsValidateCodeProperties() {
		return smsValidateCodeProperties;
	}

	public void setSmsValidateCodeProperties(SmsValidateCodeProperties smsValidateCodeProperties) {
		this.smsValidateCodeProperties = smsValidateCodeProperties;
	}

	public String getBaseStaticServerUrl() {
		return baseStaticServerUrl;
	}

	public void setBaseStaticServerUrl(String baseStaticServerUrl) {
		this.baseStaticServerUrl = baseStaticServerUrl;
	}

	public QQProperties getQq() {
		return qq;
	}

	public void setQq(QQProperties qq) {
		this.qq = qq;
	}

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

	public ImageValidateCodeProperties getImageValidateCodeProperties() {
		return imageValidateCodeProperties;
	}

	public void setImageValidateCode(ImageValidateCodeProperties imageValidateCodeProperties) {
		this.imageValidateCodeProperties = imageValidateCodeProperties;
	}
}
