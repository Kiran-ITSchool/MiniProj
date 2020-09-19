package com.pb.miniproj.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.miniproj.phonebook.entity.ContactDtlsEntity;
import com.pb.miniproj.phonebook.model.ContactDtls;
import com.pb.miniproj.phonebook.repo.ContactDtlsRepo;

@Service
public class ContactDtlsServiceImpl implements ContactDtlsService {
	
	@Autowired
	public ContactDtlsRepo contactRepo;

	@Override
	public boolean saveContact(ContactDtls contactDtls) {
		ContactDtlsEntity contactEntity = new ContactDtlsEntity();
		BeanUtils.copyProperties(contactDtls, contactEntity);
		ContactDtlsEntity save = contactRepo.save(contactEntity);
		return save.getContactId() != null;
	}

	@Override
	public List<ContactDtls> getAllContacts() {
		List<ContactDtlsEntity> findAll = contactRepo.findAll();
		return findAll.stream().map(e -> {
			ContactDtls cd = new ContactDtls();
			BeanUtils.copyProperties(e, cd);
			return cd;
		}).collect(Collectors.toList());
	}

	@Override
	public ContactDtls getContactById(Integer id) {
	  Optional<ContactDtlsEntity> findById = contactRepo.findById(id);
	  if (findById.isPresent()) {
		  ContactDtlsEntity contactDtlsEntity = findById.get();
		  ContactDtls cd = new ContactDtls();
		  BeanUtils.copyProperties(contactDtlsEntity, cd);
		  return cd;
	  }
		return null;
	}

	@Override
	public boolean deleteContact(Integer id) {
		contactRepo.deleteById(id);
		return true;
	}

	@Override
	public boolean updateContact(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


}
