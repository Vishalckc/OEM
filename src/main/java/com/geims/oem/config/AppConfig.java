package com.geims.oem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.geims.oem.controller.AppErrorController;
import com.geims.oem.controller.OemController;
import com.geims.oem.serviceImpl.OemServiceImpl;

@EnableJpaRepositories("com.geims.oem.dao")
@EntityScan("com.geims.oem.entity")
@Configuration
@ComponentScan(basePackageClasses = { OemServiceImpl.class, OemController.class })
@ComponentScan(basePackages = { "com.geims.oem.service" })
public class AppConfig {
	@Autowired
	private ErrorAttributes errorAttributes;

	@Bean
	public AppErrorController appErrorController() {
		return new AppErrorController(errorAttributes);
	}

}