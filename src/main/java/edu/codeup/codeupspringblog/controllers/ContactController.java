package edu.codeup.codeupspringblog.controllers;

import edu.codeup.codeupspringblog.model.Contact;
import edu.codeup.codeupspringblog.repositories.ContactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContactController {
//constructor dependency injection
    private ContactRepository contactDao;

    @GetMapping("/contacts")
    @ResponseBody

    public List<Contact> returnContacts(){

    return contactDao.findAll();

    }
}
