package com.example.MappingPratice.service;

import com.example.MappingPratice.model.Address;
import com.example.MappingPratice.repositroy.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepo iAddressRepo;

    public List<Address> AllAddresss() {
        return iAddressRepo.findAll();
    }

    public String createAddress(Address address) {
        iAddressRepo.save(address);
        return "Address added to DB";
    }

    public String removeAddressById(Long id) {
        iAddressRepo.deleteById(id);
        return "removed addres by id from DB";
    }


    public Address updateAddress(Long id, Address address) {
        Address existingAddress = iAddressRepo.findById(id).orElse(null);
        if(existingAddress != null){
            existingAddress.setLandmark(address.getLandmark());
            existingAddress.setZipcode(address.getZipcode());

            return iAddressRepo.save(existingAddress);
        }
        return null;

    }
}
