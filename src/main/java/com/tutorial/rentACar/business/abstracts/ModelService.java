package com.tutorial.rentACar.business.abstracts;

import java.util.List;

import com.tutorial.rentACar.business.requests.CreateModelRequest;
import com.tutorial.rentACar.business.requests.UpdateModelRequest;
import com.tutorial.rentACar.business.responses.GetAllModelsResponse;
import com.tutorial.rentACar.business.responses.GetModelByIdResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	GetModelByIdResponse getById(int id);
	void create(CreateModelRequest createModelRequest);
	void update(UpdateModelRequest updateModelRequest);
	void delete(int id);
	
}
