package com.application.travel_web_app.repository;

import com.application.travel_web_app.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {

    void findById(long id);
}
