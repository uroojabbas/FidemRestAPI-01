package com.vroom.dataservice;

import com.vroom.dataservice.configuration.FileUploadConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.vroom.*" })
@EntityScan("com.vroom.*")
@EnableConfigurationProperties(FileUploadConfigurationProperties.class)
public class DataserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataserviceApplication.class, args);
	}
}
