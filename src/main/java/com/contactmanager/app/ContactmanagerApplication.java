package com.contactmanager.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.contactmanager.app.domain.Contact;
import com.contactmanager.app.domain.ContactRepository;



@SpringBootApplication
public class ContactmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactmanagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ContactRepository crepository) {
		return (args) -> {
			crepository.save(new Contact("Alice", "Chen", 24568945, "aliceC@gmial.com", "Hakaniemenranta", 653));
		};
	}
}
