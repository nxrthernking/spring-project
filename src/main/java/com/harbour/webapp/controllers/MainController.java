package com.harbour.webapp.controllers;

import com.harbour.webapp.entities.Car;
import com.harbour.webapp.entities.Owner;
import com.harbour.webapp.services.CarService;
import com.harbour.webapp.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

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

    @GetMapping("/homepage")
    public String homePage(){
        return "homepage";
    }

    @GetMapping("/cars")
    public String carsPage(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars",cars);
        return "cars";
    }

    @GetMapping("/owners")
    public String ownersPage(Model model){
        List<Owner> owners = ownerService.getAllOwners();
        model.addAttribute("owners",owners);
        return "owners";
    }


    @GetMapping("/owner/info/{id}")
    public String ownerInfoPage(Model model, @PathVariable(name = "id") Long id){
        Owner owner = ownerService.getOwnerById(id);
        model.addAttribute("owner",owner);
        return "owner-details";
    }

}
