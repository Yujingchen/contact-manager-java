package com.contactmanager.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contactmanager.app.domain.ContactRepository;


@Controller
public class ContactController {
//@Autowired
//private ContactRepository cRepository;
//	@Autowired
//	private CategoryRepository categoryRepository;

	@RequestMapping(value = "/")
	public String main() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout() {
		return "logout";
	}
}



	