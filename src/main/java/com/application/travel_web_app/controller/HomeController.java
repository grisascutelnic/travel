package com.application.travel_web_app.controller;

import com.application.travel_web_app.entity.Tour;
import com.application.travel_web_app.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    @Autowired
    private TourService tourService;

    @GetMapping("/index")
    public String getAllTours(Model model) {
        List<Tour> tours = tourService.getAllTours();
        tours.forEach(tour -> tour.setBase64Image(tour.getBase64Image()));
        model.addAttribute("tours", tours);
        return "index";
    }
}
