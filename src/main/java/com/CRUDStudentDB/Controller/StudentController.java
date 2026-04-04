package com.CRUDStudentDB.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CRUDStudentDB.Entity.Student;
import com.CRUDStudentDB.Services.StudentServices;

@Controller
@RequestMapping
public class StudentController 
{
	StudentServices ss;
	
	public StudentController(StudentServices ss) {
		super();
		this.ss = ss;
	}
	@PostMapping("/addStudent")
	public String addStudent( @RequestParam ("kodId")String kodId,@RequestParam ("name")String name,@RequestParam ("branch")String branch,RedirectAttributes res) 
	{
		if(ss.kodIdExists(kodId)==null)
		{
			Student s= new Student(kodId, name, branch);
			String s1=ss.addStudent(s);
//			System.out.println(s1);
			res.addFlashAttribute("success", "Student Added Successfull!!");
			return "redirect:/";
		}else {
			res.addFlashAttribute("error", "Already Student Present with ID "+"["+kodId+"]");
			return "redirect:/register";
		}
		
	}
	@GetMapping("/getStudent" )
	public String getStudent(@RequestParam("kodId") String kodId,Model model,RedirectAttributes res) 
	{
		try {
			//---------------------------------
			 Student sts = ss.getStudent(kodId);
			 Model aa = model.addAttribute("Student",sts);
			 System.out.println(sts);
		return "showTable";
		//-------------------------------------
		
		}
		catch (Exception e) {
			// TODO: handle exception
			res.addFlashAttribute("error", "Student Not Found with ID ["+kodId+"]");
			return "redirect:/viewInfo";
		}
	}
	@GetMapping("/show")
	public String getAllStudent(Model model) 
	{
		List<Student> listStudent=ss.getAllStudent();
		model.addAttribute("list",listStudent);
		System.out.println(listStudent);
		return "showAllData";
	}
	
	@PutMapping("/u")
	public String updateStudent(@RequestParam("kodId")String kodId,@RequestParam("name") String name,@RequestParam("branch") String branch,RedirectAttributes res ) 
	{
		try {
		Student s = ss.getStudent(kodId);
		s.setName(name);
		s.setBranch(branch);
		ss.updateStudent(s);
		res.addFlashAttribute("success", "Student UpDate Successfull!!");
		return "redirect:/";
		}
		catch (Exception e) {
			// TODO: handle exception
			res.addFlashAttribute("error", "Student Not Found with ID ["+kodId+"]");
			return "redirect:/updateInfo";
		}
	}
	
	@DeleteMapping("/deleteStudent")
	public String delete( @RequestParam("kodId") String kodId,RedirectAttributes res) {
		try {
			//---------------------------
			ss.getStudent(kodId);
			String deleteStudent = ss.deleteStudent(kodId);
			res.addFlashAttribute("success", "Student with ID ["+kodId+"] is Deleted Successfully!!");
			return "redirect:/show";
			//----------------------------+
		}
		catch (Exception e) {
			// TODO: handle exception
			res.addFlashAttribute("error", "Student Not Found With ID ["+kodId+"]");
			return "redirect:/remove";
		}
		
	}

}
