package com.cg.applicationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.applicationservice.dao.ApplicationDao;
import com.cg.applicationservice.entity.Application;
import com.cg.applicationservice.exception.AlreadyExistsException;
import com.cg.applicationservice.exception.NotFoundException;


@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationDao applicationDao;

	/**
	 * Method: getApplications 
	 * Description: To return the list of applications.
	 * @returns List<Application>: List containing the applications 
	 * @throws UnauthorizedAccessException:it is raised if the account associated with adminId is not an admin type
	 */
	@Override
	public List<Application> getApplications()
	{
		List<Application> findAll = applicationDao.findAll();
		if(findAll.isEmpty())
			throw new NotFoundException("No Applications added in databases");
		return findAll;

	}

	/**
	 * Method: getApplicationById 
	 * Description: To return the application of the user according to application id provided.
	 * @param id: Application's Id
	 * @returns Application: Application with the ID
	 * @throws NotFoundException is raised if no application is present with the ID
	 */
	@Override
	public Application getApplicationById(int id)
	{
		Optional<Application> findById = applicationDao.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		else 
			throw new NotFoundException("Application with id "+id+" not found");


	}
	/**s
	 * Method: addApplication 
	 * Description: Adds a new application into the database
	 * @param application: object containing data about application
	 * @throws AlreadyExistsException is raised if the application provided with the ID is already present
	 */
	@Override
	public Application addApplication(Application application) {
		if(applicationDao.existsById(application.getId()))
		{
			throw new AlreadyExistsException("Application with ID "+application.getId()+" already Exists!");
		}

		return  applicationDao.save(application);

	}


	/**
	 * Method: updateApplication 
	 * Description: Updates the data of Application
	 * @param id: Application ID
	 * @param application: object containing data about application
	 * @throws NotFoundException is raised if there is no application associated with the ID provided
	 */
	@Override
	public void updateApplication(int id, Application application) {
		if(applicationDao.existsById(id))
		{
			applicationDao.save(application);
		}
		else
			throw new NotFoundException("Id is not present");

	}
	/**
	 * Method: deleteApplication 
	 * Description: To return the list of email's of the user according to user status provided.
	 * @param id: Application ID
	 * @throws NotFoundException is raised if there is no application associated with the ID provided
	 */
	@Override
	public void deleteApplication(int id) {

		if(applicationDao.existsById(id))
		{
			applicationDao.deleteById(id);
		}
		else
			throw new NotFoundException("Id is not present");
	}
}