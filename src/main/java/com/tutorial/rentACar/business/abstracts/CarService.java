package com.tutorial.rentACar.business.abstracts;

import java.util.List;

import com.tutorial.rentACar.business.requests.CreateCarRequest;
import com.tutorial.rentACar.business.requests.UpdateCarRequest;
import com.tutorial.rentACar.business.responses.GetAllCarsResponse;
import com.tutorial.rentACar.business.responses.GetCarByIdResponse;

public interface CarService {
	List<GetAllCarsResponse> getAll();
	GetCarByIdResponse getById(int id);
	void create(CreateCarRequest createCarRequest);
	void update(UpdateCarRequest updateCarRequest);
	void delete(int id);
}
