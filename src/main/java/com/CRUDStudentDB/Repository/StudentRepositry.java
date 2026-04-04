package com.CRUDStudentDB.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.CRUDStudentDB.Entity.Student;

public interface StudentRepositry extends JpaRepository<Student,String> 
{

	Student findByKodId(String kodId);
	
}
