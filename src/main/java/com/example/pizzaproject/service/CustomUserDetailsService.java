package com.example.pizzaproject.service;


import com.example.pizzaproject.model.User;
import com.example.pizzaproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override

    public UserDetails loadUserByUsername( String username) throws UsernameNotFoundException {
        return userRepository.findById(username)
                .map(user -> new UserDetailsAdapter(user))
                .orElseThrow(() -> new UsernameNotFoundException("Error username"));
    }

}
