package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.validation.ObjectError;

import course.bean.Course;
import course.bean.ParentUser;
import course.bean.User;
import course.controller.SetSubjectOrCourseController;
import course.controller.user.ParentUserController;
import course.dao.ClassInfoDao;
import course.dao.CourseInfoDao;
import course.service.ClassInfoService;
import course.service.ParentUserService;

public class UserServiceTest
{
	private static Validator validator;
	private static ParentUserService pus;
	
	private static ClassInfoService test1;
	private static CourseInfoDao testcoursedao;
	private static ClassInfoDao testclassdao;
	private static SetSubjectOrCourseController test2;
	private static ParentUserController test3;
	
	/**
	 * 进行一些初始化工作
	 */
	@BeforeClass
	public static void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		pus=new ParentUserService();
		
		test1=new ClassInfoService();
		testcoursedao=new CourseInfoDao();
		testclassdao=new ClassInfoDao();
		test2=new SetSubjectOrCourseController();
		test3=new ParentUserController();
	}
	
	/**
	 * 测试课程信息
	 */
	@Test
	public void testClassAndCourse()
	{
		Course course1=new Course();
		Course course2=new Course();
		Course course3=new Course();
		course1.setCourseId("1");
		course1.setTime("20170330");
		course1.setLocation("B209");
		course1.setTeacher("xsb");
		course1.setContent("ruanjiangongcheng");
		
		course2.setCourseId("2");
		course2.setTime("20190619");
		course2.setLocation("A211");
		course2.setTeacher("dsb");
		course2.setContent("bianyiyuanli");
		
		course3.setCourseId("3");
		course3.setTime("20190511");
		course3.setLocation("A209");
		course3.setTeacher("sb");
		course3.setContent("eng");
		
		
		assertEquals(true, testcoursedao.addCourseList(course1));
		assertEquals(true, testcoursedao.addCourseList(course3));
		assertEquals(true, testcoursedao.changeCourseList("3", course2));
		assertEquals(true, testcoursedao.deletCourseList("3"));
		assertEquals(true, testcoursedao.deletCourseList("3"));
		assertEquals(true, testcoursedao.deletCourseList("2"));
		
		
	}
	
	

	
	
	
	
}
