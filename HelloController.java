package p1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/kal")
	
	public String akash()
	{
		return "index";
	}
	
	@RequestMapping("/hi")
	public String hello(Model model) {
		model.addAttribute("msg" , "Welcome to spring MVC");
		model.addAttribute("name" , "Neya");
		return "hello";
	}
	@RequestMapping("/student")
	public String Student(Model model) {
		student s = new student();
		s.setId(101);
		s.setName("Neya");
		model.addAttribute("student" , s);
		
		return "student";
		
	}
	@RequestMapping("/jona")
	public String courses(Model model) {
		List<String> list = List.of("Spring" , "Hibernate" ,"Microservices" , "Servlet");
		model.addAttribute("courses" , list);
		return "courses";
	}
	@RequestMapping("/sam")
	public ModelAndView home()
	{
		ModelAndView ob = new ModelAndView();
		
		ob.addObject("name","Neya");
		ob.addObject("mobile",3333);
		ob.addObject("address","chennai");
		System.out.println("This is home url");
		
		ob.setViewName("first");
		
		return ob;
	}
	@RequestMapping("/move")
	public ModelAndView home1()
	{
		ModelAndView ob = new ModelAndView();
		ob.addObject("name" , "Neya");
		ob.addObject("mobile" , 2222);
		System.out.println("THIS IS HOME URL");
		List<Integer> list = new ArrayList<Integer>();
		list.add(111);
		list.add(22);
		list.add(33);
		list.add(44);
		ob.addObject("mylist",list);
		ob.setViewName("second");
		return ob;
	}
	@RequestMapping("/home")
	public String showform()
	{
		System.out.println("I am contact");
		return "contact";
	}
	@RequestMapping(value="/processform" , method = RequestMethod.POST)
	public String Handleform(@RequestParam("a") String x,
			@RequestParam("b") String y,
			@RequestParam("c") String z,Model object1)
	{
		object1.addAttribute("id",x);
		object1.addAttribute("name",y);
		object1.addAttribute("mobile" , z);
		return "success";
	}
	

}
