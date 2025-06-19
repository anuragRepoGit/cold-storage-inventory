package com.store_v2.store.serviceImpl;

import com.store_v2.store.dto.FarmerRequestDTO;
import com.store_v2.store.dto.FarmerResponseDTO;
import com.store_v2.store.entity.Farmer;
import com.store_v2.store.mapper.FarmerMapper;
import com.store_v2.store.repository.FarmerRepository;
import com.store_v2.store.service.FarmerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FarmerServiceImpl implements FarmerService {

    private FarmerRepository farmerRepository;

    public FarmerServiceImpl(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    @Override
    public FarmerResponseDTO createFarmer(FarmerRequestDTO dto) {
        Farmer farmer = FarmerMapper.toEntity(dto);
        Farmer saverFarmer = farmerRepository.save(farmer);
        return FarmerMapper.toResponseDTO(saverFarmer);
    }

    @Override
    public FarmerResponseDTO getFarmerById(long id) {
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Farmer not found with ID: " + id));
        return FarmerMapper.toResponseDTO(farmer);
    }

    @Override
    public List<FarmerResponseDTO> getAllFarmers() {
        return farmerRepository.findAll()
                .stream()
                .map(FarmerMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FarmerResponseDTO updateFarmer(long id, FarmerRequestDTO dto) {
        Farmer farmer = (Farmer) farmerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farmer not found with id " + id));
        farmer.setName(dto.getName());
        farmer.setPhone(dto.getPhone());
        farmer.setAddress(dto.getAddress());
        return FarmerMapper.toResponseDTO(farmerRepository.save(farmer));
    }

    @Override
    public void deleteFarmer(long id) {
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Farmer not found with ID: " + id));
        farmerRepository.deleteById(id);
    }

    @Override
    public FarmerResponseDTO getFarmerByPhone(String phone) {
        Farmer farmer = (Farmer) farmerRepository.findByPhone(phone)
                .orElseThrow(() -> new EntityNotFoundException("Farmer not found with phone no" + phone));
        return FarmerMapper.toResponseDTO(farmer);
    }
}
