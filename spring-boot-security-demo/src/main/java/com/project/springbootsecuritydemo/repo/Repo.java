package com.project.springbootsecuritydemo.repo;

import com.project.springbootsecuritydemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Student,Integer> {

}
