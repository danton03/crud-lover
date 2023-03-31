package edu.danton.carsapi.controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.danton.carsapi.dto.CarDTO;
import edu.danton.carsapi.model.Car;
import edu.danton.carsapi.repository.CarRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
  @Autowired
  private CarRepository repository;

  @GetMapping
  public List<Car> listAllCars() {
    return repository.findAll();
  }

  @PostMapping
  public void createCar(@RequestBody @Valid CarDTO car) {
    repository.save(new Car(car));
  }

  @DeleteMapping("/{id}")
  public void deleteCar(@PathVariable Long id) {
    repository.deleteById(id);
  }

  @PutMapping("/{id}")
  public void updateCar(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
    repository.findById(id).map((Function<? super Car, ? extends Car>) r -> {
      r.setModelo(req.modelo());
      r.setFabricante(req.fabricante());
      r.setDataFabricacao(req.dataFabricacao());
      r.setValor(req.valor());
      r.setAnoModelo(req.anoModelo());
      return repository.save(r);
    });
  }
}
