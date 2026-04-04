package com.CRUDStudentDB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeBController 
{
	@GetMapping("/")
	public String indexpage()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String registerStudentInfo()
	{
		return "register";
	}
	
	@GetMapping("/viewInfo")
	public String viewStudentInfo()
	{
		return "viewInfo";
	}
	
	@GetMapping("/updateInfo")
	public String updateStudentInfo()
	{
		return "updateInfo";
	}
	
	@GetMapping("/remove")
	public String deleteStudentInfo()
	{
		return "remove";
	}
	
	@GetMapping("/showTable")
	public String getTable()
	{
		return "showTable";
	}
	
	@GetMapping("/showAllData")
	public String getAllTable()
	{
		return "showAllData";
	}
	
	@GetMapping("/default")
	public String getDefault()
	{
		return "default";
	}
}
