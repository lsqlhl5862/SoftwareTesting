package course.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import course.entity.Course;
import course.service.CourseService;

@RunWith(SpringRunner.class)
public class CourseServiceTest {
	
	//测试函数getCourseNameById
	@Test
	public void testGetCourseNameById() {
		//实例化一个CourseService
		CourseService courseService = new CourseService();
		//调用getCourseNameById函数,提供测试数据"1"
		String str = courseService.getCourseNameById(1);
		//比对返回的数据是否是"OOAD"
		assertEquals("OOAD", str);
	}
	
	//测试函数addCourse
	@Test
	public void testAddCourse() {
		//创建Mock对象
		CourseService courseService = mock(CourseService.class);
		
		Course course = new Course("1", "J2EE", "邱明", "海韵104");
		courseService.addCourse(course);
		
		//验证Mock对象函数是否执行,执行次数(默认执行次数为1)
		verify(courseService).addCourse(course);
	}
	

}
