package com.cg.applicationservice.service;

import java.util.List;
import java.util.Optional;

import com.cg.applicationservice.entity.Application;

public interface ApplicationService {

	void deleteApplication(int id);


	List<Application> getApplications();
	Application getApplicationById(int id);
	Application addApplication(Application application);

	void updateApplication(int id, Application application);
}
