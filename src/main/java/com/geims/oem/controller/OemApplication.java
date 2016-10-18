package com.geims.oem.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.geims.oem.config.AppConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Oem main Class
 * @author Vishal Verma
 * @author $LastChangedBy: Vishal Verma
 * @version $Revision:001 $, $Date: 15/10/2016
 */

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackageClasses = { AppConfig.class })
public class OemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OemApplication.class, args);
	}
}
