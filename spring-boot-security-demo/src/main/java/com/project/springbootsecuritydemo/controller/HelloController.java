package com.project.springbootsecuritydemo.controller;

import com.project.springbootsecuritydemo.model.Role;
import com.project.springbootsecuritydemo.model.Student;
import com.project.springbootsecuritydemo.repo.Repo;
import com.project.springbootsecuritydemo.service.JwtService;
import com.project.springbootsecuritydemo.service.MyUserDetails;
import com.project.springbootsecuritydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@CrossOrigin(origins = "*")
public class HelloController {

    @Autowired
//    private Repo repo;
      private StudentService service;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private MyUserDetails myUserDetails;

    @GetMapping("/home")
    public String greet() {
        return "Hello World...";
    }
    @GetMapping("/allStudents")
    public List<Student> getStudents() {
        return service.allStudents();
    }
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return "student added...";
    }
    @DeleteMapping("/delete/{roll_No}")
    public String deleteStudent(@PathVariable("roll_No") int roll_No) {
        service.deleteStudent(roll_No);
        return "deleted...";
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        service.updateJob(student);
        return "updated...";
    }
    @GetMapping("/load")
    public String loadUserAndStudent() {

//        List<Role> role = new ArrayList<>(
//                List.of(new Role( 0,"admin","admin","ADMIN"))
//        );
//        List<Student> Students = new ArrayList<>(
//                List.of(new Student(4,87,"Praveen"),
//                        new Student(5,91,"Vamsi"))
//        );
//        service.load();
//        repo.saveAll(Students);
////        roleRepo.saveAll(role);
        service.load();
        return "Success...";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Role role) {
        role.setPassword(passwordEncoder.encode(role.getPassword()));
        service.addUser(role);
        return "User added...";
    }

    @PostMapping("/login")
    public String login(@RequestBody Role role) {
//        System.out.println(role.getUsername() + role.getPassword());
//        return role.getUsername() + role.getPassword();
        Authentication authentication = authenticationManager
        .authenticate
         (new UsernamePasswordAuthenticationToken(role.getUsername(),role.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(role.getUsername());
        } else {
//            throw new UsernameNotFoundException("Invalid username...");
            return "Invalid username...";
        }
    }

}
