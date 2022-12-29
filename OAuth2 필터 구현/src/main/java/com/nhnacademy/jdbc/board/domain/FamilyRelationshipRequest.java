package com.nhnacademy.jdbc.board.domain;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRelationshipRequest {
    private Long familyResidentSerialNumber;
    private String familyRelationshipCode;
}
