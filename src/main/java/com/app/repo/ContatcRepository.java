package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.ContactDtlsEntity;

public interface ContatcRepository extends JpaRepository<ContactDtlsEntity, Integer> {
	
	

}
