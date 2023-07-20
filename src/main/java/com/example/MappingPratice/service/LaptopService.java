package com.example.MappingPratice.service;


import com.example.MappingPratice.model.Laptop;
import com.example.MappingPratice.repositroy.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    ILaptopRepo iLaptopRepo;

    public List<Laptop> Laptops() {
        return iLaptopRepo.findAll();
    }

    public String createLaptop(Laptop laptop) {
        iLaptopRepo.save(laptop);
        return "new Laptop is added to DB";
    }

    public String removeLaptopById(Long id) {
        iLaptopRepo.deleteById(id);
        return "Laptop is removed from DB by id";
    }

    public Laptop updateLaptop(Long id, Laptop laptop) {
        Laptop existingLaptop = iLaptopRepo.findById(id).orElse(null);
        if(existingLaptop != null){
            existingLaptop.setName(laptop.getName());
            existingLaptop.setBrand(laptop.getBrand());

            return iLaptopRepo.save(existingLaptop);
        }
        return null;

    }
}
