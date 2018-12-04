package edu.sga.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args)
	{
		String passwor = "123";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passwordHashed = passwordEncoder.encode(passwor);
		System.out.println("Mi password:" + passwordHashed);
		SpringApplication.run(CoreApplication.class, args);

	}
}
