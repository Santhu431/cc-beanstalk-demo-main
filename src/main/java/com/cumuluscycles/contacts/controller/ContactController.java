package com.cumuluscycles.contacts.controller;

import com.cumuluscycles.contacts.model.Contact;
import com.cumuluscycles.contacts.service.ContactService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @GetMapping("/contact")
    public ResponseEntity<Contact> getContactById(@RequestParam(name = "contactId") long contactId) {
        Contact contact = contactService.getContactById(contactId);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        Contact newContact = contactService.addContact(contact);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @PatchMapping("/contact")
    public ResponseEntity<Contact> updateContact(@RequestParam(name = "contactId") long contactId, @RequestBody Contact contact) {
        Contact updatedContact = contactService.updateContact(contactId, contact);
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    @DeleteMapping("/contact")
    public ResponseEntity<Contact> deleteContact(long contactId) {
        Contact deletedContact = contactService.deleteContact(contactId);
        return new ResponseEntity<>(deletedContact, HttpStatus.OK);
    }
}
