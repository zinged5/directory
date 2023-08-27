package com.org.eureka.directory.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;

	public List<Category> findAllCategories() {
		return repository.findAll();
	}
	public Optional<Business> findCategoryByName(Category name) {
		return repository.findCategoryByName(name);
	};

}
