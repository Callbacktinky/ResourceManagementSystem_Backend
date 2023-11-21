package com.example.resource.service;

import com.example.resource.Model.Electricity;

import java.util.List;

public interface ElectricityService  {
    Electricity saveElectricity(Electricity electricity);

    List<Electricity> getAllElectricityDetails();

    Electricity getElectricityDetailsById(long id);

    Electricity updateElectricityDetails(Electricity electricity,long id);

    void  deleteElectricityDetails(long id);
}
