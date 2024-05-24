package com.project.springbootsecuritydemo.repo;

import com.project.springbootsecuritydemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,Integer> {

    Optional<Role> findByUsername(String username);

}
