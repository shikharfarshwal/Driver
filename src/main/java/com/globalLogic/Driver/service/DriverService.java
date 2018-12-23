package com.globalLogic.Driver.service;

import com.globalLogic.Driver.dto.DriverDto;
import com.globalLogic.Driver.model.Driver;
import com.globalLogic.vehicle.model.VehicleSegment;
import com.globalLogic.Driver.repository.DriverRepo;
import com.globalLogic.vehicle.repository.VehicleRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


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


    public List<DriverDto> findAllDrivers(String vehicleType) {
        List<Driver> drivers = driverRepo.findAll();
        List<Driver> driversWithVehicleType = drivers.stream()
                .filter(driver -> driver.getVehicleSegment().getVehicleType().equalsIgnoreCase(vehicleType))
                .collect(Collectors.toList());
        return map.apply(driversWithVehicleType);
    }

    private static Function<List<Driver>, List<DriverDto>> map = (List<Driver> a) -> {
        ModelMapper modelMapper = new ModelMapper();
        PropertyMap<Driver, DriverDto> orderMap = new PropertyMap<Driver, DriverDto>() {
            protected void configure() {
                map().setVehicleType(source.getVehicleSegment().getVehicleType());
            }
        };
        List<DriverDto> driverDtoList = new ArrayList<>();
        for (Driver d : a) {
            DriverDto driverDto = new DriverDto();
            modelMapper.map(d, driverDto);
            driverDtoList.add(driverDto);
        }
        return driverDtoList;
    };
}
