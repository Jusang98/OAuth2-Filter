package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.Service.FamilyRelationshipService;
import com.nhnacademy.jdbc.board.domain.FamilyRelationshipRequest;
import com.nhnacademy.jdbc.board.entity.FamilyRelationship;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/residents/{serialNumber}/relationship")
public class FamilyRelationshipController {
    private final FamilyRelationshipService familyRelationshipService;

    public FamilyRelationshipController(FamilyRelationshipService familyRelationshipService) {
        this.familyRelationshipService = familyRelationshipService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FamilyRelationship registerFamilyRelationShip(@PathVariable("serialNumber") Long serialNumber, @RequestBody FamilyRelationshipRequest familyRelationshipRequest) {
        return familyRelationshipService.registerRelationship(serialNumber, familyRelationshipRequest);
    }

    @PutMapping("/{familySerialNumber}")
    public int modifyFamilyRelationshipCode(@PathVariable("serialNumber") Long baseserialNumber,
                                            @PathVariable("familySerialNumber") Long familyserialNumber,
                                            @RequestBody FamilyRelationshipRequest familyRelationshipRequest) {
        return familyRelationshipService.modifyFamilyRelationshipCode(baseserialNumber, familyserialNumber, familyRelationshipRequest);
    }

    @DeleteMapping("/{familySerialNumber}")
    public void deleteFamilyRelationship(@PathVariable("serialNumber") Long baseserialNumber,
                                         @PathVariable("familySerialNumber") Long familyserialNumber) {
        familyRelationshipService.deleteFamilyRelationshipCode(baseserialNumber, familyserialNumber);
    }
}
