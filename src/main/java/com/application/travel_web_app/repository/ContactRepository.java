package com.application.travel_web_app.repository;

import com.application.travel_web_app.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
