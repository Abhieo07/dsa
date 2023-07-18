package Oops;

import java.util.Scanner;

public class StudentClass {

    static void fun(Student s){
        System.out.println(s.getRno());
        System.out.println(s.name);
        System.out.println(s.percent);
        System.out.println(s.schoolName);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Student s1 = new Student(); // declaration
        // s1.name = "Gautam"; //s1 is object
        // s1.setRno(63);
        // s1.percent = 86.2;
        // fun(s1);

        Student s = new Student("Gautam",63,86.5);
        System.out.println(Student.getNumberOfStudents());
        Student s2 = new Student("Aman",65,76.5);
        System.out.println(Student.getNumberOfStudents());
        Student s3 = new Student("Akshay",67,96.5);
        System.out.println(Student.getNumberOfStudents());
        fun(s);

    }
}


