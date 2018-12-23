package com.globalLogic.Driver.model;

import com.globalLogic.vehicle.model.VehicleSegment;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String dlNo;

    @Column(unique = true)
    private String registrationNo;

    @OneToOne
    private VehicleSegment vehicleSegment;


    public Driver(String firstName, String lastName, String dlNo, String registrationNo, VehicleSegment vehicleSegment) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.dlNo = dlNo;
        this.registrationNo = registrationNo;
        this.vehicleSegment = vehicleSegment;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }


    public VehicleSegment getVehicleSegment() {
        return vehicleSegment;
    }

    public void setVehicleSegment(VehicleSegment vehicleSegment) {
        this.vehicleSegment = vehicleSegment;
    }

    public Driver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDlNo() {
        return dlNo;
    }

    public void setDlNo(String dlNo) {
        this.dlNo = dlNo;
    }

}
