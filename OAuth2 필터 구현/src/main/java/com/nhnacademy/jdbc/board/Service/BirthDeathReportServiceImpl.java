package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.BirthReportRequest;
import com.nhnacademy.jdbc.board.domain.DeathReportRequest;
import com.nhnacademy.jdbc.board.entity.BirthDeathReportResident;
import com.nhnacademy.jdbc.board.repository.BirthDeathReportResidentRepository;
import org.springframework.stereotype.Service;

@Service
public class BirthDeathReportServiceImpl implements BirthDeathReportSerivce {
    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;
    private final ResidentService residentService;

    public BirthDeathReportServiceImpl(BirthDeathReportResidentRepository birthDeathReportResidentRepository, ResidentService residentService) {
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
        this.residentService = residentService;

    }

    @Override
    public BirthDeathReportResident getReportResident(Long reportSerialNumber, Long targetSerialNumber) {
        return null;
    }

    @Override
    public BirthDeathReportResident registerBirthReport(Long serialNumber, BirthReportRequest birthReportRequest) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(birthReportRequest.getResidentSerialNumber(), birthReportRequest.getBirthDeathTypeCode());
        BirthDeathReportResident birthReportResident = new BirthDeathReportResident(pk,
                birthReportRequest.getBirthDeathReportDate(),
                birthReportRequest.getBirthReportQualificationsCode(),
                null,
                birthReportRequest.getEmailAddress(),
                birthReportRequest.getPhoneNumber(),
                residentService.getResident(serialNumber),
                residentService.getResident(birthReportRequest.getResidentSerialNumber()));
        return birthDeathReportResidentRepository.save(birthReportResident);
    }

    @Override
    public BirthDeathReportResident registerDeathReport(Long serialNumber, DeathReportRequest deathReportRequest) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(deathReportRequest.getResidentSerialNumber(), deathReportRequest.getBirthDeathTypeCode());
        BirthDeathReportResident deathReportResident = new BirthDeathReportResident(pk,
                deathReportRequest.getBirthDeathReportDate(),
                null,
                deathReportRequest.getDeathReportQualificationsCode(),
                deathReportRequest.getEmailAddress(),
                deathReportRequest.getPhoneNumber(),
                residentService.getResident(serialNumber),
                residentService.getResident(deathReportRequest.getResidentSerialNumber()));
        return birthDeathReportResidentRepository.save(deathReportResident);
    }

    @Override
    public BirthDeathReportResident modifyBirthReport(Long reportSerialNumber, Long targetSerialNumber, BirthReportRequest birthReportRequest) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(targetSerialNumber, birthReportRequest.getBirthDeathTypeCode());
        BirthDeathReportResident birthReportResident = new BirthDeathReportResident(pk,
                birthReportRequest.getBirthDeathReportDate(),
                birthReportRequest.getBirthReportQualificationsCode(),
                null,
                birthReportRequest.getEmailAddress(),
                birthReportRequest.getPhoneNumber(),
                residentService.getResident(reportSerialNumber),
                residentService.getResident(targetSerialNumber));
        return birthDeathReportResidentRepository.save(birthReportResident);
    }

    @Override
    public BirthDeathReportResident modifyDeathReport(Long reportSerialNumber, Long targetSerialNumber, DeathReportRequest deathReportRequest) {
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(targetSerialNumber, deathReportRequest.getBirthDeathTypeCode());
        BirthDeathReportResident deathReportResident = new BirthDeathReportResident(pk,
                deathReportRequest.getBirthDeathReportDate(),
                null,
                deathReportRequest.getDeathReportQualificationsCode(),
                deathReportRequest.getEmailAddress(),
                deathReportRequest.getPhoneNumber(),
                residentService.getResident(reportSerialNumber),
                residentService.getResident(targetSerialNumber));
        return birthDeathReportResidentRepository.save(deathReportResident);
    }

    @Override
    public void deleteBirthReport(Long reportSerialNumber, Long targetSerialNumber) {
        birthDeathReportResidentRepository.deleteByReportResidentAndResident(residentService.getResident(reportSerialNumber),
                residentService.getResident(targetSerialNumber));
    }

    @Override
    public void deleteDeathReport(Long reportSerialNumber, Long targetSerialNumber) {
        birthDeathReportResidentRepository.deleteByReportResidentAndResident(residentService.getResident(reportSerialNumber),
                residentService.getResident(targetSerialNumber));
    }
}
