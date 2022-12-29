package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {
}
