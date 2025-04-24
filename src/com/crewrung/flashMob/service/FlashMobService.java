package com.crewrung.flashMob.service;

import java.util.List;

import com.crewrung.flashMob.dao.FlashMobDAO;
import com.crewrung.flashMob.vo.FlashMobMainViewVO;

public class FlashMobService {
	private FlashMobDAO flashMobDAO;
	
	public FlashMobService(FlashMobDAO flashMobDAO) {
		this.flashMobDAO = flashMobDAO;
	}
	
	public List<FlashMobMainViewVO> getAllFlashMobs() {
		return flashMobDAO.getAllFlashMobs();
	}
	

}
