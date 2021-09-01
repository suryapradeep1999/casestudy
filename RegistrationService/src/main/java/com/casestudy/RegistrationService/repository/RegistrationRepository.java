package com.casestudy.RegistrationService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.RegistrationService.models.Registration;

public interface RegistrationRepository extends MongoRepository<Registration, String> {

}
