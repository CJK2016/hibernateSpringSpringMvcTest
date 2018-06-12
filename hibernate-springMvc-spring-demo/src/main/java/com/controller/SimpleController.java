package com.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.entity.Student;
import com.service.StudentService;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("simpleAction")
public class SimpleController {

	@Autowired
	private StudentService stuService;
    
    @RequestMapping("test")
    @ResponseBody
    public void test(){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setHeader("Content-type", "text/html;charset=utf-8");
        PrintWriter write = null;
        try {
            write = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        write.print("test");
    }
    
    @RequestMapping("test2")
    public String test2(HttpServletRequest request, HttpServletResponse response){
    	
        System.out.println("½øÈëtest2");
        List<Student> stuInfo =  stuService.studentList();
        
        for (Student student : stuInfo) {
			System.out.println(student.getId()+"---"+student.getName()+"---"+student.getAge());
		}
        
        List<Map<String,Object>> stuInfo2 =  stuService.StudentInfo();
        for (Map<String, Object> map : stuInfo2) {
			System.out.println(map.get("id")+"--"+map.get("name")+"--"+map.get("age"));
		}
        
        return "test";
    }
    
    
    @RequestMapping(value = "test3", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	JSONObject json = new JSONObject();
    	json.put("test", "this is the test json");
    	PrintWriter write = response.getWriter();
    	response.setContentType("text/html;charset=UTF-8");  
    	write.print(json);
    }

}