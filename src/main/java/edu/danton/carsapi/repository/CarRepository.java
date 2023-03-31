package edu.danton.carsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.danton.carsapi.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
  
}

