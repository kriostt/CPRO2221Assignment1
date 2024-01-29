// Assignment 1: Developing CRUD operations for a single entity using Spring boot and Java
// Name: Krisanne Apostol
// Class: CPRO 2221
// Due Date: Feb. 2, 2024

package CPRO2221.Assignment1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok annotations to automatically generate code for getters, setters, and constructors
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String major;
}
