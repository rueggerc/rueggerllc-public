package com.rueggerllc.delegates;

import java.util.List;

import com.rueggerllc.beans.Course;
import com.rueggerllc.daos.CourseDAO;
import com.rueggerllc.daos.CourseDAOImpl;

public class CourseDelegate {
	
	private CourseDAO dao = new CourseDAOImpl();
	
	public List<Course> getAllCourses() throws Exception {
		List<Course> courses = dao.findAll(Course.class);
		return courses;
	}
	
	public Course getCourse(Long id) throws Exception {
		Course course = dao.read(Course.class, id);
		return course;
	}

}
