package com.contactmanager.app.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.contactmanager.app.domain.Contact;
import com.contactmanager.app.domain.ContactRepository;


@Controller
public class ContactController {
@Autowired
private ContactRepository contactRepository;


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
	
	@RequestMapping(value = "/contactlist", method = RequestMethod.GET)
	public String showcontactlist(Model model) {
		model.addAttribute("contacts", contactRepository.findAll());
		return "contacts";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody Iterable<Contact> contactListRest() {
		return contactRepository.findAll();
	}

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Contact> findContactRest(@PathVariable("id") Long contactId) {
		return contactRepository.findById(contactId);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addContact(Model model) {
		model.addAttribute("contact", new Contact());
		return "addnewcontact";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savecontact(Contact contact) {
		contactRepository.save(contact);
		return "redirect:contactlist";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String addStudent(@PathVariable("id") Long contactId, Model model) {
		model.addAttribute("contact", contactRepository.findById(contactId));
		return "editContact";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deletecontact(@PathVariable("id") Long contactId, Model model) {
		contactRepository.deleteById(contactId);
		return "redirect:../contactlist";
	}
	
	
}



	