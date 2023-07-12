package com.myapp.springsecurity.version1;

import com.myapp.springsecurity.version1.repository.MyUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = MyUserRepository.class)
public class Version1Application {

	public static void main(String[] args) {
		SpringApplication.run(Version1Application.class, args);
	}

}
