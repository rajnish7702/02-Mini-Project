package com.rajnish.service;

import java.util.List;

import com.rajnish.model.Contact;

public interface ContactService {
	public String save(Contact contact);
	public List<Contact> show();
	public Contact getContactById(Integer contactId);
	public String update(Contact contact);
	public String delete(Integer contactId);
}