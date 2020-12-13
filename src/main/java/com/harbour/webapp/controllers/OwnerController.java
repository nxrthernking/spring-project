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
public class OwnerController {

    private OwnerService ownerService;

    private CarService carService;

    @Autowired
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
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

    @RequestMapping(value = "/owner/add",method = RequestMethod.GET)
    public String ownerAddPage(Model model){
        model.addAttribute("owner",new Owner());
        return "owner-add";
    }

    @RequestMapping(value = "/owner/add",method = RequestMethod.POST)
    public String ownerAddSubmit(@ModelAttribute Owner owner){
        ownerService.addOwner(owner);
        return "redirect:/owners";
    }

    @GetMapping("/owner/delete/{id}")
    public String deleteOwner(@PathVariable(name = "id") Long id){
        ownerService.deleteOwnerById(id);
        return "redirect:/owners";
    }

    @RequestMapping(value = "/owner/edit/{id}",method = RequestMethod.GET)
    public String ownerEditPage(Model model, @PathVariable(name = "id") Long id){
        Owner selectedOwner = ownerService.getOwnerById(id);
        model.addAttribute("owner",selectedOwner);
        return "owner-edit";
    }

    @RequestMapping(value = "/owner/edit",method = RequestMethod.POST)
    public String ownerEditSubmit(@ModelAttribute Owner owner){
        ownerService.addOwner(owner);
        return "redirect:/owners";
    }
}
