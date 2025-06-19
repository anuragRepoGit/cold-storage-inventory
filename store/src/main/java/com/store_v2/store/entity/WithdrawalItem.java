package com.store_v2.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "withdrawal_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WithdrawalItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "withdrawal_id", nullable = false, unique = true)
    private Withdrawal withdrawal;

    @ManyToOne(optional = false)
    @JoinColumn(name = "packet_storage_id", nullable = false, unique = true)
    private Withdrawal packetStorage;

    @Column(name = "withdrawal_packets", nullable = false)
    private int withdrawalPackets;

}
