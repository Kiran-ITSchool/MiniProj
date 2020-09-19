package com.pb.miniproj.phonebook.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pb.miniproj.phonebook.entity.ContactDtlsEntity;



public interface ContactDtlsRepo extends JpaRepository<ContactDtlsEntity, Serializable> {
	

}
