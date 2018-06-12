package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Student;


public interface StudentDao {

	public List<Student> studentList();

	public List<Map<String, Object>> StudentInfo();
	
}
