package com.microservice.family.app.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.family.app.documents.Family;
import com.microservice.family.app.services.FamilyServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FamilyController {

	@Autowired
	private FamilyServiceImpl _familyService;
	
	@GetMapping("/")
	public ResponseEntity<Flux<Family>> getAllFamily(@RequestBody Family family){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyService.getAll());
	}
	
	@PostMapping("/")
	public ResponseEntity<Mono<Family>> create(@Valid @RequestBody Family family){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyService.save(family));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Mono<Family>> update(@RequestBody Family family, @PathVariable String id){
		Mono<Family> familyDB = _familyService.getById(id)
				.flatMap(fam -> {
					fam.setFirstName(family.getFirstName());
					fam.setLastName(family.getLastName());
					fam.setGender(family.getGender());
					fam.setBirthdayDate(family.getBirthdayDate());
					fam.setDocType(family.getDocType());
					fam.setDocNumber(family.getDocNumber());
					fam.setIdTitular(family.getIdTitular());
					fam.setFamilyRelationship(family.getFamilyRelationship());
					
					return _familyService.save(fam);
				});
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(familyDB);
	}
	
	@DeleteMapping("/id/{id}")
	public Mono<Void> deleteById(@PathVariable String id){
		return _familyService.deleteById(id);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Mono<Family>> getById(@PathVariable String id){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyService.getById(id));
	}
	
	@GetMapping("/name/{firstName}")
	public ResponseEntity<Flux<Family>> getByFirstName(@PathVariable String firstName){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyService.getByFirstName(firstName));
	}
	
	@GetMapping("/date/{birthdayDate}")
	public ResponseEntity<Flux<Family>> getByBirthdayDate(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate birthdayDate){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyService.getByBirthdayDate(birthdayDate));
	}
	
	@GetMapping("/idTitular/{idTitular}")
	public ResponseEntity<Flux<Family>> getByIdTitular(@PathVariable String idTitular){
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(_familyService.getByIdTitular(idTitular));
	}
	
	
}









