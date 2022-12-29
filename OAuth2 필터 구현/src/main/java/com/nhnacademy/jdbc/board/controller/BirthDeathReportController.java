package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.Service.BirthDeathReportSerivce;
import com.nhnacademy.jdbc.board.domain.BirthReportRequest;
import com.nhnacademy.jdbc.board.domain.DeathReportRequest;
import com.nhnacademy.jdbc.board.entity.BirthDeathReportResident;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/residents/{serialNumber}")
public class BirthDeathReportController {
    private final BirthDeathReportSerivce birthDeathReportSerivce;

    public BirthDeathReportController(BirthDeathReportSerivce birthDeathReportSerivce) {
        this.birthDeathReportSerivce = birthDeathReportSerivce;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/birth")
    public BirthDeathReportResident registerBirthReport(@PathVariable("serialNumber") Long serialNumber, @RequestBody BirthReportRequest birthReportRequest) {
        return birthDeathReportSerivce.registerBirthReport(serialNumber, birthReportRequest);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/death")
    public BirthDeathReportResident registerDeathReportResident(@PathVariable("serialNumber") Long serialNumber, @RequestBody DeathReportRequest deathReportRequest) {
        return birthDeathReportSerivce.registerDeathReport(serialNumber, deathReportRequest);
    }

    @PutMapping("/birth/{targetSerialNumber}")
    public BirthDeathReportResident modifyBirthReport(@PathVariable("serialNumber") Long reportSerialNumber,
                                                      @PathVariable("targetSerialNumber") Long targetserialNumber,
                                                      @RequestBody BirthReportRequest birthReportRequest) {
        return birthDeathReportSerivce.modifyBirthReport(reportSerialNumber, targetserialNumber, birthReportRequest);
    }

    @PutMapping("/death/{targetSerialNumber}")
    public BirthDeathReportResident modifyDeathReport(@PathVariable("serialNumber") Long reportSerialNumber,
                                                      @PathVariable("targetSerialNumber") Long targetserialNumber,
                                                      @RequestBody DeathReportRequest deathReportRequest) {
        return birthDeathReportSerivce.modifyDeathReport(reportSerialNumber, targetserialNumber, deathReportRequest);
    }

    @DeleteMapping("/birth/{targetSerialNumber}")
    public void deleteBirthReport(@PathVariable("serialNumber") Long reportSerialNumber,
                                  @PathVariable("targetSerialNumber") Long targetSerialNumber) {
        birthDeathReportSerivce.deleteBirthReport(reportSerialNumber, targetSerialNumber);
    }

    @DeleteMapping("/death/{targetSerialNumber}")
    public void deleteDeathReport(@PathVariable("serialNumber") Long reportSerialNumber,
                                  @PathVariable("targetSerialNumber") Long targetSerialNumber) {
        birthDeathReportSerivce.deleteDeathReport(reportSerialNumber, targetSerialNumber);
    }
}
