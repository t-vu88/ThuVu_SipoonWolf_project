package com.example.thuvuFinalproject.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

	List<Activity> findByTeam(Team team);
	
	List<Activity> findAll();
}