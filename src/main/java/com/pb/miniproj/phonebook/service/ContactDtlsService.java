package com.pb.miniproj.phonebook.service;

import java.util.List;


import com.pb.miniproj.phonebook.model.ContactDtls;

public interface ContactDtlsService {
	
	boolean saveContact(ContactDtls contactDtls);
	List<ContactDtls> getAllContacts();
	ContactDtls getContactById(Integer id);
	boolean deleteContact(Integer id);
	boolean updateContact(Integer id);
}
