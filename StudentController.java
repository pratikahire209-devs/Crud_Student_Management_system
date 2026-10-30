package com.example.crudproject.controller;
import com.example.crudproject.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.example.crudproject.service.StudentService;

@Component
@RestController
@RequestMapping("/api/Student")
public class StudentController {

    private StudentService studentservice;

    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @PostMapping("/Create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdstudent = studentservice.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdstudent);
    }

    @GetMapping("/GET/{id}")
    public Student getstudent(@PathVariable Long id) {
        Student gotstudent = studentservice.getstudent(id);
        return gotstudent;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updatestudent(@PathVariable Long id, @RequestBody Student student) {
        Student updated = studentservice.updatestudent(id, student);
        return ResponseEntity.ok(updated);
    }
}