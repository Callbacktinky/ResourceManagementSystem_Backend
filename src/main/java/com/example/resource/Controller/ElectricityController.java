package com.example.resource.Controller;

import com.example.resource.Model.Electricity;

import com.example.resource.service.ElectricityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/electricity")
public class ElectricityController {
     @Autowired
     private ElectricityService electricityService;

    @Autowired
    public ElectricityController(ElectricityService electricityService) {
        super();
        this.electricityService =  electricityService;
    }

    //build create SignUp REST API

    @PostMapping("/post")
    public ResponseEntity<Electricity> saveElectricity(@RequestBody Electricity electricity) {
        return new ResponseEntity<>(electricityService.saveElectricity(electricity), HttpStatus.CREATED);

    }


    // build get all SignUP REST API
    @GetMapping("/get")
    public List<Electricity> getAllElectricityDetails() {
        return electricityService.getAllElectricityDetails();

    }


    // build get SignUp by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Electricity> getElectricityDetailsById(@PathVariable("id") long electricityId) {
        return new ResponseEntity<Electricity>(electricityService.getElectricityDetailsById(electricityId), HttpStatus.OK);
    }

    //build Update signUp REST API

    @PutMapping("{id}")
    public ResponseEntity<Electricity> updateElectricityDetails(@PathVariable("id") long id
            , @RequestBody Electricity electricity) {
        return new ResponseEntity<Electricity>(electricityService.updateElectricityDetails(electricity, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteElectricityDetails(@PathVariable("id") long id) {
        electricityService.deleteElectricityDetails(id);
        return new ResponseEntity<>(" Details Deleted Successfully", HttpStatus.OK);


    }

}
