package com.store_v2.store.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@Table(name = "farmers")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false, unique = true, length = 10)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    public Farmer() {
    }

    public Farmer(long id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
}
