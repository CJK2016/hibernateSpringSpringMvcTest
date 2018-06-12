package com.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.StudentDao;
import com.entity.Student;


@Transactional
@Repository
public class StudentDaoImpl implements StudentDao {

	@Resource
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}

	
	public List<Student> studentList() {
		Session session = null;
		List<Student> list = new ArrayList<Student>();
		try {
			session = getSession();
			Query query = session.createQuery("from Student ");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}


	public List<Map<String, Object>> StudentInfo() {
		List<Map<String, Object>> listInfo = new ArrayList<Map<String,Object>>();
		Session session = null;
		try {
			
			session = getSession();
			String sql = "select id, name, age from student";
		    System.out.println(sql);
			SQLQuery q = session.createSQLQuery(sql)
		             .addScalar("id", StandardBasicTypes.INTEGER)//明确返回值类型，属性名称必须和表中列名相同
		             .addScalar("name", StandardBasicTypes.STRING)
		             .addScalar("age", StandardBasicTypes.INTEGER);
		     List list = q.list();
		     for(Object ob : list) {
		    	 Map<String, Object> map = new HashMap<String, Object>();
		         Object[] ob1 = (Object[]) ob;
		         //System.out.println(ob1[0] + " | " + ob1[1] );
		         map.put("id", ob1[0]);
		         map.put("name", ob1[1]);
		         map.put("age", ob1[2]);
		         listInfo.add(map);
		     }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return listInfo;
	}

	

	
}
