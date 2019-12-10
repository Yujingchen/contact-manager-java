package com.contactmanager.app.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	List<Contact> findByFirstName(String firstName);
}

