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
			crepository.save(new Contact("John", "Simpson", 24568945, "JsimpsonC@gmial.com", "Kaisaniemi", 653));
			crepository.save(new Contact("Alen", "Hakward", 24568945, "ahakward@gmial.com", "Turuku", 653));
			crepository.save(new Contact("Simen", "Yan", 24568945, "SimenyC@gmial.com", "Temerpa", 653));
			crepository.save(new Contact("Kate", "Neilson", 24568945, "Kneilson@gmial.com", "Laperanta", 653));

		};
	}
}
