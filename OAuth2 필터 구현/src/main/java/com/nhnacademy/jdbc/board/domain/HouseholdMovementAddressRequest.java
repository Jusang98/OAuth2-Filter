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
public class HouseholdMovementAddressRequest {
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate houseMovementReportDate;
    private String houseMovementAddress;
    private String lastAddressYn;
}
