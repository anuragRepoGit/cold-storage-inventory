package com.store_v2.store.serviceImpl;

import com.store_v2.store.dto.TokenRequestDTO;
import com.store_v2.store.dto.TokenResponseDTO;
import com.store_v2.store.entity.Farmer;
import com.store_v2.store.entity.Token;
import com.store_v2.store.mapper.TokenMapper;
import com.store_v2.store.repository.FarmerRepository;
import com.store_v2.store.repository.TokenRepository;
import com.store_v2.store.service.TokenService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final FarmerRepository farmerRepository;

    public TokenServiceImpl(TokenRepository tokenRepository, FarmerRepository farmerRepository) {
        this.tokenRepository = tokenRepository;
        this.farmerRepository = farmerRepository;
    }

    @Override
    public TokenResponseDTO createToken(TokenRequestDTO tokenRequestDTO) {
        if (tokenRepository.existsByFarmerId(tokenRequestDTO.getFarmerId())) {
            throw new RuntimeException("Token already exists for this farmer.");
        }
        Farmer farmer = farmerRepository.findById(tokenRequestDTO.getFarmerId())
                .orElseThrow(() -> new RuntimeException("farmer not found with id"));
        Token token = TokenMapper.toEntity(tokenRequestDTO, farmer);
        Token savedToken = tokenRepository.save(token);
        return TokenMapper.toDTO(savedToken);
    }

    @Override
    public TokenResponseDTO getTokenById(long id) {
        Token token = tokenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("token not found with this id"));
        return TokenMapper.toDTO(token);
    }

    @Override
    public TokenResponseDTO getTokenByFarmer(long farmerId) {
        Token token = tokenRepository.findByFarmerId(farmerId)
                .orElseThrow(() -> new RuntimeException("token not found for this farmer"));

        return TokenMapper.toDTO(token);
    }

    @Override
    public void deleteToken(long id) {
        if(!tokenRepository.existsById(id)){
            throw new RuntimeException("token is not found with this id");
        }
        tokenRepository.deleteById(id);
    }
}
