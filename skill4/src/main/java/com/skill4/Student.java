package com.skill4;


public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;
	private int id;

    // Constructor Injection
    public Student(int id, String name, String course, int year) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.year = year;
    }
    // Setter Injection
    public void setCourse(String course) {
        this.course = course;
    }

    public void setYear(int year) {
        this.year = year;
    }

   
	public void display() {
		 System.out.println("Student ID: " + studentId);
	        System.out.println("Name: " + name);
	        System.out.println("Course: " + course);
	        System.out.println("Year: " + year);// TODO Auto-generated method stub
		
	}

}