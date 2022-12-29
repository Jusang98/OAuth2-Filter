package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.FamilyRelationshipRequest;
import com.nhnacademy.jdbc.board.entity.FamilyRelationship;
import com.nhnacademy.jdbc.board.repository.FamilyRelationshipRepository;
import org.springframework.stereotype.Service;

@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService {
    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentService residentService;

    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository familyRelationshipRepository, ResidentService residentService) {
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentService = residentService;
    }

    @Override
    public FamilyRelationship registerRelationship(Long serialNumber, FamilyRelationshipRequest familyRelationshipRequest) {


        FamilyRelationship familyRelationship = new FamilyRelationship();

        familyRelationship.setPk(new FamilyRelationship.Pk(familyRelationshipRequest.getFamilyResidentSerialNumber(), serialNumber));
        familyRelationship.setFamilyRelationshipCode(familyRelationshipRequest.getFamilyRelationshipCode());
        familyRelationship.setBaseResident(residentService.getResident(serialNumber));

        return familyRelationshipRepository.save(familyRelationship);
    }

    @Override
    public int modifyFamilyRelationshipCode(Long baseSerialNumber, Long familySerialNumber, FamilyRelationshipRequest familyRelationshipRequest) {
        FamilyRelationship.Pk pk = new FamilyRelationship.Pk(familySerialNumber, baseSerialNumber);

        return familyRelationshipRepository.updateFamilyRelationshipCode(pk, familyRelationshipRequest.getFamilyRelationshipCode());
    }

    @Override
    public void deleteFamilyRelationshipCode(Long baseSerialNumber, Long familySerialNumber) {
        FamilyRelationship.Pk pk = new FamilyRelationship.Pk(familySerialNumber, baseSerialNumber);
        familyRelationshipRepository.deleteById(pk);
    }
}
