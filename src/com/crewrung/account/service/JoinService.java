package com.crewrung.account.service;

import org.apache.ibatis.session.SqlSessionFactory;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.JoinVO;

public class JoinService {
	
	private AccountDAO accountDAO;
	
	public JoinService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int JoinUser(JoinVO joinVO){
		int userIdCheck = accountDAO.isUserIdExist(joinVO);
		if(userIdCheck > 0){
			return 0;
		}
		
		int emailCheck = accountDAO.isEmailExist(joinVO);
		if (emailCheck > 0){
			return 0;
		}
		
		int nickname = accountDAO.isNickNameExist(joinVO);
		if (nickname > 0){
			return 0;
		}
		
		int joinUser = accountDAO.join(joinVO);
		if(joinUser > 0){
			return 1;
		}else{
			return 0;
		}
	}
}