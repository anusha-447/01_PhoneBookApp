package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.Contact;
import com.app.service.IContactService;

@Controller

public class ContactInfoController {
	@Autowired
	private IContactService contactService;
	@GetMapping("/show")
	public String Showpage(Model model) {
		
		model.addAttribute("contact", new Contact());
		return "index";
	}

	@PostMapping("/save")
	public String saveContactPage(@ModelAttribute("contact") Contact contact,RedirectAttributes attribute
			,Model model) {
		model.addAttribute("contact", new Contact());
		
		boolean isave=contactService.saveContact(contact);
		if(isave) {
			if(contact.getCntctid()!=null) {
			attribute.addFlashAttribute("success", "contact updated successfully");
		}
		else {
			attribute.addFlashAttribute("success", "contact saved successfully");
		}}
		else {
			attribute.addFlashAttribute("fail", "contact is saving is failed ");
		}
		return "redirect:/show";
	}
//	@GetMapping("/submitContact")
//	public String submitContact(Model model) {
//		model.addAttribute("contact", new Contact());
//		return "index";
	
//	}
	@GetMapping("/viewContacts")
	public String viewContacts(Model model) {
		List<Contact> contacts=contactService.getAllContacts();
		//System.out.println(contacts);//
		
		model.addAttribute("contacts",contacts);
		return "ViewContacts";
	}
	
}
