package course.test;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import course.service.CourseService;
import course.view.*;

@RunWith(SpringRunner.class) //表示使用SpringRunner组件进行单元测试
@WebMvcTest(CourseController.class) //表示要测试的类是CourseController
public class CourseControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	//注入CourseService
	@MockBean
	private CourseService courseService;
	
	
	//测试AddCourse的get请求
	//mockMvc调用perform,返回操作结果
	//andDo(print())表示将返回的结果打印出来
	//andExpect(status().isOk())表示确认返回的http请求状态是否OK
	//andExpect(view().name("addForm"))表示确认返回的视图名字是否是addForm,即确认访问的网页名字是否正确
	@Test
	public void testAddCourse() throws Exception {
		this.mockMvc.perform(get("/course/add")).andDo(print()).andExpect(status().isOk())
		.andExpect(view().name("addForm"));
	}
	
	
	//测试AddCourse的post请求
	//param中是对应的参数和测试的值
	@Test
	public void testAddProcess() throws Exception{
		this.mockMvc
		.perform(post("/course/add").param("course.id", "TestInputId")
				.param("course.name", "TestInputName").param("course.teacher_name", "TestInputTeacherName")
				.param("course.location", "TestInputLocation")
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
		.andExpect(status().isOk()).andExpect(view().name("addForm")).andDo(print());
	}
	
	/*
	@Test
	public void testfindByName() throws Exception{
		this.mockMvc.perform(get("/course/J2EE")).andDo(print()).andExpect(status().isOk())
		.andExpect(view().name("findbyname"));
	}*/

}
