package com.nhnacademy.jdbc.board.repository;

import com.nhnacademy.jdbc.board.entity.CertificateIssue;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CertificateIssueRepositroy extends JpaRepository<CertificateIssue, Long> {
}
