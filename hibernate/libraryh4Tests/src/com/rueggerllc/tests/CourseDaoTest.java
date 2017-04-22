package com.rueggerllc.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.rueggerllc.beans.Course;
import com.rueggerllc.beans.Student;
import com.rueggerllc.daos.CourseDAO;
import com.rueggerllc.daos.CourseDAOImpl;
import com.rueggerllc.daos.StudentDAO;
import com.rueggerllc.daos.StudentDAOImpl;

public class CourseDaoTest {
	
	private static Logger logger = Logger.getLogger(CourseDaoTest.class);
	
	@BeforeClass
	public static void setupClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setupTest() throws Exception {
	}

	@After
	public void tearDownTest() throws Exception {
	}
	
	@Test
	@Ignore
	public void dummyTest() {
		logger.info("Inside Dummy Test");
	}
	
	@Test
	@Ignore
	public void testCreateCourses() throws Exception {
	    logger.info("Courses");

	    Course course1 = new Course();
	    course1.setName("Archaeology");
	    course1.setStatus(299);
	    course1.setTeacher("Dr. Jones");
	    
	    Course course2 = new Course();
	    course2.setName("Physics");
	    course2.setStatus(877);
	    course2.setTeacher("Einstein");
	    
	    Course course3 = new Course();
	    course3.setName("English");
	    course3.setStatus(42);
	    course3.setTeacher("Drake");
	    
	    CourseDAO dao = new CourseDAOImpl();
	    dao.save(course1);
	    dao.save(course2);
	    dao.save(course3);
	    
	
	}
	
	@Test
	@Ignore
	public void testGetCoursesForStudent() throws Exception {
	    logger.info("Get Courses For Student");
	    StudentDAO dao = new StudentDAOImpl();
	    Student student1 = dao.read(Student.class, new Long(10000));
	    for (Course course : student1.getCourses()) {
	    	logger.info("Next Course=" + course.getName());
	    }
	}
	
	@Test
	// @Ignore
	public void testGetAllCourses() throws Exception {
	    logger.info("Get All Courses");	    
	    CourseDAO dao = new CourseDAOImpl();
	    List<Course> courses = dao.findAll(Course.class);
	    logger.info("GOT COURSES:" + courses.size());
	    for (Course course : courses) {
	    	logger.info("Next Course=" + course.getName());
	    }
	}
	

	

}
