/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tugas_uas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan nama Mahasiswa: ");
        String studentName = scanner.nextLine();
        System.out.println("Masukkan alamat Mahasiswa: ");
        String studentAddress = scanner.nextLine();
        Student student = new Student(studentName, studentAddress);

        System.out.println("Masukan jumlah Dosen: ");
        int numTeachers = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline character dari buffer

        Teacher[] teachers = new Teacher[numTeachers];

        for (int i = 0; i < numTeachers; i++) {
            System.out.println("Masukkan nama Dosen #" + (i + 1) + ": ");
            String teacherName = scanner.nextLine();
            System.out.println("Masukkan alamat Dosen #" + (i + 1) + ": ");
            String teacherAddress = scanner.nextLine();
            teachers[i] = new Teacher(teacherName, teacherAddress);
        }
        
        System.out.println("Berapa jumlah matakuliah Mahasiswa:");
        int numCourses = scanner.nextInt();
        scanner.nextLine();

        String[] studentCourses = new String[numCourses];

        System.out.println("Masukkan " + numCourses + " nama matakuliah untuk mahasiswa:");
        for (int i = 0; i < numCourses; i++) {
            System.out.print((i + 1) + ". ");
            studentCourses[i] = scanner.nextLine();
        }

        int[] studentGrades = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            System.out.println("Masukkan nilai untuk Matakuliah " + studentCourses[i] + ": ");
            studentGrades[i] = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline character dari buffer
        }

        System.out.println("\nBerikut pilihan Matakuliah");
        for (int i = 0; i < numCourses; i++) {
            System.out.println((char) ('a' + i) + " = " + studentCourses[i]);
        }
        System.out.println("0 = selesai");

        for (int i = 0; i < numTeachers; i++) {
            System.out.println("Pilih Matakuliah yang diajarkan oleh Dosen #" + (i + 1) + ":");
            String[] teacherCourses = new String[numCourses];
            int choice;
            int teacherCourseCount = 0;
            do {
                char ch = scanner.next().charAt(0);
                if (ch == '0')
                    break;
                else if (ch >= 'a' && ch <= ('a' + numCourses - 1)) {
                    teacherCourses[teacherCourseCount] = studentCourses[ch - 'a'];
                    teacherCourseCount++;
                }
            } while (true);

            for (int j = 0; j < teacherCourseCount; j++) {
                teachers[i].addCourse(teacherCourses[j]);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            student.addCourseGrade(studentCourses[i], studentGrades[i]);
        }

        System.out.println("\nInformasi Mahasiswa:");
        System.out.println("Nama Mahasiswa: " + student.getName() + "(" + student.getAddress() + ")");
        System.out.print("Nilai Mahasiswa: ");
        for (int i = 0; i < numCourses; i++) {
            System.out.print(studentCourses[i] + ": " + studentGrades[i]);
            if (i < numCourses - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        double avgGrade = 0;
        for (int grade : studentGrades) {
            avgGrade += grade;
        }
        avgGrade /= numCourses;
        System.out.println("Rata-rata Nilai: " + avgGrade);

        for (int i = 0; i < numTeachers; i++) {
            System.out.println("\nInformasi Dosen #" + (i + 1) + ":");
            System.out.println("Nama Dosen: " + teachers[i].getName() + "(" + teachers[i].getAddress() + ")");
            System.out.print("Matakuliah yang diajarkan oleh Dosen #" + (i + 1) + ": ");
            String[] coursesTaught = teachers[i].getCourses();
            for (int j = 0; j < coursesTaught.length; j++) {
                System.out.print(coursesTaught[j]);
                if (j < coursesTaught.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            for (int j = 0; j < numCourses; j++) {
                if (teachers[i].teachesCourse(studentCourses[j])) {
                    System.out.println("Nilai matakuliah " + studentCourses[j] + " milik " + student.getName() + " : " + studentGrades[j]);
                }
            }
        }
    }
}