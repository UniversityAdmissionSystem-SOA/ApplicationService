package com.cg.applicationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.applicationservice.dao.ApplicationDao;
import com.cg.applicationservice.entity.Application;
import com.cg.applicationservice.exception.NotFoundException;


@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationDao applicationDao;

	@Override
	public List<Application> getApplications()
	{
		return applicationDao.findAll();

	}
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

	@Override
	public Application addApplication(Application application) {
		
		
		return  applicationDao.save(application);

	}

	@Override
	public void updateApplication(int id, Application application) {
		if(applicationDao.existsById(id))
			{
			applicationDao.save(application);
			}
		else
			throw new NotFoundException("Id is not present");

	}
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