package com.nhnacademy.jdbc.board.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.jdbc.board.auth.LoginSuccessHandler;
import com.nhnacademy.jdbc.board.domain.AccessToken;
import com.nhnacademy.jdbc.board.entity.Resident;
import com.nhnacademy.jdbc.board.repository.ResidentRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class GitHubRestTemplateService {
    private final ResidentRepository residentRepository;
    private final RedisTemplate<String, String> redisTemplate;

    public GitHubRestTemplateService(ResidentRepository residentRepository, RedisTemplate<String, String> redisTemplate) {
        this.residentRepository = residentRepository;
        this.redisTemplate = redisTemplate;
    }

    public String getGitHubToken(String code) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("client_id", "******");
        params.add("client_secret", "*****");
        params.add("redirect_uri", "http://localhost:8080/login/oauth2/code/github");
        params.add("code", code);
        params.add("scope", "user");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.add("Accept", "application/json");
        HttpEntity<MultiValueMap<String, String>> GitHubAccessTokenRequest =
                new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(
                "https://github.com/login/oauth/access_token",
                HttpMethod.POST,
                GitHubAccessTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        AccessToken token = null;
        try {
            token = objectMapper.readValue(response.getBody(), AccessToken.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return token.getAccess_token();
    }

    public String getEmail(String token) {
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.add("Authorization", "Bearer " + token);
//        headers.add("access_token",token);
//        headers.add("scope","repo");
//        headers.add("token_type","bearer");

        HttpEntity<MultiValueMap<String, String>> GitHubResourceServerRequest =
                new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.github.com/user",
                HttpMethod.GET,
                GitHubResourceServerRequest,
                String.class
        );
        ObjectMapper objectMapper = new ObjectMapper();
        AccessToken.GitHubInfo gitHubInfo = null;
        try {
            gitHubInfo = objectMapper.readValue(response.getBody(), AccessToken.GitHubInfo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return gitHubInfo.getEmail();
    }

    public void customUsernamePasswordAuthenticationToken(HttpServletRequest request, HttpServletResponse response, Resident resident) throws ServletException, IOException {
        LoginSuccessHandler loginSuccessHandler = new LoginSuccessHandler(redisTemplate);
        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService(residentRepository);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(resident.getResidentId());

        Authentication token = new UsernamePasswordAuthenticationToken(userDetails,
                null
                , userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(token);
        loginSuccessHandler.onAuthenticationSuccess(request, response, token);
    }


}