package com.itelites.employeeRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

@SpringBootApplication
public class EmployeeRestApplication {
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeRestApplication.class, args);
//		FileReader reader=new FileReader("db.properties");
//
//		Properties p=new Properties();
//		p.load(reader);
//
//			URL st = (URL)p.getProperty("spring.data.mongodb.uri");
//		HttpUrlConnection conn = (HttpURLConnection) st.openConnection();
//
////set the timeout in milliseconds
//		conn.setConnectTimeout(7000);

	}

}
