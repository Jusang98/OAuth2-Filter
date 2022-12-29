package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.Service.HouseholdService;
import com.nhnacademy.jdbc.board.domain.HouseholdMovementAddressRequest;
import com.nhnacademy.jdbc.board.domain.HouseholdRequest;
import com.nhnacademy.jdbc.board.entity.Household;
import com.nhnacademy.jdbc.board.entity.HouseholdMovementAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/household")
public class HouseholdController {
    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Household registerHousehold(@RequestBody HouseholdRequest householdRequest) {
        return householdService.registerHousehold(householdRequest);
    }

    @DeleteMapping("/{householdSerialNumber}")
    public void deleteHousehold(@PathVariable("householdSerialNumber") Long householdSerialNumber) {
        householdService.deleteHousehold(householdSerialNumber);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{householdSerialNumber}/movement")
    public HouseholdMovementAddress registerHouseholdMovementAddress(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                                                     @RequestBody HouseholdMovementAddressRequest householdMovementAddressRequest) {
        return householdService.registerHouseholdMovementAddress(householdSerialNumber, householdMovementAddressRequest);
    }

    @PutMapping("/{householdSerialNumber}/movement/{reportDate}")
    public HouseholdMovementAddress modifyHouseholdMovementAddress(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                                                   @PathVariable("reportDate") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate reportDate,
                                                                   @RequestBody HouseholdMovementAddressRequest householdMovementAddressRequest) {
        return householdService.modifyHouseholdMovementAddress(householdSerialNumber, reportDate, householdMovementAddressRequest);
    }

    @DeleteMapping("/{householdSerialNumber}/movement/{reportDate}")
    public void deleteHouseholdMovementAddress(@PathVariable("householdSerialNumber") Long householdSerialNumber,
                                               @PathVariable("reportDate") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate reportDate) {
        householdService.deleteHouseholdMovementAddress(householdSerialNumber, reportDate);
    }

}
