//package com.nhnacademy.jpa.board;
//
//import com.nhnacademy.jdbc.board.config.RootConfig;
//import com.nhnacademy.jdbc.board.config.WebConfig;
//import com.nhnacademy.jdbc.board.repository.BirthDeathReportResidentRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.ContextHierarchy;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ExtendWith(SpringExtension.class)
//@WebAppConfiguration
//@ContextHierarchy({
//        @ContextConfiguration(classes = RootConfig.class),
//        @ContextConfiguration(classes = WebConfig.class)
//})
//@Transactional
//public class UserRepositoryTest {
//    @Autowired
//    private BirthDeathReportResidentRepository userRepository;
//    @Test
//    public void test(){
//
//        String name = "admin";
//        String pwd = "1111";
//
//        assertThat(userRepository.existsByNameAndPwd(name,pwd)).isTrue();
//
//        userRepository.flush();
//    }
//
//}
