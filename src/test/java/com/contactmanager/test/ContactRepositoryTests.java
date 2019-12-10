package com.contactmanager.test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.contactmanager.app.domain.Contact;
import com.contactmanager.app.domain.ContactRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ContactRepositoryTests {
	@Autowired
	private ContactRepository cRepository;

	@Before
	public void setUp() throws Exception {
		Contact contact1 = new Contact("Alice", "Chen", 24568945, "aliceC@gmial.com", "Hakaniemenranta", 00653);
		// save contact, verify has ID value after save
		assertNull(contact1.getId());
		// null before save
		this.cRepository.save(contact1);
		assertNotNull(contact1.getId());
	}

	@Test
	void contextLoads() {
		List<Contact> contactA = cRepository.findByFirstName("Alice");
		assertNotNull(contactA);
		Iterable<Contact> contacts = cRepository.findAll();
		int count = 0;
		for (Contact p : contacts) {
			count++;
		}
		assertEquals(count, 1);
	}
}
