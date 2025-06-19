package com.store_v2.store.repository;

import com.store_v2.store.entity.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {

    Optional<Farmer> findByPhone(String phone);
}
