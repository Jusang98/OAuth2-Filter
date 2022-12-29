package com.nhnacademy.jdbc.board.Service;


import com.nhnacademy.jdbc.board.domain.FamilyRelationshipRequest;
import com.nhnacademy.jdbc.board.entity.FamilyRelationship;


public interface FamilyRelationshipService {
    FamilyRelationship registerRelationship(Long serialNumber, FamilyRelationshipRequest familyRelationshipRequest);

    int modifyFamilyRelationshipCode(Long baseSerialNumber, Long familySerialNumber, FamilyRelationshipRequest familyRelationshipRequest);

    void deleteFamilyRelationshipCode(Long baseSerialNumber, Long familySerialNumber);
}
