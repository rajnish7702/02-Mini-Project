package com.rajnish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajnish.model.Contact;
import com.rajnish.service.ContactService;

@RestController
public class PhoneController {

	@Autowired
	private ContactService service;

	@PostMapping("/contact")
	public String save(@RequestBody Contact contact) {
		String msg = service.save(contact);
		return msg;
	}

	@GetMapping("/contacts")
	public List<Contact> show() {
		 return service.show();
	}

	@GetMapping("/contact/{Id}")
	public Contact getContactById(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
		
	}

	@PutMapping("/contact")
	public String update(@RequestBody Contact contact) {
		return service.update(contact);
	}

	@DeleteMapping("/contact/{Id}")
	public String delete(@PathVariable Integer contactId) {
		return service.delete(contactId);
	}
}