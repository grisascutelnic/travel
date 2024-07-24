package com.application.travel_web_app.service;

import com.application.travel_web_app.entity.Tour;
import com.application.travel_web_app.exceptions.NotFoundException;
import com.application.travel_web_app.repository.TourRepository;
import com.application.travel_web_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class TourServiceImpl implements TourService{

    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour findById(Long id) {
        return tourRepository.findById(id).orElse(null);
    }

    @Override
    public void updateTour(Tour updatedTour, MultipartFile imageFile) {
        Tour tour = tourRepository.findById(updatedTour.getId()).orElseThrow(() -> new IllegalArgumentException("invalid tour id" + updatedTour.getId()));
        tour.setCountry(updatedTour.getCountry());
        tour.setDescription(updatedTour.getDescription());
        tour.setPrice(updatedTour.getPrice());
        tour.setDays(updatedTour.getDays());

        //Verificam daca imaginea este modificata sau ramane acea din turul precedent
        if (!imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                tour.setImage(imageBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            tour.setImage(tour.getImage());
        }

        tourRepository.save(tour);
    }

    public void deleteTour(Long id) {
        if(tourRepository.existsById(id)) {
            tourRepository.deleteById(id);
        } else {
            throw new NotFoundException("Not found a rental with id: " + id);
        }
    }

    @Override
    public void saveTour(Tour tour, MultipartFile imageFile) {
        Tour newTour = new Tour();
        newTour.setCountry(tour.getCountry());
        newTour.setDescription(tour.getDescription());
        newTour.setPrice(tour.getPrice());
        newTour.setDays(tour.getDays());

        try {
            if (!imageFile.isEmpty()) {
                newTour.setImage(imageFile.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tourRepository.save(newTour);
    }
}
