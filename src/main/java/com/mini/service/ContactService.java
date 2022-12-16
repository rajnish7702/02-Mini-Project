package com.mini.service;

import java.util.List;

import com.mini.model.Contact;

public interface ContactService {
	public String saveContact(Contact contact);
	public List<Contact> show();
	public Contact getContactById(Integer contactId);
	public String updateContact(Contact contact);
	public String deleteContact(Integer contactId);
}