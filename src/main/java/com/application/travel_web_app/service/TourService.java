package com.application.travel_web_app.service;

import com.application.travel_web_app.dto.TourDto;
import com.application.travel_web_app.entity.Tour;

import java.util.List;

public interface TourService {

    void saveTour(TourDto tourDto);

    List<Tour> getAllTours();

    Tour findById(Long id);

//    Tour findById(Long id);
//    List<TourDto> getAllTours();
//    void deleteTourById(Long id);
//    void updateTour(TourDto tourDto);

}
