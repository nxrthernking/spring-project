package com.harbour.webapp.services;


import com.harbour.webapp.entities.Car;
import com.harbour.webapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
}
