package com.cumuluscycles.contacts.service;

import com.cumuluscycles.contacts.dao.ContactDAO;
import com.cumuluscycles.contacts.model.Contact;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDAO contactDAO;

    public Contact addContact(Contact contact) {
        return contactDAO.save(contact);
    }

    public Contact getContactById(long contactId) {
        return contactDAO.findById(contactId).orElseThrow(() ->
                new RuntimeException("Contact not found.")
        );
    }

    public List<Contact> getContacts() {
        return contactDAO.findAll();
    }

    public Contact updateContact(long contactId, Contact contact) {
        Contact existingContact = contactDAO.findById(contactId).orElseThrow(() ->
                new RuntimeException("Contact not found.")
        );
        existingContact.setName(contact.getName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setCell(contact.getCell());

        contactDAO.save(existingContact);
        return existingContact;
    }

    public Contact deleteContact (long contactId) {
        Contact existingContact = contactDAO.findById(contactId).orElseThrow(() ->
                new RuntimeException("Contact not found.")
        );
        contactDAO.deleteById(contactId);
        return existingContact;
    }
}
