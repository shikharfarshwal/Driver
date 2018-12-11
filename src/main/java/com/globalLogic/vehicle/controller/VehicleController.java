package com.globalLogic.vehicle.controller;

import com.globalLogic.vehicle.Service.VehicleService;
import com.globalLogic.vehicle.model.VehicleSegment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    ResponseEntity<List<VehicleSegment>> getVehicleTypes() {
        return new ResponseEntity<>(vehicleService.getAllVehicleTypes(), HttpStatus.ACCEPTED);
    }

}
