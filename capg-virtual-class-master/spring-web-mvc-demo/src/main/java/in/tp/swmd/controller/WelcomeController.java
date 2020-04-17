package in.tp.swmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.tp.swmd.service.GreetService;

@Controller
public class WelcomeController {

	@Autowired
	private GreetService greetservice;
	
	@GetMapping("/greet")
	public ModelAndView shoeGreetPage(@RequestParam(name="num",required=false)
		String username	) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("greet");
		
		if(username!=null) {
			mv.addObject("greetings",greetservice.getGreeting() + username);
		}
			return mv;
	
	
}
}
