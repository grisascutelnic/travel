package com.application.travel_web_app.controller;

import com.application.travel_web_app.dto.TourDto;
import com.application.travel_web_app.entity.Tour;
import com.application.travel_web_app.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
public class TourController {

    @Autowired
    private TourService tourService;


    @GetMapping("/tours")
    public String getAllTours(Model model) {
        List<Tour> tours = tourService.getAllTours();
        model.addAttribute("tours", tours);
        return "index";
    }

    @GetMapping("/newTour")
    public String showNewTourForm(Model model) {
        model.addAttribute("tourDto", new TourDto());
        return "new_tour";
    }

    @PostMapping("/saveTour")
    public String saveTour(@ModelAttribute("tourDto") TourDto tourDto, @RequestParam("imageFile") MultipartFile imageFile) {
        try {
            if (!imageFile.isEmpty()) {
                tourDto.setImage(imageFile.getBytes());
            }
            tourService.saveTour(tourDto);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error
        }
        return "redirect:/index";
    }

    @GetMapping("/tour/{id}")
    public String getTour(@PathVariable Long id, Model model) {
        Tour tour = tourService.findById(id);
        String base64Image = Base64.getEncoder().encodeToString(tour.getImage());
        model.addAttribute("tour", tour);
        model.addAttribute("base64Image", base64Image);
        return "tour";
    }

}
