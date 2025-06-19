package com.store_v2.store.controller;


import com.store_v2.store.dto.FarmerRequestDTO;
import com.store_v2.store.dto.FarmerResponseDTO;
import com.store_v2.store.service.FarmerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping
    public ResponseEntity<FarmerResponseDTO> createFarmer(@RequestBody FarmerRequestDTO dto){
        return ResponseEntity.ok(farmerService.createFarmer(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmerResponseDTO> getFarmerById(@PathVariable long id){
        return ResponseEntity.ok(farmerService.getFarmerById(id));
    }

    @GetMapping
    public ResponseEntity<List<FarmerResponseDTO>> getAllFarmers(){
        return ResponseEntity.ok(farmerService.getAllFarmers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmerResponseDTO> updateFarmer(@PathVariable long id, @RequestBody FarmerRequestDTO dto){
        return ResponseEntity.ok(farmerService.updateFarmer(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable long id){
        farmerService.deleteFarmer(id);
        return ResponseEntity.noContent().build();
    }
}
