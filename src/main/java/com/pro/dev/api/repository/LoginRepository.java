package com.pro.dev.api.repository;

import com.pro.dev.api.entity.Farmer;
import com.pro.dev.api.entity.FarmerLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<FarmerLogin, Long> {
}
