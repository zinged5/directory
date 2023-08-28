package com.org.eureka.directory.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/businesses")
public class BusinessController {
	@Autowired
	private BusinessService service;

	@Autowired
	private CategoryService categoryService;

//	@GetMapping()
//	public ResponseEntity<List<Business>> getBusinesses(){
//		return new ResponseEntity<List<Business>>(service.findAllBusinesses(), HttpStatus.OK);
//
//	}
	@GetMapping()
	public List<Business> getBusinesses(){
		return service.findAllBusinesses();

	}

//	@GetMapping("/")
//	public ResponseEntity<Optional<List<Business>>>getBusinessByCategory(@PathVariable String name){
//		Category cname= categoryService.findBusinessByCategory(name);
//		return new ResponseEntity<Optional<List<Business>>>(service.findBusinessByCategory(Category name), HttpStatus.OK);
//
//	};
	@GetMapping("/{name}")
	public ResponseEntity<Optional<Business>>getBusiness(@PathVariable String name){

		return new ResponseEntity<Optional<Business>>(service.findBusinessByName(name), HttpStatus.OK);

	};
	@GetMapping("/{categoryName}/listings")
	public ResponseEntity<List<Business>>getBusinessByCategory(@PathVariable String categoryName){

		return new ResponseEntity<List<Business>>(service.findBusinessesByCategory(categoryName), HttpStatus.OK);

	};







}
