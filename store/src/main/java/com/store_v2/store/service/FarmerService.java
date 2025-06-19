package com.store_v2.store.service;

import com.store_v2.store.dto.FarmerRequestDTO;
import com.store_v2.store.dto.FarmerResponseDTO;

import java.util.List;

public interface FarmerService {

    FarmerResponseDTO createFarmer(FarmerRequestDTO dto);
    FarmerResponseDTO getFarmerById(long id);
    List<FarmerResponseDTO> getAllFarmers();
    FarmerResponseDTO updateFarmer(long id, FarmerRequestDTO dto);
    void deleteFarmer(long id);
    FarmerResponseDTO getFarmerByPhone(String phone);
}
