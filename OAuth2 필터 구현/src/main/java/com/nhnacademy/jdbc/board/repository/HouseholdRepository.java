package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Long> {
}
