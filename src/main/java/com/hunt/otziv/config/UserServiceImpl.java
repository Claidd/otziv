package com.hunt.otziv.config;

import com.hunt.otziv.model.Role;
import com.hunt.otziv.model.User;
import com.hunt.otziv.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with name: " + username);
        } else {
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(user.getRole().name()));
            System.out.println(Role.ADMIN.name());
            System.out.println(user.getRole().name());
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        }
    }


}
