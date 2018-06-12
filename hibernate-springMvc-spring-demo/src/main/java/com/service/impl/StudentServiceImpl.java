package com.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StudentDao;
import com.entity.Student;
import com.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao stuDao;
	
	public List<Student> studentList() {
		return stuDao.studentList();
	}

	public List<Map<String, Object>> StudentInfo() {
		return stuDao.StudentInfo();
	}

	
}
