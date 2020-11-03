package com.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.Contact;
import com.app.service.IContactService;

@Controller

public class ContactInfoController {
	private static final Logger Logger=LoggerFactory.getLogger(ContactInfoController.class);
	@Autowired
	private IContactService contactService;
	@GetMapping("/show")
	public String Showpage(Model model) {
		Logger.debug("** Showpage() Method execution Started**");
		model.addAttribute("contact", new Contact());
		Logger.debug("** Showpage() Method execution ended**");
		Logger.info("**Showpage() Method  exected successfully** ");
		return "index";
	}

	@PostMapping("/save")
	public String saveContactPage(@ModelAttribute("contact") Contact contact,RedirectAttributes attribute
			,Model model) {
		Logger.debug("** saveContactPage() Method execution Started**");
		model.addAttribute("contact", new Contact());
		boolean isave=contactService.saveContact(contact);
		if(isave) {
			if(contact.getCntctid()!=null) {
				attribute.addFlashAttribute("success", "contact updated successfully");
				Logger.info("**contact updated successfully** ");
			}
			else {
				attribute.addFlashAttribute("success", "contact saved successfully");
				Logger.info("**contact saved successfully** ");
			}}
		else {
			attribute.addFlashAttribute("fail", "contact is saving is failed ");
			Logger.info("**contact saved successfully** ");
		}
		Logger.debug("** saveContactPage() Method execution Ended**");
		Logger.info("**saveContactPage() Method  exected successfully** ");
		return "redirect:/show";
	}
	//	@GetMapping("/submitContact")
	//	public String submitContact(Model model) {
	//		model.addAttribute("contact", new Contact());
	//		return "index";

	//	}
	@GetMapping("/viewContacts")
	public String viewContacts(Model model) {
		Logger.debug("** viewContacts() Method execution Started**");
		List<Contact> contacts=contactService.getAllContacts();
		model.addAttribute("contacts",contacts);
		Logger.debug("** viewContacts() Method execution ended**");
		return "ViewContacts";
	}

}
