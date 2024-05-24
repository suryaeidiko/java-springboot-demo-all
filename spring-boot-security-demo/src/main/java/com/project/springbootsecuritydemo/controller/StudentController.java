//package com.project.springbootsecuritydemo.controller;
//
//import com.project.springbootsecuritydemo.model.Role;
//import com.project.springbootsecuritydemo.model.Student;
//import com.project.springbootsecuritydemo.service.StudentService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class StudentController {
//
////    @Autowired
////    private Repo repo;
//
////    @Autowired
////    private PasswordEncoder passwordEncoder;
////    @Autowired
////    private RoleRepo roleRepo;
//
////    @GetMapping("csrf-token")
////    public CsrfToken getCsrfToken(HttpServletRequest request) {
////        return (CsrfToken) request.getAttribute("_csrf");
////    }
//
//    private StudentService service;
//
//    @GetMapping("/students")
//    public List<Student> getStudents() {
//        return service.allStudents();
//    }
//    @PostMapping("/student")
//    public String addStudent(@RequestBody Student student) {
//        service.addStudent(student);
//        return "Student added...";
//    }
//    @PostMapping("/addUser")
//    public String addUser(@RequestBody Role role) {
//        service.addUser(role);
//        return "user added...";
//    }
//    @GetMapping("/load")
//    public String loadUserAndStudent() {
//
////        List<Role> role = new ArrayList<>(
////                List.of(new Role( 0,"admin","admin","ADMIN"))
////        );
////        List<Student> Students = new ArrayList<>(
////                List.of(new Student(4,87,"Praveen"),
////                        new Student(5,91,"Vamsi"))
////        );
////        service.load();
////        repo.saveAll(Students);
//////        roleRepo.saveAll(role);
//        service.load();
//        return "Success...";
//    }
//
//}
