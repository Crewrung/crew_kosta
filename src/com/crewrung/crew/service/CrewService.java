package com.crewrung.crew.service;



import com.crewrung.crew.dao.CrewDAO;


public class CrewService {
	private CrewDAO crewDAO;
	
	public CrewService(CrewDAO crewDAO) {
		this.crewDAO = crewDAO;
	}
}