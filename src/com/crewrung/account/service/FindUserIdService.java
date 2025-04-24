package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.FindUserIdVO;

public class FindUserIdService {
	
	private AccountDAO accountDAO;
	
	public FindUserIdService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public String getUserId(FindUserIdVO userIdFindVO){
		
		return accountDAO.getUserId(userIdFindVO);
	}
	

}