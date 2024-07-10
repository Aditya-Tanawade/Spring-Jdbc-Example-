package com.Aditya.SpringJdbcExample;

import com.Aditya.SpringJdbcExample.model.Student;
import com.Aditya.SpringJdbcExample.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExampleApplication {

	public static void main(String[] args) {
	ApplicationContext context= SpringApplication.run(SpringJdbcExampleApplication.class, args);

		Student s=	context.getBean(Student.class);
		s.SetName("Sarita");
		s.setMarks(10);
		s.setRollNo(100);

		StudentService service=context.getBean(StudentService.class);

		service.addStudent(s);

		List<Student>students=service.getStudents();
		System.out.println(students);
	}

}
