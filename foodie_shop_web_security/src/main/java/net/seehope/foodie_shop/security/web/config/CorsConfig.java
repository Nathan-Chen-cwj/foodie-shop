package net.seehope.foodie_shop.security.web.config;

import net.seehope.foodie_shop.common.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * @author vessel
 */
@Configuration
public class CorsConfig {

	@Autowired
	private ProjectProperties properties;

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin(properties.getBaseStaticServerUrl());
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedHeader("*");

		UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
		corsSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(corsSource);
	}
}
