package com.example.resource.service;

import com.example.resource.Exception.ResourceNotFoundException;
import com.example.resource.Model.Electricity;
import com.example.resource.Repository.ElectricityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ElectricityServiceImp implements ElectricityService{

    @Autowired
    private ElectricityRepository electricityRepository;

    @Autowired
    public ElectricityServiceImp(ElectricityRepository electricityRepository){
        super();
        this.electricityRepository=electricityRepository;
    }


    @Override
    public Electricity saveElectricity(Electricity electricity) {
        return electricityRepository.save(electricity);
    }

    @Override
    public List<Electricity> getAllElectricityDetails() {
        return electricityRepository.findAll();
    }

    @Override
    public Electricity getElectricityDetailsById(long id) {
        return electricityRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Electricity","Id",id));
    }

    @Override
    public Electricity updateElectricityDetails(Electricity electricity, long id) {
        Electricity existingElectricity = electricityRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Electricity", "Id", id));

        existingElectricity.setRequirenment(electricity.getRequirenment());

        electricityRepository.save(existingElectricity);
        return existingElectricity;
    }

    @Override
    public void deleteElectricityDetails(long id) {
        electricityRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Electricity", "Id", id));
        electricityRepository.deleteById(id);


    }
}
