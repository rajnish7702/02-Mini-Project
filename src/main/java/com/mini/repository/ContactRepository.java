package com.mini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mini.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer>{
	public List<Contact> findByActiveSw(String status);
}