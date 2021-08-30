package com.midas.securitybasic.web;

import com.midas.securitybasic.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentApiController {

    private static final List<Student> STUDENT = Arrays.asList(
      new Student(1L, "James"),
      new Student(2L, "Maria"),
      new Student(3L, "Anna")
    );

    @GetMapping("/v1/students/{id}")
    public Student getStudent(@PathVariable Long id) {
        return STUDENT.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + id + " does not exists"));
    }
}
