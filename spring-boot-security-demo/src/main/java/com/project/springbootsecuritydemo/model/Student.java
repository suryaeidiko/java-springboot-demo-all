package com.project.springbootsecuritydemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int roll_No;
    private int marks;
    private String name;
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinTable(name = "roles",joinColumns = @JoinColumn(name = "ROLL_NO"),inverseJoinColumns = @JoinColumn(name = "roles"))
//    private String roles;

}
