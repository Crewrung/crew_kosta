package com.crewrung.account.service;

import org.apache.ibatis.session.SqlSessionFactory;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.LoginVO;
import com.crewrung.account.vo.FindUserIdVO;

public class LoginService {
	
	private AccountDAO accountDAO;
	
	public LoginService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int Login(LoginVO loginVO){
		LoginVO loginUser = accountDAO.login(loginVO);
		if (loginUser != null){
			loginVO.setNickname(loginUser.getNickname());
			return 1;
		}else {
			return 0;
		}
	}
}