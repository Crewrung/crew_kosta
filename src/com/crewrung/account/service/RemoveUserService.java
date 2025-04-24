package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.MypageVO;

public class RemoveUserService {
	
	private AccountDAO accountDAO;
	
	public RemoveUserService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int removeUser(MypageVO mypageVO){
		int result = accountDAO.removeUser(mypageVO);
		return result > 0 ? 1 : 0;
	}
}
