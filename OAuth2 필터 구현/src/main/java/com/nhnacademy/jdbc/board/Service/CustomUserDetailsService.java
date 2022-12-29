package com.nhnacademy.jdbc.board.Service;


import com.nhnacademy.jdbc.board.entity.Resident;
import com.nhnacademy.jdbc.board.repository.ResidentRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ResidentRepository residentRepository;

    public CustomUserDetailsService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Resident resident = residentRepository.getResidentByResidentId(username);
        if(resident==null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(resident.getResidentId(), resident.getPwd(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_RESIDENT")));
    }
}
