package com.project.springbootsecuritydemo.service;

import com.project.springbootsecuritydemo.model.Role;
import com.project.springbootsecuritydemo.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private RoleRepo rolerepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Role> user = rolerepo.findByUsername(username);

        if (user.isPresent()) {
            var userObj = user.get();
            System.out.println("success...");
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRole(userObj))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
    public String[] getRole(Role role) {
        if (role.getRoles() == null) {
            return new String[] {"USER"};
        } else {
            System.out.println("roles : "+ role.getRoles());
            return role.getRoles().split(",");

        }
    }
}
