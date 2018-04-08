package course.view;

//这个包手动添加,包含了GET,POST等声明
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import course.entity.Course;
import course.service.CourseService;

//添加Controller的注解
@Controller
//控制器指定可以处理哪些URL请求
@RequestMapping("/course")  
public class CourseController {
	
	
	@Autowired
	CourseService courseService = new CourseService();
	
	//匹配到的网页地址是http://localhost:8080/course/add
	//value定义网页访问路径,method定义http的请求方式
	@RequestMapping(value="/add",method=GET)
	public String courseForm() {
		//正常应该返回一个网页的文件名,这里暂且返回course.view.vo中的AddForm
		return "addForm";
	}
	
	//可以将post需要传递的数据利用addAttribute函数添加到model中
	@RequestMapping(value="/add",method=POST)
	public String courseSubmit(Course course,Model model) {
		model.addAttribute(course);
		//调用addCourse()函数
		courseService.addCourse(course);
		return "addForm";
	}
	
	@RequestMapping(value="/{id}",method=GET)
	public String getCourseNameById(@PathVariable int id,Model model) {
		model.addAttribute("course", courseService.getCourseNameById(id));
		return "findbyid";
	}
}
