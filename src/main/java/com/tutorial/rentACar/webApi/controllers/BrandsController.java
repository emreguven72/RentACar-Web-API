package com.tutorial.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.rentACar.business.abstracts.BrandService;
import com.tutorial.rentACar.business.requests.CreateBrandRequest;
import com.tutorial.rentACar.business.requests.UpdateBrandRequest;
import com.tutorial.rentACar.business.responses.GetAllBrandsResponse;
import com.tutorial.rentACar.business.responses.GetBrandByIdResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@CrossOrigin(origins = "*")
	@GetMapping()
	public List<GetAllBrandsResponse> getAll() {
		return this.brandService.getAll();
	}

	@GetMapping("/{id}")
	public GetBrandByIdResponse getById(int id) {
		return this.brandService.getById(id);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody() @Valid() CreateBrandRequest request) {
		this.brandService.create(request);
	}

	@PutMapping()
	public void update(UpdateBrandRequest request) {
		System.out.println(request);
		this.brandService.update(request);
	}

	@DeleteMapping("/{id}")
	public void delete(int id) {
		this.brandService.delete(id);
	}

}
