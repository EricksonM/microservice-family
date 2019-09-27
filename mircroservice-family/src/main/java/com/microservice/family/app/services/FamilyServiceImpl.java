package com.microservice.family.app.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.family.app.documents.Family;
import com.microservice.family.app.repositories.FamilyRespository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FamilyServiceImpl implements IFamilyService {

	@Autowired
	private FamilyRespository _familyRepo;
	
	@Override
	public Flux<Family> getAll() {
		return _familyRepo.findAll();
	}

	@Override
	public Mono<Family> save(Family family) {
		return _familyRepo.save(family);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return _familyRepo.deleteById(id);
	}

	@Override
	public Mono<Family> getById(String id) {
		return _familyRepo.findById(id);
	}

	@Override
	public Flux<Family> getByFirstName(String firstName) {
		return _familyRepo.findByFirstName(firstName);
	}

	@Override
	public Flux<Family> getByBirthdayDate(LocalDate birthdayDate) {
		return _familyRepo.findByBirthdayDate(birthdayDate);
	}

	@Override
	public Flux<Family> getByIdTitular(String idTitular) {
		return _familyRepo.findByIdTitular(idTitular);
	}

}
