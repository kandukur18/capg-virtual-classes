package in.tp.swmd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	@RequestMapping({"","/","/home"})
	public ModelAndView defaultGetRequestHandler() {
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("home"); // /pages/home.jsp
		mv.addObject("pageTitle","Home Page-Welcome All");
		mv.addObject("developers",new String[] {"vamsy","venkat","srini"});
		
		return mv;
	}
	@RequestMapping("/header")
	public String showheader() {
		return "header";
	}
	@RequestMapping("/footer")
	public String showfooter() {
		return "footer";
	}
}
