package com.cjc.Service;

import java.util.List;

import com.cjc.model.Student;

public interface StudentService {

	Student saveStudnts(Student stu);

	Student getStudent(int id);

	List<Student> getallStudent();

	String deletestudent(int id);

	Student updatestudent(int id, Student stu);

	Student editfield(int id, Student stu);

	String logincheck(String username, String password);
}
