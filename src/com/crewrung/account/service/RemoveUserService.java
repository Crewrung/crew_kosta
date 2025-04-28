package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.MypageVO;
import com.crewrung.account.vo.UserUpdateInfoVO;

public class RemoveUserService {
	
	private AccountDAO accountDAO;
	
	public RemoveUserService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int removeUser(UserUpdateInfoVO userUpdateInfoVO){
		int result = accountDAO.removeUser(userUpdateInfoVO);
		return result > 0 ? 1 : 0;
	}
}
