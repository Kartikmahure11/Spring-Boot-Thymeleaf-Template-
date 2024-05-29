package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Student;
import com.example.repository.Repo;

@org.springframework.stereotype.Controller

public class Controller
{
	@Autowired
	 Repo r;

	@RequestMapping("/")
	String fun()
	{
		return "page.html";
	}
	
	@RequestMapping("/reg")
	String fun1(Model m)
	{
		Student st=new Student();
		m.addAttribute("stud",st);
		System.out.println("Page A : "+st);
		return "pageA.html";
	}
	
	@RequestMapping("/show")
	@ResponseBody
	String fun2(@ModelAttribute("stud") Student sr)
	{
		System.out.println("Page B : "+sr);
 	    r.save(sr);
		return "data inserted";
	}
}
