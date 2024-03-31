/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tugas_uas;

import java.util.Arrays;

public class Teacher extends Person {
    private int numCourses;
    private String[] courses;

    public Teacher(String name, String address) {
        super(name, address);
        numCourses = 0;
        courses = new String[10];
    }

    public boolean addCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                return false; // Course already exists
            }
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        boolean found = false;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                found = true;
                
                for (int j = i; j < numCourses - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                numCourses--;
                break;
            }
        }
        return found;
    }

    public boolean teachesCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                return true;
            }
        }
        return false;
    }

    public String[] getCourses() {
        return Arrays.copyOf(courses, numCourses);
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }
}