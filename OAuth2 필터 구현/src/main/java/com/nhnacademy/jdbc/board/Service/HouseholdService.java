package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.HouseholdMovementAddressRequest;
import com.nhnacademy.jdbc.board.domain.HouseholdRequest;
import com.nhnacademy.jdbc.board.entity.Household;
import com.nhnacademy.jdbc.board.entity.HouseholdMovementAddress;

import java.time.LocalDate;

public interface HouseholdService {
    Household getHousehold(Long householdSerialNumber);

    Household registerHousehold(HouseholdRequest householdRequest);

    void deleteHousehold(Long householdSerialNumber);

    HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressRequest householdMovementAddressRequest);

    HouseholdMovementAddress modifyHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDate, HouseholdMovementAddressRequest householdMovementAddressRequest);

    void deleteHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDate);
}
