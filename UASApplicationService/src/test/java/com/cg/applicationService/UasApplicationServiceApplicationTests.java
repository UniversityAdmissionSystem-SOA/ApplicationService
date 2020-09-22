package com.cg.applicationService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.applicationservice.dao.ApplicationDao;
import com.cg.applicationservice.entity.Application;
import com.cg.applicationservice.exception.NotFoundException;
import com.cg.applicationservice.service.ApplicationService;
import com.cg.applicationservice.service.ApplicationServiceImpl;

import org.springframework.boot.test.context.SpringBootTest;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationServiceImpl.class)
public class UasApplicationServiceApplicationTests {

	
	@Autowired
	private ApplicationService service;

	@MockBean
	private ApplicationDao repository;
	
	@Test
	public void getApplicationsTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Application(1,"Sashi","03/12/1998","Graduation",90,"get a job","sashi@gmail.com","1","waiting","04/22/2020")
						, new Application(2,"Vishal","04/12/1998","Graduation",90,"get a job","vishal@gmail.com","1","waiting","04/22/2020"))
						.collect(Collectors.toList()));
		assertEquals(2, service.getApplications().size());
	}

	@Test
	public void getApplicationbyIdTest() {
		int id = 1;
		Application application = new Application(1,"Sashi","03/12/1998","Graduation",90,"get a job","sashi@gmail.com","1","waiting","04/22/2020");
		when(repository.findById(id))
		.thenReturn(Optional.of(application));
		assertEquals(application, service.getApplicationById(id));
	}
	
	@Test
	public void addApplicationTest() {
		Application user = new Application(1,"Sashi","03/12/1998","Graduation",90,"get a job","sashi@gmail.com","1","waiting","04/22/2020");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.addApplication(user));
	}
	@Test
	public void updateApplicationTest() {
		Application application = new Application(1,"Sashi","03/12/1998","Graduation",90,"get a job","sashi@gmail.com","1","waiting","04/22/2020");
		repository.findById(1);
		repository.save(application);
		verify(repository,Mockito.times(1)).save(application);
		
	}
	
	@Test
	public void deleteApplicationTest() {
		Application application = new Application(1,"Sashi","03/12/1998","Graduation",90,"get a job","sashi@gmail.com","1","waiting","04/22/2020");
		repository.deleteById(1);
		verify(repository,Mockito.times(1)).deleteById(1);;
		
	}

	@Test(expected = NotFoundException.class)
	public void getApplicationbyIdNotPresentTest() {
		int id = 1;
		Application application = new Application(1,"Sashi","03/12/1998","Graduation",90,"get a job","sashi@gmail.com","1","waiting","04/22/2020");
		when(repository.findById(id))
		.thenReturn(Optional.of(application));
		int idToCheck=2;
		assertEquals(application, service.getApplicationById(idToCheck));
	}
	
}
