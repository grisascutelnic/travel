package com.application.travel_web_app.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TourDto {
    private Long id;
    private String country;
    private double price;
    private String description;
    private int days;
}