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
@Table(name = "household_composition_resident")
public class HouseholdCompositionResident {
    @EmbeddedId
    private Pk pk;
    @Column(name = "report_date")
    private LocalDate reportDate;
    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident baseResident;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "resident_serial_number")
        private Long residentSerialNumber;
        @Column(name = "household_serial_number")
        private Long householdSerialNumber;
    }
}
