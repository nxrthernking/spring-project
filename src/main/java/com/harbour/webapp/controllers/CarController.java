package com.harbour.webapp.controllers;


import com.harbour.webapp.entities.Car;
import com.harbour.webapp.entities.Owner;
import com.harbour.webapp.services.CarService;
import com.harbour.webapp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarController {

    private CarService carService;

    private OwnerService ownerService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/cars")
    public String carsPage(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars",cars);
        return "cars";
    }

    @GetMapping("/car/info/{id}")
    public String carInfoPage(Model model, @PathVariable(name = "id") Long id){
        Car selectedCar = carService.getCarById(id);
        model.addAttribute("car",selectedCar);
        return "car-details";
    }

    @GetMapping("/car/delete/{id}")
    public String deleteCarById(@PathVariable(name = "id") Long id){
        carService.deleteCarById(id);
        return "redirect:/cars";
    }

    @RequestMapping(value = "/car/add/{id}",method = RequestMethod.GET)
    public String carAddPage(Model model, @PathVariable(name = "id") Long id){
        Owner owner = ownerService.getOwnerById(id);
        Car car = new Car();
        car.setOwner(owner);
        model.addAttribute("car",car);
        return "car-add";
    }

    @RequestMapping(value = "/car/add",method = RequestMethod.POST)
    public String carAddSubmit(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/cars";
    }

    @RequestMapping(value = "/car/edit/{id}",method = RequestMethod.GET)
    public String carEditPage(Model model,@PathVariable(name = "id") Long id){
        Car selectedCar = carService.getCarById(id);
        model.addAttribute("car",selectedCar);
        return "car-edit";
    }

    @RequestMapping(value = "/car/edit",method = RequestMethod.POST)
    public String carEditSubmit(@ModelAttribute Car car){
        carService.addCar(car);
        return "redirect:/cars";
    }


}
