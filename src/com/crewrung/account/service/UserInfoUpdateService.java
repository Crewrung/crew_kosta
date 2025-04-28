package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.UserInfoVO;
import com.crewrung.account.vo.UserUpdateInfoVO;

public class UserInfoUpdateService {
	private AccountDAO accountDAO;
	
	public UserInfoUpdateService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int setUserInfoUpdate(UserUpdateInfoVO userUpdateInfoVO){
		
		int result = accountDAO.setUserInfo(userUpdateInfoVO);
		return result > 0 ? 1 : 0;
		
	}

}
