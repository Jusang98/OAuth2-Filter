package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.ResidentId;
import com.nhnacademy.jdbc.board.domain.ResidentRegisterRequest;
import com.nhnacademy.jdbc.board.entity.Resident;

import java.util.List;

public interface ResidentService {
    List<Resident> getResidents();
    void deleteResidentBySerialNumber(Long residentSerialNumber);

    Resident getResident(Long residentSerialNumber);

    ResidentId createResident(ResidentRegisterRequest residentRegisterRequest);

    int updateResidentName(Long residentSerialNumber, String name);

    Resident findByEmail(String email);

    Resident findById(String id);

}
