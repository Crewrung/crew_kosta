package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.UserInfoVO;

public class UserInfoUpdateService {
	private AccountDAO accountDAO;
	
	public UserInfoUpdateService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int setUserInfoUpdate(UserInfoVO userInfoVO){
		
		int result = accountDAO.setUserInfo(userInfoVO);
		return result > 0 ? 1 : 0;
		
	}

}
