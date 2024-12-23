package com.tutorial.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.rentACar.business.abstracts.ModelService;
import com.tutorial.rentACar.business.requests.CreateModelRequest;
import com.tutorial.rentACar.business.requests.UpdateModelRequest;
import com.tutorial.rentACar.business.responses.GetAllModelsResponse;
import com.tutorial.rentACar.business.responses.GetModelByIdResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
	private ModelService modelService;

	@GetMapping()
	public List<GetAllModelsResponse> getAll() {
		return this.modelService.getAll();
	}

	@GetMapping("/{id}")
	public GetModelByIdResponse getById(int id) {
		return this.modelService.getById(id);
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody() CreateModelRequest createModelRequest) {
		modelService.create(createModelRequest);
	}

	@PatchMapping()
	public void update(UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(int id) {
		this.modelService.delete(id);
	}

}
