package com.example.Email2.services;

import com.example.Email2.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	private static final List<Student> STUDENT_LIST = List.of(
			new Student(1, "Tommaso", "Tranchese", "tommaso.tranchese.96@gmail.com"),
			new Student(2, "Alessandro", "Mazzella", ""),
			new Student(3, "Luciano", "Rea", ""),
			new Student(4, "Daniele", "Rescigno", "")
	);
	
	public Optional<Student> getStudentById(int id) {
		return STUDENT_LIST.stream().filter(student -> student.getId() == id).findAny();
	}
}
