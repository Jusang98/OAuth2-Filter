//package com.nhnacademy.jpa.board;
//
//import com.nhnacademy.jdbc.board.config.RootConfig;
//import com.nhnacademy.jdbc.board.config.WebConfig;
//import com.nhnacademy.jdbc.board.entity.Post;
//import com.nhnacademy.jdbc.board.repository.CertificateIssueRepositroy;
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
//import java.util.List;
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
//public class PostRepositoryTest {
//    @Autowired
//    private CertificateIssueRepositroy postRepositroy;
//    @Autowired
//    private BirthDeathReportResidentRepository userRepository;
//
//    @Test
//    public void postFindTest() {
//        List<Post> posts = postRepositroy.findAll();
//        assertThat(posts.get(0).getTitle()).isEqualTo("테스트제목");
//        Post post = postRepositroy.findById(1L).get();
//        assertThat(post.getTitle()).isEqualTo("테스트제목");
//    }
//
//    @Test
//    public void postRegisterAndUpdateTest() {
//
//        Post post = new Post();
//        post.setPostId(1L);
//        post.setTitle("제목테스트");
//        post.setContent("내용테스트");
//        post.setUser(userRepository.findByName("admin"));
//        post.setPostTime(new Date());
//        post.setReplyCount(0);
//
//        postRepositroy.save(post);
//        assertThat(postRepositroy.findById(1L).get().getTitle()).isEqualTo("제목테스트");
//
//        post.setPostId(1L);
//        post.setTitle("제목수정테스트");
//        post.setContent("내용수정테스트");
//        post.setUser(userRepository.findByName("admin"));
//        post.setPostTime(new Date());
//        post.setReplyCount(0);
//
//        postRepositroy.save(post);
//
//        assertThat(postRepositroy.findById(1L).get().getTitle()).isEqualTo("제목수정테스트");
//    }
//
//    @Test
//    public void postDeleteTest() {
//        Post post = new Post();
//        post.setPostId(1L);
//        post.setTitle("제목테스트");
//        post.setContent("내용테스트");
//        post.setUser(userRepository.findByName("admin"));
//        post.setPostTime(new Date());
//        post.setReplyCount(0);
//
//        postRepositroy.save(post);
//        postRepositroy.delete(post);
//
//        assertThat(postRepositroy.count()).isEqualTo(0);
//    }
//
//    @Test
//    public void postCountTest() {
//        Post post = new Post();
//        post.setPostId(1L);
//        post.setTitle("제목테스트");
//        post.setContent("내용테스트");
//        post.setUser(userRepository.findByName("admin"));
//        post.setPostTime(new Date());
//        post.setReplyCount(0);
//
//        postRepositroy.save(post);
//
//        assertThat(postRepositroy.count()).isEqualTo(1);
//    }
//
//}
