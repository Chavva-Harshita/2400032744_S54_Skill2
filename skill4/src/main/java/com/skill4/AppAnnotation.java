package com.skill4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnnotation {

    public static void main(String[] args) {

        @SuppressWarnings("resource")
		ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Student s = context.getBean(Student.class);

        s.display();
    }
}