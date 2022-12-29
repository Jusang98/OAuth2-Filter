package com.nhnacademy.jdbc.board.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseholdRequest {
    private Long householdSerialNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate householdCompositionDate;
    private String householdCompositionReasonCode;
    private String currentHouseMovementAddress;
    private Long residentSerialNumber;
}
