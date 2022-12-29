package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.ResidentId;
import com.nhnacademy.jdbc.board.domain.ResidentRegisterRequest;
import com.nhnacademy.jdbc.board.entity.Resident;
import com.nhnacademy.jdbc.board.repository.ResidentRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ResidentSerivceImpl implements ResidentService {
    private final ResidentRepository residentRepository;
    private final PasswordEncoder passwordEncoder;

    public ResidentSerivceImpl(ResidentRepository residentRepository,
                               PasswordEncoder passwordEncoder) {
        this.residentRepository = residentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Resident> getResidents() {
        return residentRepository.findAll();
    }

    @Override
    public void deleteResidentBySerialNumber(Long residentSerialNumber) {
        residentRepository.deleteById(residentSerialNumber);
    }

    @Override
    public Resident getResident(Long residentSerialNumber) {
        return residentRepository.findById(residentSerialNumber).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public ResidentId createResident(ResidentRegisterRequest rq) {
        Resident resident = new Resident();
        resident.setResidentSerialNumber(rq.getResidentSerialNumber());
        resident.setResidentRegistrationNumber(rq.getResidentRegistrationNumber());
        resident.setName(rq.getName());
        resident.setBirthDate(rq.getBirthDate());
        resident.setDeathDate(rq.getDeathDate());
        resident.setGenderCode(rq.getGenderCode());
        resident.setBirthPlaceCode(rq.getBirthPlaceCode());
        resident.setDeathPlaceCode(rq.getDeathPlaceCode());
        resident.setRegistrationBaseAddress(rq.getRegistrationBaseAddress());
        resident.setResidentId(rq.getId());
        resident.setPwd(passwordEncoder.encode(rq.getPwd()));
        resident.setEmail(rq.getEmail());
        residentRepository.save(resident);
        ResidentId residentId = new ResidentId();
        residentId.setId(rq.getId());
        return residentId;
    }

    @Override
    public int updateResidentName(Long residentSerialNumber, String name) {
        return residentRepository.updateResidentName(residentSerialNumber, name);
    }

    @Override
    public Resident findByEmail(String email) {
        return residentRepository.getResidentByEmail(email);
    }

    @Override
    public Resident findById(String id) {
        return residentRepository.getResidentByResidentId(id);
    }

}
