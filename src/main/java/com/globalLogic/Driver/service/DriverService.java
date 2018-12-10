package com.globalLogic.Driver.service;

import com.globalLogic.Driver.dto.DriverDto;
import com.globalLogic.Driver.model.Driver;
import com.globalLogic.vehicle.model.VehicleSegment;
import com.globalLogic.Driver.repository.DriverRepo;
import com.globalLogic.vehicle.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DriverService {

    DriverRepo driverRepo;

    VehicleRepo vehicleRepo;

    @Autowired
    public DriverService(DriverRepo driverRepo, VehicleRepo vehicleRepo) {
        this.driverRepo = driverRepo;
        this.vehicleRepo = vehicleRepo;
    }

    public void registerDriver(DriverDto driverDto) {
        List<VehicleSegment> vehicleSegmentList = vehicleRepo.findAll();
        Optional<VehicleSegment> first = vehicleSegmentList.stream()
                .filter(vs -> vs.getVehicleType().equalsIgnoreCase(driverDto.getVehicleType()))
                .findFirst();
        if (first.isPresent()) {
            Driver driver = setDriver(driverDto, first.get());
            Driver persistedDriver = driverRepo.save(driver);
        }
    }

    private Driver setDriver(DriverDto driverDto, VehicleSegment vehicleSegment) {
        Driver driver = new Driver();
        driver.setFirstName(driverDto.getFirstName());
        driver.setLastName(driverDto.getLastName());
        driver.setDlNo(driverDto.getDlNo());
        driver.setVehicleSegment(vehicleSegment);
        return driver;
    }

    public List<Driver> findAllDrivers() {
        return driverRepo.findAll();
    }

}
