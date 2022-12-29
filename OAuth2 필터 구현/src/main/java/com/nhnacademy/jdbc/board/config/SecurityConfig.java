package com.nhnacademy.jdbc.board.config;


import com.nhnacademy.jdbc.board.Service.CustomUserDetailsService;
import com.nhnacademy.jdbc.board.auth.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
       return http.authorizeRequests()
                .antMatchers("/resident/**").hasAuthority("ROLE_RESIDENT")
                .antMatchers("/redirect-home").authenticated()
                .anyRequest().permitAll()
                    .and()
                .requiresChannel()
                .antMatchers("/resident/**").requiresSecure()
                .anyRequest().requiresInsecure()
                    .and()
                .formLogin()
                    .usernameParameter("id")
                    .passwordParameter("pwd")
                    .loginPage("/auth/login")
                    .loginProcessingUrl("/login")
                    .successHandler(loginSuccessHandler(null))
                    .and()
                .logout()
                    .and()
                .csrf()
                    .and()
//                .disable()
// 포스트메소드에 csrf의 토큰값을 넣어줘야함, restapi할땐 disable()사용
                .sessionManagement()
                    .sessionFixation()
                    .none()
                    .and()
                .headers()
                    .defaultsDisabled()
                    .frameOptions().sameOrigin()
                    .and()
                .exceptionHandling()
                    .accessDeniedPage("/error/403")
                    .and()
                .build();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider(null));
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(RedisTemplate<String, String> redisTemplate) {
        return new LoginSuccessHandler(redisTemplate);
    }


}
