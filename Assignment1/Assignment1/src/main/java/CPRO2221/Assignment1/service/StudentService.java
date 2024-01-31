// Assignment 1: Developing CRUD operations for a single entity using Spring boot and Java
// Name: Krisanne Apostol
// Class: CPRO 2221
// Due Date: Feb. 2, 2024

package CPRO2221.Assignment1.service;

import CPRO2221.Assignment1.entity.Student;
import CPRO2221.Assignment1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    // Annotation automatically injects instance of StudentRepository
    @Autowired
    private StudentRepository studentRepository;

    // Save student by calling the save() function from StudentRepository
    public String saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students by calling the getAllStudents() function from StudentRepository
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    // Get specific student by calling the findById() function from StudentRepository
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    // Update student by calling the update() function from StudentRepository
    public String updateStudent(int id, Student student) {
        return studentRepository.update(id, student);
    }

    // Delete student by calling the delete() function from StudentRepository
    public String deleteStudent(int id) {
        return studentRepository.delete(id);
    }
}
