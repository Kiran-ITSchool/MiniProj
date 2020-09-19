package com.pb.miniproj.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pb.miniproj.phonebook.model.ContactDtls;
import com.pb.miniproj.phonebook.service.ContactDtlsServiceImpl;

@Controller
public class ViewContactsController {
	
	@Autowired
	public ContactDtlsServiceImpl contactService;
	

	@GetMapping("/editContact")
	public String editContact(@RequestParam("id") Integer id, Model model) {
		ContactDtls contactById = contactService.getContactById(id);
		model.addAttribute("contact", contactById);
		return "contactForm";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("id") Integer id) {
		boolean deleteContact = contactService.deleteContact(id);
		if (deleteContact) {
			return "redirect:/viewContact";
		}
		return null;
	}
	

}
