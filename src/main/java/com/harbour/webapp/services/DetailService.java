package com.harbour.webapp.services;


import com.harbour.webapp.entities.Detail;
import com.harbour.webapp.repositories.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailService {

    private DetailRepository detailRepository;

    @Autowired
    public void setDetailRepository(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public List<Detail> getAllDetails(){
        return detailRepository.findAll();
    }

    public void addDetail(Detail detail){
        detailRepository.save(detail);
    }

    public void deleteDetailById(Long id){
        detailRepository.deleteById(id);
    }

    public Detail getDetailById(Long id){
       return detailRepository.getOne(id);
    }

}
