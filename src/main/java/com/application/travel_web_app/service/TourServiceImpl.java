package com.application.travel_web_app.service;

import com.application.travel_web_app.dto.TourDto;
import com.application.travel_web_app.entity.Tour;
import com.application.travel_web_app.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService{

    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour findById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    public void saveTour(TourDto tourDto) {
        Tour tour = new Tour();
        tour.setCountry(tourDto.getCountry());
        tour.setPrice(tourDto.getPrice());
        tour.setDescription(tourDto.getDescription());
        tour.setDays(tourDto.getDays());
        tour.setImage(tourDto.getImage());
        tourRepository.save(tour);
    }
}
