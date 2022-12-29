package com.nhnacademy.jpa.board;

import com.nhnacademy.jdbc.board.config.RootConfig;
import com.nhnacademy.jdbc.board.config.WebConfig;
import com.nhnacademy.jdbc.board.entity.Resident;
import com.nhnacademy.jdbc.board.repository.CertificateIssueRepositroy;
import com.nhnacademy.jdbc.board.repository.BirthDeathReportResidentRepository;
import com.nhnacademy.jdbc.board.repository.ResidentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
@Transactional
public class EntityRepositoryTest {
    @Autowired
    private ResidentRepository residentRepository;
    @Autowired
    private CertificateIssueRepositroy certificateIssueRepositroy;
    @Autowired
    private BirthDeathReportResidentRepository birthDeathReportResidentRepository;

    @Test
    public void regidentRegisterTest(){

        residentRepository.findAll();
        System.out.println(residentRepository.findAll());
    }
}
