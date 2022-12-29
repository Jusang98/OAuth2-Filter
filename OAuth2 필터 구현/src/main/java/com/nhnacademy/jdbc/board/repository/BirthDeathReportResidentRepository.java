package com.nhnacademy.jdbc.board.repository;


import com.nhnacademy.jdbc.board.entity.BirthDeathReportResident;
import com.nhnacademy.jdbc.board.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident, BirthDeathReportResident.Pk> {
    @Transactional
    @Modifying
    @Query("DELETE from BirthDeathReportResident bd WHERE bd.reportResident =:reportResident AND bd.resident =:resident")
    void deleteByReportResidentAndResident(@Param("reportResident") Resident reportResident, @Param("resident") Resident resident);
}
