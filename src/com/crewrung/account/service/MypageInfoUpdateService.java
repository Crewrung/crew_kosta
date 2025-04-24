package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.MypageVO;

public class MypageInfoUpdateService {
	
private AccountDAO accountDAO;
	
	public MypageInfoUpdateService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int setMypageInfo(MypageVO mypageVO){
		int result = accountDAO.setMypage(mypageVO);
		
		return result > 0 ? 1 : 0;
	}
}
