package com.tutorial.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.rentACar.entities.concretes.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
