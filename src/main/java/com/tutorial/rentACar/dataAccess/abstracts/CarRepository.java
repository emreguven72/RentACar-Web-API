package com.tutorial.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.rentACar.entities.concretes.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	boolean existsByPlate(String plate);
}
