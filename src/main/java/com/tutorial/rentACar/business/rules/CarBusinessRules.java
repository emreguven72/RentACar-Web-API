package com.tutorial.rentACar.business.rules;

import org.springframework.stereotype.Service;

import com.tutorial.rentACar.core.utilities.exceptions.BusinessException;
import com.tutorial.rentACar.dataAccess.abstracts.CarRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarBusinessRules {
	private CarRepository carRepository;
	
	public void checkIfPlateExists(String plate) {
		if(this.carRepository.existsByPlate(plate)) {
			throw new BusinessException("Plate already exists");
		}
	}
}
