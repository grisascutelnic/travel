package com.application.travel_web_app.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Base64;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
    private Long id;
    private String name;
    private String department;
    private String companyPhone;
    private String personalPhone;
    private String companyEmail;
    private String personalEmail;
    private String description;
    private String base64Image;
}