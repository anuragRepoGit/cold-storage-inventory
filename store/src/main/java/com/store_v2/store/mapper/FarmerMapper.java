package com.store_v2.store.mapper;


import com.store_v2.store.dto.FarmerRequestDTO;
import com.store_v2.store.dto.FarmerResponseDTO;
import com.store_v2.store.entity.Farmer;

public class FarmerMapper {

    public static Farmer toEntity(FarmerRequestDTO dto){
        Farmer farmer = new Farmer();
        farmer.setName(dto.getName());
        farmer.setPhone(dto.getPhone());
        farmer.setAddress(dto.getAddress());
        return farmer;
    }

    public static FarmerResponseDTO toResponseDTO(Farmer farmer){
        return new FarmerResponseDTO(
                farmer.getId(), farmer.getName(), farmer.getPhone(), farmer.getAddress()
        );
    }
}
