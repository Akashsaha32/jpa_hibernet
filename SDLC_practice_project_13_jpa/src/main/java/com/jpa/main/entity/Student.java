package com.jpa.main.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Float cgpa;

    @OneToMany
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<Course> courses;
}
