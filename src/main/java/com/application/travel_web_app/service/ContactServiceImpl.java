package com.application.travel_web_app.service;

import com.application.travel_web_app.dto.ContactDto;
import com.application.travel_web_app.entity.Contact;
import com.application.travel_web_app.exceptions.InternalServerErrorException;
import com.application.travel_web_app.exceptions.NotFoundException;
import com.application.travel_web_app.repository.ContactRepository;
import com.application.travel_web_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ContactDto> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map((contact) -> mapToContactDto(contact))
                .collect(Collectors.toList());
    }

    @Override
    public void saveContact(ContactDto contactDto, MultipartFile imageFile) {
        Contact contact = mapToContact(contactDto, imageFile);
        contactRepository.save(contact);
    }

    @Override
    public void updateContact(ContactDto contactDto, MultipartFile imageFile) {
        Contact contact = contactRepository.findById(contactDto.getId()).orElseThrow(() -> new NotFoundException("Invalid tour id: " + contactDto.getId()));
        mapToContact(contactDto, imageFile, contact);
        //In mod normal functia de sus trebuie sa returne ceva, dar o folosim ca pe void pentru ca
        //deja includem ca parametru obiectul care va fi returnat  (idk :))
        contactRepository.save(contact);
    }

    @Override
    public ContactDto findById(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid tour id: " + id));
        return mapToContactDto(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    private Contact mapToContact(ContactDto contactDto, MultipartFile imageFile) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setPersonalPhone(contactDto.getPersonalPhone());
        contact.setCompanyPhone(contactDto.getCompanyPhone());
        contact.setPersonalEmail(contactDto.getPersonalEmail());
        contact.setCompanyEmail(contactDto.getCompanyEmail());
        contact.setDepartment(contactDto.getDepartment());
        contact.setDescription(contactDto.getDescription());

        if (!imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                contact.setImage(imageBytes);
            } catch (IOException e) {
                throw new InternalServerErrorException("Failed to save image", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            contact.setImage(contact.getImage());
        }

        return contact;
    }
    /* Overload */
    private Contact mapToContact(ContactDto contactDto, MultipartFile imageFile, Contact contact) {
        contact.setName(contactDto.getName());
        contact.setPersonalPhone(contactDto.getPersonalPhone());
        contact.setCompanyPhone(contactDto.getCompanyPhone());
        contact.setPersonalEmail(contactDto.getPersonalEmail());
        contact.setCompanyEmail(contactDto.getCompanyEmail());
        contact.setDepartment(contactDto.getDepartment());
        contact.setDescription(contactDto.getDescription());

        if (!imageFile.isEmpty()) {
            try {
                byte[] imageBytes = imageFile.getBytes();
                contact.setImage(imageBytes);
            } catch (IOException e) {
                throw new InternalServerErrorException("Failed to save image", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            contact.setImage(contact.getImage());
        }

        return contact;
    }

    private ContactDto mapToContactDto(Contact contact) {
        ContactDto contactDto = new ContactDto();
        contactDto.setId(contact.getId());
        contactDto.setName(contact.getName());
        contactDto.setPersonalPhone(contact.getPersonalPhone());
        contactDto.setCompanyPhone(contact.getCompanyPhone());
        contactDto.setPersonalEmail(contact.getPersonalEmail());
        contactDto.setCompanyEmail(contact.getCompanyEmail());
        contactDto.setDepartment(contact.getDepartment());
        contactDto.setDescription(contact.getDescription());
        contactDto.setBase64Image(contact.getBase64Image());
        return contactDto;
    }
}
