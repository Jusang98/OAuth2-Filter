package com.nhnacademy.jdbc.board.domain;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeathReportRequest {
    private Long residentSerialNumber;
    private String birthDeathTypeCode;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate birthDeathReportDate;
    private String deathReportQualificationsCode;
    private String emailAddress;
    private String phoneNumber;
}