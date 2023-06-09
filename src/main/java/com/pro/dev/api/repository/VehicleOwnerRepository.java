package com.pro.dev.api.repository;

import com.pro.dev.api.entity.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner, Long> {
    VehicleOwner getByEmail(String email);
}
