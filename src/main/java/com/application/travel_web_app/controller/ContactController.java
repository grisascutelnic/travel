package com.application.travel_web_app.controller;

import com.application.travel_web_app.dto.ContactDto;
import com.application.travel_web_app.entity.Contact;
import com.application.travel_web_app.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/newContact")
    public String showNewContactForm(Model model) {
        model.addAttribute("contactDto", new ContactDto());
        return "new-contact";
    }

    @PostMapping("/saveContact")
    public String saveContact(@ModelAttribute("contactDto") ContactDto contactDto, @RequestParam("imageFile") MultipartFile imageFile) {
        contactService.saveContact(contactDto, imageFile);
        return "redirect:/contacts";
    }

    @GetMapping("/editContact")
    public String showEditContactForm(@RequestParam("id") Long id, Model model) {
        ContactDto contactDto = contactService.findById(id);
        model.addAttribute("contactDto", contactDto);
        return "edit-contact";
    }

    @PostMapping("/updateContact")
    public String updateContact(@ModelAttribute("contactDto") ContactDto contactDto, @RequestParam("imageFile") MultipartFile imageFile) {
        contactService.updateContact(contactDto, imageFile);
        return "redirect:/contacts";
    }

    @DeleteMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }
}
