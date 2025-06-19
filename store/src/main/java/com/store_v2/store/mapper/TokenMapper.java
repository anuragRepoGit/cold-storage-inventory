package com.store_v2.store.mapper;

import com.store_v2.store.dto.TokenRequestDTO;
import com.store_v2.store.dto.TokenResponseDTO;
import com.store_v2.store.entity.Farmer;
import com.store_v2.store.entity.Token;

import java.util.Optional;

public class TokenMapper {

    public static Token toEntity(TokenRequestDTO dto, Farmer farmer){
        Token token = new Token();
        token.setArrivalDate(dto.getArrivalDate());
        token.setEstimatedPackets(dto.getEstimatedPackets());
        token.setFarmer(farmer);
        return token;
    }

    public static TokenResponseDTO toDTO(Token token){
        return new TokenResponseDTO(
                token.getId(),
                token.getArrivalDate(),
                token.getEstimatedPackets(),
                token.getFarmer().getId()
        );
    }
}
