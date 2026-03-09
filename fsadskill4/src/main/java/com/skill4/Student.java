package com.skill4;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private final int studentId = 102;
    private final String name = "Jahnavi";
    private final String course = "AI";
    private final int year = 3;

    public void display() {

        System.out.println(studentId);
        System.out.println(name);
        System.out.println(course);
        System.out.println(year);
    }
}