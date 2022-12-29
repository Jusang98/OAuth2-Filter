package com.nhnacademy.jdbc.board.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "family_relationship")
public class FamilyRelationship {
    @EmbeddedId
    private Pk pk;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;


    @MapsId("baseResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number")
    private Resident baseResident;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "family_resident_serial_number")
        private Long familyResidentSerialNumber;
        @Column(name = "base_resident_serial_number")
        private Long baseResidentSerialNumber;
    }
}
