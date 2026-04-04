package com.CRUDStudentDB.Services;

import java.util.List;

import com.CRUDStudentDB.Entity.Student;

public interface StudentServices 
{
	 String addStudent(Student s);
	 Student getStudent(String kodId);
	 List<Student> getAllStudent();
	 String deleteStudent(String kodId);
	 String updateStudent(Student s);
	Student kodIdExists(String kodId);
}
