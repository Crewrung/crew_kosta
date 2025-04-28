package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.UserInfoVO;
import com.crewrung.account.vo.UserUpdateInfoVO;

public class UserUpdateInfoService {
	private AccountDAO accountDAO;
	
	public UserUpdateInfoService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int setUserInfo(UserUpdateInfoVO userUpdateInfoVO){
		
		if(!userUpdateInfoVO.getUserPw().equals(userUpdateInfoVO.getUserPwCheck())){
			return 0;
		}
		
		int guNumber = accountDAO.getGuNumberByName(userUpdateInfoVO.getGuName());
		userUpdateInfoVO.setGuNumber(guNumber);
		
		int result = accountDAO.setUserInfo(userUpdateInfoVO);
		return result > 0 ? 1 : 0;
		
	}

}
