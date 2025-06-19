package com.store_v2.store.controller;

import com.store_v2.store.dto.TokenRequestDTO;
import com.store_v2.store.dto.TokenResponseDTO;
import com.store_v2.store.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/token")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenResponseDTO> createToken(@RequestBody TokenRequestDTO dto){
        return ResponseEntity.ok(tokenService.createToken(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TokenResponseDTO> getTokenById(@PathVariable long id){
        return ResponseEntity.ok(tokenService.getTokenById(id));
    }

    @GetMapping("/farmer/{id}")
    public ResponseEntity<TokenResponseDTO> getTokenByFarmerId(@PathVariable long id){
        return ResponseEntity.ok(tokenService.getTokenByFarmer(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TokenResponseDTO> deleteTokenById(@PathVariable long id) {
        tokenService.deleteToken(id);
        return ResponseEntity.noContent().build();
    }
}
