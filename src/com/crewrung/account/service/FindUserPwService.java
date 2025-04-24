package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.FindUserPwVO;

public class FindUserPwService {
	
	private AccountDAO accountDAO;
	
	public FindUserPwService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public String getUserPw(FindUserPwVO findUserPwVO){
		return accountDAO.getUserPw(findUserPwVO);
	}
	
	

}
