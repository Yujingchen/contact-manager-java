package com.contactmanager.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.contactmanager.app.domain.Contact;
import com.contactmanager.app.domain.ContactRepository;
import com.contactmanager.app.domain.User;
import com.contactmanager.app.domain.UserRepository;


@SpringBootApplication
public class ContactmanagerApplication {
	private static final Logger log = LoggerFactory.getLogger(ContactmanagerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ContactmanagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ContactRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of contact");
			crepository.save(new Contact("Alice", "Chen", 24568945, "aliceC@gmial.com", "Hakaniemenranta", 653));
			crepository.save(new Contact("John", "Simpson", 24568945, "JsimpsonC@gmial.com", "Kaisaniemi", 653));
			crepository.save(new Contact("Alen", "Hakward", 24568945, "ahakward@gmial.com", "Turuku", 653));
			crepository.save(new Contact("Simen", "Yan", 24568945, "SimenyC@gmial.com", "Temerpa", 653));
			crepository.save(new Contact("Kate", "Neilson", 24568945, "Kneilson@gmial.com", "Laperanta", 653));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all Books");
			for (Contact contact : crepository.findAll()) {
				log.info(contact.toString());
			}
		};
	}

}
