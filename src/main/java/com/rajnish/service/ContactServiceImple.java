package com.rajnish.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajnish.model.Contact;
import com.rajnish.repository.ContactRepository;

@Service
public class ContactServiceImple implements ContactService {
	
	@Autowired
	private ContactRepository repo;

	public String save(Contact contact) {
		
		 contact = repo.save(contact);
		 if(contact.getContactId()!=null) {
			 return "recored submited sucessfully";
		 }
		 else {
			 return "recored submited feild ";
		 }
		
	}
	public List<Contact> show() {
		
		return repo.findAll();
	}

	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	
	public String update(Contact contact){
		if(repo.existsById(contact.getContactId())) {
			repo.save(contact);
			return "record update";
		}
		else {
			return "recored updated unsucessfull";
		}
	}

	
	public String delete(Integer contactId) {
		if(repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "record delete sucessfully";
		}
		else {
			return "record unsucessfully";
		}
	}
	
}