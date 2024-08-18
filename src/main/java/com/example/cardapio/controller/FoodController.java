package com.example.cardapio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import food.Food;
import food.FoodRepository;
import food.FoodResponseDTO;

@RestController
@RequestMapping("food")
public class FoodController {
	
	@Autowired
	private FoodRepository repository;
	
	@PostMapping
	public void saveFood(@RequestBody FoodResponseDTO data) {
		Food foodData = new Food(data);
		repository.save(foodData);
	}
	
	@GetMapping
	public List<FoodResponseDTO> getAll() {
		List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).collect(Collectors.toList());
		return foodList;
	}
}
