//package com.nhnacademy.jpa.board;
//
//import com.nhnacademy.jdbc.board.config.RootConfig;
//import com.nhnacademy.jdbc.board.config.WebConfig;
//import com.nhnacademy.jdbc.board.entity.Reply;
//import com.nhnacademy.jdbc.board.repository.CertificateIssueRepositroy;
//import com.nhnacademy.jdbc.board.repository.FamilyRelationshipRepository;
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
//import java.util.Date;
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
//public class ReplyRepositoryTest {
//    @Autowired
//    FamilyRelationshipRepository replyRepository;
//    @Autowired
//    CertificateIssueRepositroy postRepositroy;
//    @Autowired
//    BirthDeathReportResidentRepository userRepository;
//
//    @Test
//    public void replyFindTest(){
//
//    }
//
//    @Test
//    public void replyRegisterUpdateTest() {
//
//        Reply reply = new Reply();
//
//        reply.setReplyId(1L);
//        reply.setPost(postRepositroy.findById(1L).get());
//        reply.setUser(userRepository.findById(1L).get());
//        reply.setContent("댓글테스트");
//        reply.setReplyTime(new Date());
//
//        replyRepository.save(reply);
//        assertThat(replyRepository.findById(1L).get().getContent()).isEqualTo("댓글테스트");
//
//        reply.setReplyId(1L);
//        reply.setPost(postRepositroy.findById(1L).get());
//        reply.setUser(userRepository.findById(1L).get());
//        reply.setContent("댓글수정테스트");
//        reply.setReplyTime(new Date());
//
//        replyRepository.save(reply);
//        assertThat(replyRepository.findById(1L).get().getContent()).isEqualTo("댓글수정테스트");
//    }
//
//    @Test
//    public void replyDeleteTest() {
//        Reply reply = new Reply();
//
//        reply.setReplyId(1L);
//        reply.setPost(postRepositroy.findById(1L).get());
//        reply.setUser(userRepository.findById(1L).get());
//        reply.setContent("댓글테스트");
//        reply.setReplyTime(new Date());
//
//        replyRepository.save(reply);
//        replyRepository.deleteById(1L);
//        assertThat(replyRepository.count()).isEqualTo(0);
//    }
//
//    @Test
//    public void replyCountTest() {
//        Reply reply = new Reply();
//
//        reply.setReplyId(1L);
//        reply.setPost(postRepositroy.findById(1L).get());
//        reply.setUser(userRepository.findById(1L).get());
//        reply.setContent("댓글테스트");
//        reply.setReplyTime(new Date());
//
//        replyRepository.save(reply);
//        int replyCount = (int) replyRepository.count();
//        assertThat(replyCount).isEqualTo(1);
//    }
//}
