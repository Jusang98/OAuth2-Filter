package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.entity.HouseholdMovementAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdMovementAddressRepository extends JpaRepository<HouseholdMovementAddress, HouseholdMovementAddress.Pk> {
}
