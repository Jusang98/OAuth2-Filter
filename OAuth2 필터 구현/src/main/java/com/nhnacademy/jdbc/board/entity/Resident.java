package com.nhnacademy.jdbc.board.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "resident")
public class Resident {
    @Id
    @Column(name = "resident_serial_number")
    private Long residentSerialNumber;
    private String name;
    @Column(name = "resident_registration_number")
    private String residentRegistrationNumber;
    @Column(name = "gender_code")
    private String genderCode;
    @Column(name = "birth_date")
    private LocalDateTime birthDate;
    @Column(name = "birth_place_code")
    private String birthPlaceCode;
    @Column(name = "registration_base_address")
    private String registrationBaseAddress;
    @Column(name = "death_date")
    private LocalDateTime deathDate;
    @Column(name = "death_place_code")
    private String deathPlaceCode;
    @Column(name = "death_place_address")
    private String deathPlaceAddress;
    @Column(name = "id")
    private String residentId;
    @Column(name = "password")
    private String pwd;
    @Column(name = "email")
    private String email;


}
