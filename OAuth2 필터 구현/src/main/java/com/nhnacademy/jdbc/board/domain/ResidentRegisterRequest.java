package com.nhnacademy.jdbc.board.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResidentRegisterRequest {
    private Long residentSerialNumber;
    private String name;
    private String residentRegistrationNumber;
    private String genderCode;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime birthDate;
    private String birthPlaceCode;
    private String registrationBaseAddress;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime deathDate;
    private String deathPlaceCode;
    private String deathPlaceAddress;
    private String id;
    private String pwd;
    private String email;
}