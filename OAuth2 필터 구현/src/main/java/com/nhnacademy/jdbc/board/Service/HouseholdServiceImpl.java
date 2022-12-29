package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.HouseholdMovementAddressRequest;
import com.nhnacademy.jdbc.board.domain.HouseholdRequest;
import com.nhnacademy.jdbc.board.entity.Household;
import com.nhnacademy.jdbc.board.entity.HouseholdMovementAddress;
import com.nhnacademy.jdbc.board.repository.HouseholdMovementAddressRepository;
import com.nhnacademy.jdbc.board.repository.HouseholdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class HouseholdServiceImpl implements HouseholdService {
    private final HouseholdRepository householdRepository;
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;
    private final ResidentService residentService;

    public HouseholdServiceImpl(HouseholdRepository householdRepository, HouseholdMovementAddressRepository householdMovementAddressRepository, ResidentService residentService) {
        this.householdRepository = householdRepository;
        this.householdMovementAddressRepository = householdMovementAddressRepository;
        this.residentService = residentService;
    }

    @Override
    public Household getHousehold(Long householdSerialNumber) {
        return householdRepository.findById(householdSerialNumber).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Household registerHousehold(HouseholdRequest householdRequest) {
        Household household = new Household(householdRequest.getHouseholdSerialNumber(),
                householdRequest.getHouseholdCompositionDate(), householdRequest.getHouseholdCompositionReasonCode(),
                householdRequest.getCurrentHouseMovementAddress(), residentService.getResident(householdRequest.getResidentSerialNumber()));
        return householdRepository.save(household);
    }

    @Override
    public void deleteHousehold(Long householdSerialNumber) {
        householdRepository.deleteById(householdSerialNumber);
    }

    @Override
    public HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressRequest householdMovementAddressRequest) {
        HouseholdMovementAddress.Pk pk = new HouseholdMovementAddress.Pk(householdSerialNumber, householdMovementAddressRequest.getHouseMovementReportDate());
        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress(pk,
                getHousehold(householdSerialNumber),
                householdMovementAddressRequest.getHouseMovementAddress(),
                householdMovementAddressRequest.getLastAddressYn());
        return householdMovementAddressRepository.save(householdMovementAddress);
    }

    @Override
    public HouseholdMovementAddress modifyHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDate, HouseholdMovementAddressRequest householdMovementAddressRequest) {
        HouseholdMovementAddress.Pk pk = new HouseholdMovementAddress.Pk(householdSerialNumber, reportDate);
        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress(pk,
                getHousehold(householdSerialNumber),
                householdMovementAddressRequest.getHouseMovementAddress(),
                householdMovementAddressRequest.getLastAddressYn());
        return householdMovementAddressRepository.save(householdMovementAddress);
    }

    @Override
    public void deleteHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDate) {
        HouseholdMovementAddress.Pk pk = new HouseholdMovementAddress.Pk(householdSerialNumber, reportDate);
        householdMovementAddressRepository.deleteById(pk);
    }
}
