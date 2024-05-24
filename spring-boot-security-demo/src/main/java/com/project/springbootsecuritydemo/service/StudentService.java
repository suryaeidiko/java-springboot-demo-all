package com.project.springbootsecuritydemo.service;

import com.project.springbootsecuritydemo.model.Role;
import com.project.springbootsecuritydemo.model.Student;
import com.project.springbootsecuritydemo.repo.Repo;
import com.project.springbootsecuritydemo.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    private Repo repo;
    @Autowired
    private RoleRepo roleRepo;
    public List<Student> allStudents() {
        return repo.findAll();
    }
    public void addStudent(Student student) {
        repo.save(student);
    }
    public void updateJob(Student student) {
        repo.save(student);
    }
    public void deleteStudent(int roll_No) {
        repo.deleteById(roll_No);
    }

    public void load() {
        List<Student> Students = new ArrayList<>(
                List.of(new Student(0,87,"Praveen"),
                        new Student(0,91,"Vamsi"))
        );
        repo.saveAll(Students);
    }
    public void addUser(Role role) {
//        role.setPassword(passwordEncoder.encode(role.getPassword()));
        roleRepo.save(role);
    }
}
