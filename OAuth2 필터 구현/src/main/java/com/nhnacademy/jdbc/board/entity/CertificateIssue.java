package com.nhnacademy.jdbc.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "certificate_issue")
public class CertificateIssue {
    @Id
    @Column(name = "certificate_confirmation_number")
    private Long certificateConfirmationNumber;
    @Column(name = "certificate_type_code")
    private String certificateTypeCode;
    @Column(name = "certificate_issue_date")
    private LocalDate certificateIssueDate;
    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;
}
