package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Student;

public interface StudentService {

	public List<Student> studentList();
	
	public List<Map<String,Object>> StudentInfo();
}
