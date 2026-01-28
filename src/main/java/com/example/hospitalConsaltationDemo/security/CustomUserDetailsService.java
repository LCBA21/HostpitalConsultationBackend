package com.example.hospitalConsaltationDemo.security;


import com.example.hospitalConsaltationDemo.exceptions.NotFoundException;
import com.example.hospitalConsaltationDemo.users.enity.User;
import com.example.hospitalConsaltationDemo.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username)
                .orElseThrow(()-> new NotFoundException("Email Not Found"));


        return AuthUser.builder()
                .user(user)
                .build();
    }
}
