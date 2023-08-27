package com.org.eureka.directory.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class BusinessController {
	@Autowired
	private BusinessService service;

	@GetMapping()
	public ResponseEntity<List<Business>> getBusinesses(){
		return new ResponseEntity<List<Business>>(service.findAllBusinesses(), HttpStatus.OK);

	}

	@GetMapping("/business")
	public ResponseEntity<Optional<List<Business>>>getBusinessByCategory(@PathVariable Category name){

		return new ResponseEntity<Optional<List<Business>>>(service.findBusinessByCategory(name), HttpStatus.OK);

	};
	@GetMapping("/business/{name}")
	public ResponseEntity<Optional<Business>>getBusiness(@PathVariable String name){

		return new ResponseEntity<Optional<Business>>(service.findBusinessByName(name), HttpStatus.OK);

	};





}
