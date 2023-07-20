package com.example.MappingPratice.controller;

import com.example.MappingPratice.model.Address;
import com.example.MappingPratice.model.Student;
import com.example.MappingPratice.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("Addresss")
    public List<Address> AllAddresss(){
        return addressService.AllAddresss();
    }

    @PostMapping("Address")
    public String createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }


    @PutMapping("updateAddress/{Id}")
    private ResponseEntity<Address> updateAddress(@RequestBody Address address, @PathVariable Long id ){
        Address updatedAddress = addressService.updateAddress(id,address);
        if(updatedAddress != null){
            return ResponseEntity.ok(updatedAddress);
        }else {
            return ResponseEntity.notFound().build();
        }
    }


//    @DeleteMapping("removeAddress/{AddressId}")

    @DeleteMapping("removeAddress/{AddressId}")
    public String removeAddressById(@PathVariable Long id){
        return addressService.removeAddressById(id);
    }
}
