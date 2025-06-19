package com.store_v2.store.dto;

import com.store_v2.store.entity.Farmer;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponseDTO {

    private long id;
    private LocalDate arrivalDate;
    private int estimatedPackets;
    private long farmerId;


}
