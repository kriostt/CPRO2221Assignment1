// Assignment 1: Developing CRUD operations for a single entity using Spring boot and Java
// Name: Krisanne Apostol
// Class: CPRO 2221
// Due Date: Feb. 2, 2024

package CPRO2221.Assignment1.controller;

import CPRO2221.Assignment1.entity.Student;
import CPRO2221.Assignment1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class Controller {
    // Annotation automatically injects instance of StudentService
    @Autowired
    private StudentService studentService;

    // Create a new student
    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Retrieve all students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Retrieve a specific student by ID
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return studentService.findById(studentId);
    }

    // Update an existing student
    @PutMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    // Delete a student by ID
    @DeleteMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        return studentService.deleteStudent(studentId);
    }
}
