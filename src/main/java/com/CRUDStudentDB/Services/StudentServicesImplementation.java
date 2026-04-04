package com.CRUDStudentDB.Services;

import java.util.List;



import org.springframework.stereotype.Service;

import com.CRUDStudentDB.Entity.Student;
import com.CRUDStudentDB.Repository.StudentRepositry;

@Service
public class StudentServicesImplementation  implements StudentServices
{
	StudentRepositry sRepo;
	Student st;
	
	public StudentServicesImplementation(StudentRepositry sRepo) 
	{
		super();
		this.sRepo = sRepo;
	}

	@Override
	public String addStudent(Student s) 
	{
		sRepo.save(s);
		return "Student Added";
	}

	@Override
	public Student getStudent(String kodId) 
	{
		st = sRepo.findById(kodId).get();
		return st;
	}

	@Override
	public List<Student> getAllStudent() 
	{
		List<Student> listStudent = sRepo.findAll();
		return listStudent;
	}

	@Override
	public String deleteStudent(String kodId) 
	{
		sRepo.deleteById(kodId);
		return "Student Deleted";
	}

	@Override
	public String updateStudent(Student s) 
	{
		sRepo.save(s);
		return "Student Updated";
	}

	@Override
	public Student kodIdExists(String kodId) {
		// TODO Auto-generated method stub
		Student existsByKodId = sRepo.findByKodId(kodId);
		return existsByKodId;
	}
	
}
