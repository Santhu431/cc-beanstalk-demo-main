package com.cumuluscycles.contacts.dao;

import com.cumuluscycles.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDAO  extends JpaRepository<Contact, Long> { }
