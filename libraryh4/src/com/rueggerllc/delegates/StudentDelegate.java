package com.rueggerllc.delegates;

import java.util.List;

import com.rueggerllc.beans.Student;
import com.rueggerllc.daos.StudentDAO;
import com.rueggerllc.daos.StudentDAOImpl;

public class StudentDelegate {
	
	private StudentDAO dao = new StudentDAOImpl();
	
	public List<Student> getAllStudents() throws Exception {
		List<Student> students = dao.findAll(Student.class);
		return students;
	}
	
	public Student getStudent(Long id) throws Exception {
		Student student = dao.read(Student.class, id);
		return student;
	}

}
