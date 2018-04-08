package course.service;

import java.util.ArrayList;
import java.util.List;

import course.entity.Course;

@Service
public class CourseService {

	//这里用List存放数据,以避免数据库的连接操作
		private List<Course> courses = new ArrayList<Course>();
		
		//默认构造函数中添加部分数据,以供测试
		public CourseService() {
			courses.add(new Course("0","J2EE","邱明","海韵104"));
			courses.add(new Course("1","OOAD","邱明","海韵205"));
			courses.add(new Course("2", "软件工程", "王美红", "海韵208"));
		}
		
		//一个简单的通过id来获取课程的函数
		public String getCourseNameById(int id) {
			return courses.get(id).getName().toString();
		}
		
		//添加课程
		public Course addCourse(Course course) {
			courses.add(course);
			return course;
		}
			
}
