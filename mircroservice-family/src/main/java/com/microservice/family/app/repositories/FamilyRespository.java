package com.microservice.family.app.repositories;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.family.app.documents.Family;

import reactor.core.publisher.Flux;

@Repository
public interface FamilyRespository extends ReactiveMongoRepository<Family, String>{

	Flux<Family> findByFirstName(String firstName);
	Flux<Family> findByBirthdayDate(LocalDate birthdayDate);
	Flux<Family> findByIdTitular(String idTitular);
}
