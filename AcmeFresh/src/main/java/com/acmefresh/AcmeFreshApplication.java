package com.acmefresh;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AcmeFreshApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeFreshApplication.class, args);
	}
	

}
