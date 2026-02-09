package com.klu.main;
import org.springframework.context.ApplicationContext; 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.klu.config.AppConfig; 
import com.klu.student.Student;
public class AnnotationMain {
public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class); 
	Student stu=context.getBean(Student.class); stu.display();
}
}
