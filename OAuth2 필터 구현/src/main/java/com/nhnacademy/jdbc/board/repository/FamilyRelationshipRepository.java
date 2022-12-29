package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {

    @Transactional
    @Modifying
    @Query("update FamilyRelationship f set f.familyRelationshipCode = :familyRelationshipCode where f.pk = :pk")
    int updateFamilyRelationshipCode(@Param("pk") FamilyRelationship.Pk pk, @Param("familyRelationshipCode") String familyRelationshipCode);
}
