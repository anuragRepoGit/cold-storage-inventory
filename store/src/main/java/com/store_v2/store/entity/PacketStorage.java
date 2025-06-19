package com.store_v2.store.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "packet_storages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PacketStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chamber", nullable = false)
    private String chamber;

    @Column(name = "lot", nullable = false)
    private String lot;

    @Column(name = "floor", nullable = false)
    private String floor;

    @Column(name = "storage_date", nullable = false)
    private LocalDate storageDate;

    @Column(name = "packet_count", nullable = false)
    private int packetCount;

    @Column(name = "remaining_packets", nullable = false)
    private int remainingPackets;

    @ManyToOne(optional = false)
    @JoinColumn(name = "farmer_id", nullable = false, unique = true)
    private Farmer farmer;
}
