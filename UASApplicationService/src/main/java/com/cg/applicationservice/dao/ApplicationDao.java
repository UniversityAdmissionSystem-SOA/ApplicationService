
 package com.cg.applicationservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.applicationservice.entity.Application;

public interface ApplicationDao extends JpaRepository<Application, Integer> {
	

}
