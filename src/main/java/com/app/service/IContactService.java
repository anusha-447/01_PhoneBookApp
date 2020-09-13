package com.app.service;

import java.util.List;

import com.app.model.Contact;

public interface IContactService {
	
	public Boolean  saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Boolean updateContact(Contact contact);
	
	public Boolean deleteContact(Integer id);
	
	public Contact getOneContact(Integer id);
	 
	
 
}
