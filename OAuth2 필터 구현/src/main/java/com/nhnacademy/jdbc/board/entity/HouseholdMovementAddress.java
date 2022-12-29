package com.nhnacademy.jdbc.board.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "household_movement_address")
public class HouseholdMovementAddress {
    @EmbeddedId
    private Pk pk;

    @MapsId("householdSerialNumber")
    @ManyToOne
    @JoinColumn(name = "household_serial_number")
    private Household household;
    @Column(name = "house_movement_address")
    private String houseMovementAddress;
    @Column(name = "last_address_yn")
    private String lastAddressYn;


    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "household_serial_number")
        private Long householdSerialNumber;
        @Column(name = "house_movement_report_date")
        private LocalDate houseMovementReportDate;
    }
}
