package com.example.MappingPratice.controller;

import com.example.MappingPratice.model.Laptop;
import com.example.MappingPratice.model.Student;
import com.example.MappingPratice.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @GetMapping("Laptops")
    public List<Laptop> Laptops(){
        return laptopService.Laptops();
    }
    @PostMapping("Laptop")
    public String createLaptop(@RequestBody Laptop laptop){
        return laptopService.createLaptop(laptop);
    }

//    @GetMapping("Laptops")
//    @PostMapping("Laptop")
//    @PutMapping("updateLaptop/{LaptopId}")
//    @DeleteMapping("removeLaptop/{LaptopId}")
    @PutMapping("updateLaptop/{LaptopId}")
    public ResponseEntity<Laptop> updatedLaptop(@PathVariable Long id, @RequestBody Laptop laptop){
        Laptop updatedLaptop = laptopService.updateLaptop(id,laptop);
        if(updatedLaptop != null){
            return ResponseEntity.ok(updatedLaptop);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("removeLaptop/{id}")
    public String removeLaptopById(@PathVariable Long id){
        return laptopService.removeLaptopById(id);
    }

}
