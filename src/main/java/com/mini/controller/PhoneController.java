package com.mini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mini.model.Contact;
import com.mini.service.ContactService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value="This is contact Api")
public class PhoneController {

	@Autowired
	private ContactService service;

	@PostMapping("/contact")
	@ApiOperation("this is used to store new recode")
	public String saveContact(@RequestBody Contact contact) {
		String msg = service.saveContact(contact);
		return msg;
	}

	@GetMapping("/contacts")
	@ApiOperation("this is used to get all data")
	public List<Contact> show() {
		 return service.show();
	}

	@GetMapping("/contact/{contactId}")
	@ApiOperation("thi is get id to update the recode")
	public Contact getContactById(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
		
	}

	@PutMapping("/contact")
	@ApiOperation("this is used to update the recode ")
	public String updateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}

	@DeleteMapping("/contact/{contactId}")
	@ApiOperation("this is used to delet the rocode base on id")
	public String deleteContact(@PathVariable Integer contactId) {
		return service.deleteContact(contactId);
	}
}