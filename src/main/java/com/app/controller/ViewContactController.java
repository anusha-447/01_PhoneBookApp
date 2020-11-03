package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.Contact;
import com.app.service.IContactService;

@Controller
public class ViewContactController {
	private static final Logger Logger=LoggerFactory.getLogger(ViewContactController.class);
	
	@Autowired
	private IContactService contactService;
	
	@GetMapping("/editContact")
	public String editPageShow(@RequestParam("contact_id") Integer id,Model model) {
		Logger.debug("** editPageShow() method execution started**");
		Contact contact=contactService.getOneContact(id);
		model.addAttribute("contact", contact);
		//System.out.println(contact);
		Logger.debug("** editPageShow() method execution ended**");
		return "index";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("contact_id") Integer id,RedirectAttributes attr) {
		Logger.debug("** deleteContact() method execution started**");
		Boolean status=contactService.deleteContact(id);
		String message="contact is '"+id+"' deleted";
		attr.addFlashAttribute("status",message);
		Logger.info("**contact is '\"+id+\"' deleted**");
		Logger.debug("** deleteContact() method execution ended**");
		return "redirect:/viewContacts";
	}
}
