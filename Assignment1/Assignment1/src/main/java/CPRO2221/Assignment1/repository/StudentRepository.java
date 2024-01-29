// Assignment 1: Developing CRUD operations for a single entity using Spring boot and Java
// Name: Krisanne Apostol
// Class: CPRO 2221
// Due Date: Feb. 2, 2024

package CPRO2221.Assignment1.repository;

import CPRO2221.Assignment1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    // Create an empty ArrayList to contain a list of students
    private final List<Student> list = new ArrayList<Student>();

    // Create a new object of Student and add it to the list of students
    public Student save(Student student) {
        Student s = new Student();

        s.setId(student.getId());
        s.setName(student.getName());
        s.setMajor(student.getMajor());

        list.add(s);
        return s;
    }

    // Get the list of all students
    public List<Student> getAllStudents(){
        return list;
    }

    // Get a specific student by specifying their id
    public Student findById(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // Update a specific student by specifying their id
    public Student update(int id, Student updatedStudent) {
        for (Student s : list) {
            if (s.getId() == id) {
                s.setId(updatedStudent.getId());
                s.setName(updatedStudent.getName());
                s.setMajor(updatedStudent.getMajor());
                return s;
            }
        }
        throw new RuntimeException("Student ID " + id + " could not be found.");
    }

    // Delete a specific student by specifying their id
    public String delete(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                list.remove(s);
                return "Student with id " + id + " has been deleted.";
            }
        }
        return "Student ID " + id + " could not be found.";
    }
}
