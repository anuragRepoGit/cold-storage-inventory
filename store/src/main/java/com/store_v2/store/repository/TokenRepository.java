package com.store_v2.store.repository;

import com.store_v2.store.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByFarmerId(long farmerId);
    boolean existsByFarmerId(long farmerId);
}
