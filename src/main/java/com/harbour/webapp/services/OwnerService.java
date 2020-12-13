package com.harbour.webapp.services;

import com.harbour.webapp.entities.Owner;
import com.harbour.webapp.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private OwnerRepository ownerRepository;

    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners(){
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id){
        return ownerRepository.getOne(id);
    }

    public void deleteOwnerById(Long id){
        ownerRepository.deleteById(id);
    }

    public void addOwner(Owner owner){
        ownerRepository.save(owner);
    }
}
