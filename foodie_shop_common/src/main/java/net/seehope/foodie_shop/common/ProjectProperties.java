package net.seehope.foodie_shop.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

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
	private ImageValidateCodeProperties imageValidateCode = new ImageValidateCodeProperties();

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

	public ImageValidateCodeProperties getImageValidateCode() {
		return imageValidateCode;
	}

	public void setImageValidateCode(ImageValidateCodeProperties imageValidateCode) {
		this.imageValidateCode = imageValidateCode;
	}
}
