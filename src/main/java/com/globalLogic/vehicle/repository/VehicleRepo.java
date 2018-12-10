package com.globalLogic.vehicle.repository;

import com.globalLogic.vehicle.model.VehicleSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepo extends JpaRepository<VehicleSegment, Long> {
}
