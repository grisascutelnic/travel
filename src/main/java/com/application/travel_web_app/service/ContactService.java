package com.application.travel_web_app.service;

import com.application.travel_web_app.dto.ContactDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ContactService {
    List<ContactDto> getAllContacts();

    void saveContact(ContactDto contactDto, MultipartFile imageFile);

    void updateContact(ContactDto contactDto, MultipartFile imageFile);

    ContactDto findById(Long id);


    void deleteContact(Long id);
}
