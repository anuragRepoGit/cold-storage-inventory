package com.store_v2.store.service;

import com.store_v2.store.dto.TokenRequestDTO;
import com.store_v2.store.dto.TokenResponseDTO;

public interface TokenService {

    TokenResponseDTO createToken(TokenRequestDTO tokenRequestDTO);
    TokenResponseDTO getTokenById(long id);
    TokenResponseDTO getTokenByFarmer(long farmerId);
    void deleteToken(long id);

}
