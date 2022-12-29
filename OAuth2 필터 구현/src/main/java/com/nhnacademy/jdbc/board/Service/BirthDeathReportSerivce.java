package com.nhnacademy.jdbc.board.Service;

import com.nhnacademy.jdbc.board.domain.BirthReportRequest;
import com.nhnacademy.jdbc.board.domain.DeathReportRequest;
import com.nhnacademy.jdbc.board.entity.BirthDeathReportResident;

public interface BirthDeathReportSerivce {
    BirthDeathReportResident getReportResident(Long reportSerialNumber, Long targetSerialNumber);

    BirthDeathReportResident registerBirthReport(Long reportSerialNumber, BirthReportRequest birthReportRequest);

    BirthDeathReportResident registerDeathReport(Long reportSerialNumber, DeathReportRequest deathReportRequest);

    BirthDeathReportResident modifyBirthReport(Long reportSerialNumber, Long targetSerialNumber, BirthReportRequest birthReportRequest);

    BirthDeathReportResident modifyDeathReport(Long reportSerialNumber, Long targetSerialNumber, DeathReportRequest deathReportRequest);

    void deleteBirthReport(Long reportSerialNumber, Long targetSerialNumber);

    void deleteDeathReport(Long reportSerialNumber, Long targetSerialNumber);

}
