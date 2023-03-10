//package com.nhnacademy.jdbc.board.Filter;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Collection;
//
//public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    public AuthenticationFilter(AuthenticationManager authenticationManager) {
//        super.setAuthenticationManager(authenticationManager);
//    }
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(request.getParameter("name"), request.getParameter("pwd"));
//        setDetails(request, authRequest);
//        return this.getAuthenticationManager().authenticate(authRequest);
//    }
//}
