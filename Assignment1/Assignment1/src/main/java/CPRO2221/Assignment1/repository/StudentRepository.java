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
    public String save(Student student) {
        Student s = new Student();

        // Get new student's attribute values from request body and set the values into the new object in the list
        s.setId(student.getId());
        s.setName(student.getName());
        s.setMajor(student.getMajor());

        list.add(s);
        return "Student " + s.getName() + " has been added.";
    }

    // Get the list of all students
    public List<Student> getAllStudents(){
        return list;
    }

    // Get a specific student by specifying their id
    public Student findById(int id) {
        // Check every student in the list and if their id matches the specified id, return the student
        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        // If student id is not found, return null
        return null;
    }

    // Update a specific student by specifying their id
    public Student update(int id, Student updatedStudent) {
        // Check every student in the list and if their id matches the specified id,
        // update their attributes using the values from the request body, and return the student
        for (Student s : list) {
            if (s.getId() == id) {
                s.setId(updatedStudent.getId());
                s.setName(updatedStudent.getName());
                s.setMajor(updatedStudent.getMajor());
                return s;
            }
        }
        // If student id is not found, throw an exception to let user know
        throw new RuntimeException("Student ID " + id + " could not be found.");
    }

    // Delete a specific student by specifying their id
    public String delete(int id) {
        // Check every student in the list and if their id matches the specified id,
        // remove the student from the list and let the user know that the student has been deleted
        for (Student s : list) {
            if (s.getId() == id) {
                list.remove(s);
                return "Student with id " + id + " has been deleted.";
            }
        }
        // If the student id is not found, return a statement to let user know
        return "Student ID " + id + " could not be found.";
    }
}
