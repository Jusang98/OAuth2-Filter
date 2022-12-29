package com.nhnacademy.jdbc.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.beans.ConstructorProperties;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class AccessToken {
    private String access_token;
    private String token_type;
    private String scope;

    @ConstructorProperties({"access_token", "token_type", "scope"})
    public AccessToken(String access_token, String token_type, String scope) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.scope = scope;
    }

    public AccessToken() {
    }

    @Data
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Builder
    public static class GitHubInfo {
        private String email;
        @ConstructorProperties({"email"})
        public GitHubInfo(String email) {
            this.email = email;
        }

        public GitHubInfo() {
        }
    }
}
