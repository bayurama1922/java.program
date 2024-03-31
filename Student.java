/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tugas_uas;

public class Student extends Person {
    private int numCourses = 0;
    private String[] courses;
    private int[] grades;
    
    public Student(String name, String address) {
        super(name, address);
        courses = new String[30]; // Assuming a student can take up to 30 courses
        grades = new int[30];
    }

    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
    }

    public void printGrades() {
        System.out.print(getName() + "'s grades: ");
        for (int i = 0; i < numCourses; i++) {
            System.out.print(courses[i] + ": " + grades[i] + ", ");
        }
        System.out.println();
    }

    public double getAverageGrade() {
        if (numCourses == 0)
            return 0;
        
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }

    public String toString() {
        return "Student: " + super.toString();
    }
}
