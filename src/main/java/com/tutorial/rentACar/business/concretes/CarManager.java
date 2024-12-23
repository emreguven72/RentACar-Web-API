package com.tutorial.rentACar.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;

import com.tutorial.rentACar.business.abstracts.CarService;
import com.tutorial.rentACar.business.requests.CreateCarRequest;
import com.tutorial.rentACar.business.responses.GetAllCarsResponse;
import com.tutorial.rentACar.business.responses.GetCarByIdResponse;
import com.tutorial.rentACar.business.rules.CarBusinessRules;
import com.tutorial.rentACar.core.utilities.mappers.ModelMapperService;
import com.tutorial.rentACar.dataAccess.abstracts.CarRepository;
import com.tutorial.rentACar.dataAccess.abstracts.ModelRepository;
import com.tutorial.rentACar.entities.concretes.Car;
import com.tutorial.rentACar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
	private CarRepository carRepository;
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private CarBusinessRules carBusinessRules;

	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();

		List<GetAllCarsResponse> carsResponse = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class)).toList();
		
		return carsResponse;
	}
	
	@Override
	public GetCarByIdResponse getById(int id) {
		Car car = this.carRepository.findById(id).orElseThrow();
		
		GetCarByIdResponse carByIdResponse = modelMapperService.forResponse().map(car, GetCarByIdResponse.class);
		
		return carByIdResponse;
	}

	@Override
	public void create(CreateCarRequest createCarRequest) {
		this.carBusinessRules.checkIfPlateExists(createCarRequest.getPlate());
		
		Model model = modelRepository.findById(createCarRequest.getModelId()).orElseThrow();
		
		Car car = new Car();
		car.setDailyPrice(createCarRequest.getDailyPrice());
		car.setModelYear(createCarRequest.getModelYear());
		car.setPlate(createCarRequest.getPlate());
		car.setState(createCarRequest.getState());
		car.setModel(model);
		
		carRepository.save(car);
	}

}
