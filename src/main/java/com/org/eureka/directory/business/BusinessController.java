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

	@Autowired
	private CategoryService categoryService;

	@GetMapping()
	public List<Business> getBusinesses(){
		return service.findAllBusinesses();

	}

	@GetMapping("/{name}")
	public ResponseEntity<Optional<Business>>getBusiness(@PathVariable String name){

		return new ResponseEntity<Optional<Business>>(service.findBusinessByName(name), HttpStatus.OK);

	};
	@GetMapping("/{categoryName}/listings")
	public ResponseEntity<List<Business>>getBusinessByCategory(@PathVariable String categoryName){

		return new ResponseEntity<List<Business>>(service.findBusinessesByCategory(categoryName), HttpStatus.OK);

	};







}
