package com.pb.miniproj.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pb.miniproj.phonebook.model.ContactDtls;
import com.pb.miniproj.phonebook.service.ContactDtlsServiceImpl;

@Controller
public class contactInfoController {
	
	@Autowired
	public ContactDtlsServiceImpl contactService;
	
	@GetMapping({"/", "/addContact"})
	public String loadContactForm(Model model) {
		ContactDtls contactDtls = new ContactDtls();
		model.addAttribute("contact", contactDtls);
		return "contactForm";
	}
	
	@PostMapping("/saveContact")
	public String handleSubmitButton(@ModelAttribute("contact") ContactDtls contact, RedirectAttributes attribute) {
		boolean saveContact = contactService.saveContact(contact);
		if (saveContact) {
			attribute.addFlashAttribute("SuccessMsg", "Contact Successfully Created");
		} else {
			attribute.addFlashAttribute("errMsg", "Contact Not Successfully Created");
		}
		return "redirect:/addContact";
	}

	@GetMapping("/viewContact")
	public String handleViewAllContactsLink(Model model) {
		List<ContactDtls> allContacts = contactService.getAllContacts();
		model.addAttribute("contact", allContacts);
		return "viewContacts";
	}

}
