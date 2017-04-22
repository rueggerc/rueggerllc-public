package com.rueggerllc.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.rueggerllc.beans.Account;
import com.rueggerllc.beans.Course;
import com.rueggerllc.beans.Student;
import com.rueggerllc.daos.StudentDAO;
import com.rueggerllc.daos.StudentDAOImpl;

public class StudentDaoTest {
	
	private static Logger logger = Logger.getLogger(StudentDaoTest.class);
	
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
	public void testGetAllStudents() throws Exception {
	    logger.info("Get All Students");	    
	    StudentDAO dao = new StudentDAOImpl();
	    List<Student> students = dao.findAll(Student.class);
	    logger.info("GOT STUDENTS:" + students.size());
	    for (Student student : students) {
	    	logger.info("Next Student=" + student.getId());
		    for (Course course : student.getCourses()) {
		    	logger.info("\tNext Course=" + course.getName());
		    }	    	
	    	
	    }

	}
	

	@Test
	@Ignore
	public void testCreateStudentsAndCourses() throws Exception {
	    logger.info("Add Students and Courses");

	    Student student1 = new Student();
	    student1.setFirstName("Fred");
	    student1.setLastName("Smith");
	    student1.setStatus(100);
	    
	    Student student2 = new Student();
	    student2.setFirstName("Barney");
	    student2.setLastName("Rubble");
	    student2.setStatus(200);
	    
	    Course course1 = new Course();
	    course1.setName("Biology");
	    course1.setStatus(352);
	    course1.setTeacher("Goodyear");
	    
	    Course course2 = new Course();
	    course2.setName("Chemisty");
	    course2.setStatus(421);
	    course2.setTeacher("Binder");
	    
	    Course course3 = new Course();
	    course3.setName("Calculus");
	    course3.setStatus(113);
	    course3.setTeacher("Sheridan");
	    
	    student1.getCourses().add(course1);
	    student1.getCourses().add(course2);
	    
	    student2.getCourses().add(course3);
	    
	    StudentDAO dao = new StudentDAOImpl();
	    dao.save(student1);
	    dao.save(student2);
	}
	
	

}
