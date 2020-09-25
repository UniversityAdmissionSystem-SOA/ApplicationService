
package com.cg.applicationservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.applicationservice.entity.Application;

public interface ApplicationDao extends JpaRepository<Application, Integer> {


}
