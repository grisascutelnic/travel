package com.application.travel_web_app.service;

import com.application.travel_web_app.entity.Tour;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TourService {

//    void saveTour(tour tour);

    List<Tour> getAllTours();

    Tour findById(Long id);

    void updateTour(Tour tour, MultipartFile fileImage);

    void deleteTour(Long id);

    void saveTour(Tour tour, MultipartFile fileImage);
}
