package com.store_v2.store.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "withdrawals")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate withdrawDate;

    @OneToMany(mappedBy = "withdrawal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WithdrawalItem> withdrawalItems;

    @ManyToOne(optional = false)
    @JoinColumn(name = "farmer_id", nullable = false, unique = true)
    private Farmer farmer;
}
