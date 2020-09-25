package com.cg.applicationservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.applicationservice.entity.Application;
import com.cg.applicationservice.service.ApplicationService;

@RestController
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	Logger logger=LoggerFactory.getLogger(ApplicationController.class);

	/**
	 * Method: getApplicationList
	 * Description: Used to get the list of applications
	 * @return The list of applications
	 */
	@GetMapping("/applicationList")
	public List<Application> getApplicationList() {
		List<Application> applicationList = null;
		applicationList = applicationService.getApplications();
		logger.info("Returned the application List Successfully");
		return applicationList;
	}

	/**
	 * 
	 * Method: getApplicationsById
	 * Description: Used to get application by ID
	 * @param id of the application to get
	 * @return the application with the id
	 */
	@GetMapping("/applicationList/{id}")	
	public Application getApplicationsById(@PathVariable("id") int id)
	{
		logger.info("Return the application List based on Program Name Successfully");    
		return applicationService.getApplicationById(id);
	}


	/**
	 * Method: addApplication
	 * Description: Used to add a new application
	 * @param application : application details
	 * @return Application
	 */
	@PostMapping("/application")
	public Application addApplication(@RequestBody Application application) {
		logger.info("Application applied successfully");
		return applicationService.addApplication(application);
	}

	/**
	 * Method: updateApplication
	 * Description: Used to add a new application
	 * @param id
	 * @param application
	 * @return message showing successfully added
	 */
	@PutMapping("/updateApplication/{id}")
	public String updateApplication(@PathVariable("id") int id,@RequestBody Application application) {
		logger.info("Application updated successfully");
		applicationService.updateApplication(id,application);
		return "Updated Application Successfully";
	}
	/**
	 * Method: deleteApplication
	 * Description: Used to add a new application
	 * @param id
	 * @return message showing successfully deleted
	 */
	@DeleteMapping("/applicationList/{id}")
	public String deleteApplication(@PathVariable("id") int id) {
		logger.info("Application applied successfully");
		applicationService.deleteApplication(id);
		return "Deleted Application Successfully";
	}




}








//	@PostConstruct
//	public void data() {
//		applicationService.addApplication(new Application(1,"Sashi","03/12/1998","Graduation",90,"get a job","sashi@gmail.com","1","waiting","06/22/2020"));
//		applicationService.addApplication(new Application(2,"Vishal","03/12/1998","Graduation",90,"get a job","vishal@gmail.com","1","waiting","03/22/2020"));
//		applicationService.addApplication(new Application(3,"Bishal","03/12/1998","Graduation",90,"get a job","Bishal@gmail.com","1","waiting","04/12/2020"));
//		applicationService.addApplication(new Application(4,"Preetam","03/12/1998","Graduation",90,"get a job","Preetam@gmail.com","1","waiting","04/22/2020"));
//		applicationService.addApplication(new Application(5,"Abhishek","03/12/1998","Graduation",90,"get a job","Abhishek@gmail.com","1","waiting","04/22/2020"));
//		applicationService.addApplication(new Application(6,"Gyana","03/12/1998","Graduation",90,"get a job","Gyana@gmail.com","1","waiting","04/22/2020"));
//	}




