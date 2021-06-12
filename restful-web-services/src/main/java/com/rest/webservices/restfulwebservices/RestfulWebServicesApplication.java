package com.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AbstractLocaleContextResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@EntityScan("com.rest.webservices.model")
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	/*
	 * @Bean("localeResolver") public AbstractLocaleContextResolver localeResolver()
	 * { AbstractLocaleContextResolver sessionLocaleResolver = new
	 * SessionLocaleResolver(); sessionLocaleResolver.setDefaultLocale(Locale.US);
	 * return sessionLocaleResolver; }
	 * 
	 * public ResourceBundleMessageSource resourceBundleMessageSource() {
	 * ResourceBundleMessageSource resource=new ResourceBundleMessageSource();
	 * resource.setBasename("message"); return resource;
	 * 
	 * }
	 */

}
