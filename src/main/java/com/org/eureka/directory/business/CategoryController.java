package com.org.eureka.directory.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired
	private CategoryService service;


	@GetMapping()
	public ResponseEntity<List<Category>> getCategories(){
		return new ResponseEntity<List<Category>>(service.findAllCategories(), HttpStatus.OK);

	};

	@GetMapping("/{name}")
	public ResponseEntity<Category>getCategory(@PathVariable String name){

		return new ResponseEntity<Category>(service.findCategoryByName(name), HttpStatus.OK);

	};


}
