package com.capg.labbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capg.labbook.model.Trainee;
import com.capg.labbook.service.TraineeService;


@Controller
public class TraineeManagementController {

	@Autowired(required = false)
	TraineeService traineeService;
	
	
	@GetMapping("/addTrainee")
	public String showAddTraineePage()
	{
		return "addTrainee";
	}
	
	@PostMapping("/add")
	public ModelAndView addTrainee(@ModelAttribute("trainee") Trainee trainee){
			traineeService.addTrainee(trainee);
			return new ModelAndView("addTrainee","trainee",trainee);
					
	 }
	
	@GetMapping("/retrieveTrainee")
	public String showRetrievePage()
	{
	      return "retrieveTrainee"; 	
	}
	
	@GetMapping("/retrieve")
	public ModelAndView getTraineeById(@RequestParam("traineeId") int id)
	{ 
		  
	      return new ModelAndView("retrieveTrainee","trainee", traineeService.getTraineeById(id));
	}
		
	@GetMapping("/deleteTrainee")
	public String showDeleteTraineePage()
	{
	      return "deleteTrainee"; 	
	}
	
	@RequestMapping("/delete")
	public String deleteTrainee(@RequestParam("traineeId") int traineeId)
	{
		 traineeService.deleteTrainee(traineeId);
	   	 return "traineeManagementPage";
	}
	
	@GetMapping("/retrieveAllTrainee")
	public ModelAndView showRetrieveAllTraineesPage()
	{
		return new ModelAndView("retrieveAllTrainee","traineeList",traineeService.getAllTrainees());
	}
	
	@GetMapping("/modifyTrainee")
	public String showModifyTraineePage()
	{	
		return "modifyTrainee";
	}
	
	@RequestMapping("/modify")
	public ModelAndView updateTrainee(@RequestParam int traineeId)
	{	
		  Trainee trainee=traineeService.getTraineeById(traineeId);
		  return new ModelAndView("modify1","trainee",trainee); 
	}
	
	@RequestMapping("/modify1")
	public String updateTrainee1(@ModelAttribute Trainee trainee)
	{
	    	   traineeService.updateTrainee(trainee);
	    	  return "traineeManagementPage"; 
	}
}
