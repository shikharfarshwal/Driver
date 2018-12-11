package com.globalLogic.Driver.controller;

import com.globalLogic.Driver.dto.DriverDto;
import com.globalLogic.Driver.model.Driver;
import com.globalLogic.Driver.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @RequestMapping(value="/register",method = RequestMethod.POST,consumes ="application/json")
    public void registerDriver(@RequestBody DriverDto driverDto) {
        driverService.registerDriver(driverDto);
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.findAllDrivers();
    }
}
