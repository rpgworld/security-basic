package com.midas.securitybasic.web;

import com.midas.securitybasic.domain.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/management/api")
public class StudentManagementApiController {

    private static final List<Student> STUDENT = Arrays.asList(
            new Student(1L, "James"),
            new Student(2L, "Maria"),
            new Student(3L, "Anna")
    );

    @GetMapping("/v1/students")
    //@PreAuthorize("hasAnyRole('ROLE_ADMIN, ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENT;
    }

    @PostMapping("/v1/students")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @DeleteMapping("/v1/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        System.out.println(id);
    }

    @PutMapping("/v1/students/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
        System.out.println(String.format("%s %s", student, student));
    }
}
