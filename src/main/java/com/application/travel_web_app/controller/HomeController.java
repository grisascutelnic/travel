package com.application.travel_web_app.controller;

import com.application.travel_web_app.dto.ContactDto;
import com.application.travel_web_app.entity.Tour;
import com.application.travel_web_app.service.ContactService;
import com.application.travel_web_app.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TourService tourService;
    @Autowired
    private ContactService contactService;

    @GetMapping("/index")
    public String indexPage(Model model) {
        List<Tour> tours = tourService.getAllTours();
        tours.forEach(tour -> tour.setBase64Image(tour.getBase64Image()));
        model.addAttribute("tours", tours);
        return "index";
    }
    @GetMapping("/contacts")
    public String contactPage(Model model) {
        List<ContactDto> contacts = contactService.getAllContacts();
        contacts.forEach(contact -> contact.setBase64Image(contact.getBase64Image()));
        model.addAttribute("contacts", contacts);
        return "contacts";
    }
}
