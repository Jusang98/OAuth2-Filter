package com.nhnacademy.jdbc.board.controller;

import com.nhnacademy.jdbc.board.Service.ResidentService;
import com.nhnacademy.jdbc.board.Service.GitHubRestTemplateService;
import com.nhnacademy.jdbc.board.entity.Resident;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class GitHubController {
    private final GitHubRestTemplateService gitHubRestTemplateService;
    private final ResidentService residentService;

    public GitHubController(GitHubRestTemplateService gitHubRestTemplateService, ResidentService residentService) {
        this.gitHubRestTemplateService = gitHubRestTemplateService;
        this.residentService = residentService;
    }

    @GetMapping("/login/oauth2/code/github")
    public String loginGitHub(HttpServletRequest request, HttpServletResponse response, @RequestParam String code) throws ServletException, IOException {
        Resident resident = residentService.findByEmail(gitHubRestTemplateService.getEmail(gitHubRestTemplateService.getGitHubToken(code)));

        gitHubRestTemplateService.customUsernamePasswordAuthenticationToken(request, response, resident);

        return "home";
    }

//    @PostMapping("/login/oauth2/code/github")
//    public ResponseEntity<String> test2(@RequestParam String code) {
//        restTemplateService.getGitHubInfo(code);
//        return ResponseEntity.status(HttpStatus.OK).body(String);
//    }


}
