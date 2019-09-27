package com.microservice.family.app.services;

import java.time.LocalDate;

import com.microservice.family.app.documents.Family;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IFamilyService {

	public Flux<Family> getAll();
	public Mono<Family> save(Family family); //crear y modificar
	public Mono<Void> deleteById(String id);
	public Mono<Family> getById(String id);
	public Flux<Family> getByFirstName(String firstName);
	public Flux<Family> getByBirthdayDate(LocalDate birthdayDate);
	public Flux<Family> getByIdTitular(String idTitular);
	
}
