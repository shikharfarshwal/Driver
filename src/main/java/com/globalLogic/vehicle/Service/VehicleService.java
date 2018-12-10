package com.globalLogic.vehicle.Service;

import com.globalLogic.vehicle.model.VehicleSegment;
import com.globalLogic.vehicle.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;

    public List<VehicleSegment> getAllVehicleTypes(){
        return vehicleRepo.findAll();
    }

}
