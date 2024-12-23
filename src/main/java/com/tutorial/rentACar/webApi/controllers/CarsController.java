package com.tutorial.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.rentACar.business.abstracts.CarService;
import com.tutorial.rentACar.business.requests.CreateCarRequest;
import com.tutorial.rentACar.business.requests.UpdateCarRequest;
import com.tutorial.rentACar.business.responses.GetAllCarsResponse;
import com.tutorial.rentACar.business.responses.GetCarByIdResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarsController {
	private CarService carService;

	@GetMapping()
	public List<GetAllCarsResponse> getAll() {
		return this.carService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetCarByIdResponse getById(int id) {
		return this.carService.getById(id);
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody() CreateCarRequest createCarRequest) {
		this.carService.create(createCarRequest);
	}
	
	@PutMapping()
	public void update(@RequestBody() UpdateCarRequest updateCarRequest) {
		this.carService.update(updateCarRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		this.carService.delete(id);
	}
	
}
