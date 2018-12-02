package com.globalLogic.Driver.repository;

import com.globalLogic.Driver.model.VehicleSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicleRepo extends JpaRepository<VehicleSegment, Long> {
}
