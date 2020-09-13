package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Contact;
import com.app.service.IContactService;

@Controller
public class ViewContactController {
	
	@Autowired
	private IContactService contactService;
	@GetMapping("/editContact")
	public String editPageShow(@RequestParam("contact_id") Integer id,Model model) {
		System.out.println(id);
		
		Contact contact=contactService.getOneContact(id);
		model.addAttribute("contact", contact);
		//System.out.println(contact);
		return "index";
	}
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("contact_id") Integer id,Model model) {
		System.out.println(id);
		Boolean status=contactService.deleteContact(id);
		String message="contact is '"+id+"' deleted";
		model.addAttribute("status",message);
		
		return "ViewContacts";
	}
}
