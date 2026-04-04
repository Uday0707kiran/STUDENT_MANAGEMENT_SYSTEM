package com.CRUDStudentDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUDStudentDB.Entity.Student;

@Repository
public interface StudentRepositry extends JpaRepository<Student,String> 
{

	Student findByKodId(String kodId);
	
}
