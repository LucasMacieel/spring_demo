package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			deleteAllStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects...");
		Student student1 = new Student("John", "Doe", "paul@gmail.com");
		Student student2 = new Student("Mary", "Public", "mary@gmail.com");
		Student student3 = new Student("Bonita", "Applebum", "bonita@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Paul", "Doe", "paul@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Daffy", "Duck", "daffy@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated id: " + student.getId());

		System.out.println("Retrieving student with id: " + student.getId());

		Student myStudent = studentDAO.findById(student.getId());

		System.out.println("Find the student: " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();

		for (Student student: studentList) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Duck");

		for (Student student: studentList) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student student = studentDAO.findById(studentId);

		System.out.println("Updating student...");

		student.setFirstName("John");
		studentDAO.update(student);

		System.out.println("Updated student: " + student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;

		System.out.println("Deleting student id: " + studentId);

		studentDAO.delete(studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");

		int deletedRowCount = studentDAO.deleteAll();

		System.out.println("Deleted row count: " + deletedRowCount);
	}
}
