package com.application.travel_web_app.controller;

import com.application.travel_web_app.entity.Tour;
import com.application.travel_web_app.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Controller
public class TourController {

    @Autowired
    private TourService tourService;

    @RequestMapping("/editTour")
    public String editTour(@RequestParam("id") Long id, Model model) {
        Tour tour = tourService.findById(id);
        model.addAttribute("tour", tour);
        return "edit-tour";
    }

    @PostMapping("/updateTour")
    public String updateTour(@ModelAttribute Tour tour,
                             @RequestParam("imageFile") MultipartFile imageFile) {

            tourService.updateTour(tour, imageFile);
            return "redirect:/index";
    }

    @DeleteMapping("/deleteTour/{id}")
    public String deleteTour(@PathVariable Long id) {
        tourService.deleteTour(id);
        return "redirect:/index";
    }


    @GetMapping("/newTour")
    public String showNewTourForm(Model model) {
        model.addAttribute("tour", new Tour());
        return "new_tour";
    }

    @PostMapping("/saveTour")
    public String saveTour(@ModelAttribute("tour") Tour tour, @RequestParam("imageFile") MultipartFile imageFile) {
        tourService.saveTour(tour, imageFile);
        return "redirect:/index";
    }
    
}
