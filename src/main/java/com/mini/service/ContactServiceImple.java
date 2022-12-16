package com.mini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mini.model.Contact;
import com.mini.repository.ContactRepository;

import io.swagger.models.Response;

@Service
public class ContactServiceImple implements ContactService {
	
	@Autowired
	private ContactRepository repo;

	public String saveContact(Contact contact) {
		contact.setActiveSw("Y");
		 contact = repo.save(contact);
		 if(contact.getContactId()!=null) {
			 return "recored submited sucessfully";
		 }
		 else {
			 return "recored submited feild ";
		 }
		
	}
	public List<Contact> show() {
		
		return repo.findByActiveSw("Y");
	}

	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	
	public String updateContact(Contact contact){
		if(repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "record update";
		}
		else {
			return "recored updated unsucessfull";
		}
	}

	
	public String deleteContact(Integer contactId) {
		/*if(repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "record delete sucessfully";
		}
		else {
			return "record unsucessfully";
		}*/
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			repo.save(contact);
			return "record delete sucessfully";
		}
		else {
			return "record unsucessfully";
		}
	}
	
}