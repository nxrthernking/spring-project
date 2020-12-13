package com.harbour.webapp.controllers;


import com.harbour.webapp.entities.Detail;
import com.harbour.webapp.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DetailController {

    private DetailService detailService;

    @Autowired
    public void setDetailService(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/details")
    public String detailsPage(Model model){
        List<Detail> details = detailService.getAllDetails();
        model.addAttribute("details",details);
        return "details";
    }

    @GetMapping("/detail/delete/{id}")
    public String deleteDetailById(@PathVariable(name = "id") Long id){
        detailService.deleteDetailById(id);
        return "redirect:/details";
    }

    @RequestMapping(value = "/detail/add",method = RequestMethod.GET)
    public String addDetailPage(Model model){
        model.addAttribute("detail",new Detail());
        return "detail-add";
    }

    @RequestMapping(value = "/detail/add",method = RequestMethod.POST)
    public String addDetailSubmit(@ModelAttribute Detail detail){
        detailService.addDetail(detail);
        return "redirect:/details";
    }

}
