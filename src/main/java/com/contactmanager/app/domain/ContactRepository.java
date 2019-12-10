package com.contactmanager.app.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	List<Contact> findByFirstName(String firstName);
	List<Contact> findByEmail(String email);
	List<Contact> findByPhone(int phone);
	List<Contact> findById(int id);
	List<Contact> deleteById(int id);
}

