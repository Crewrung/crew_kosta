package com.crewrung.account.service;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.MypageVO;

public class MypageInfoService {
	
	private AccountDAO accountDAO;
	
	public MypageInfoService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	
	public MypageVO getMypageInfo(String userId){
		MypageVO mypageVO = accountDAO.getMypage(userId);
		
	    if (mypageVO == null) {
	        throw new RuntimeException("유저 정보가 존재하지 않습니다.");
	    }
		
		if(mypageVO != null){
			if(mypageVO.getProfileImage() == null){
				mypageVO.setProfileImage("default.png");
			}
			if(mypageVO.getIntroduction() == null){
				mypageVO.setIntroduction("자기소개를 작성하세요");
			}
		}
		return mypageVO;
	}

}
