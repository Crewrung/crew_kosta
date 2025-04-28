package com.crewrung.account.service;

import org.apache.ibatis.session.SqlSessionFactory;

import com.crewrung.account.dao.AccountDAO;
import com.crewrung.account.vo.JoinVO;

public class JoinService {
	
	private AccountDAO accountDAO;
	
	public JoinService(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	public int joinUser(JoinVO joinVO){
		
		if(!joinVO.getUserPw().equals(joinVO.getUserPwCheck())){
			return 0;
		}
		
		int userIdCheck = accountDAO.isUserIdExist(joinVO);
		if(userIdCheck > 0){
			System.out.println("아이디 중복");
			return 0;
		}
		
		int emailCheck = accountDAO.isEmailExist(joinVO);
		if (emailCheck > 0){
			System.out.println("이메일 중복");
			return 0;
		}
		
		int nickname = accountDAO.isNickNameExist(joinVO);
		if (nickname > 0){
			System.out.println("닉네임 중복");
			return 0;
		}
		
		int guNumber = accountDAO.getGuNumberByName(joinVO.getGuName());
		
		System.out.println("구이름 : " + joinVO.getGuName() + "/ 구 번호 : " + joinVO.getGuNumber());
		
		if(guNumber == 0){
			System.out.println("구 이름에 해당하는 구번호 없음" + joinVO.getGuName());
		}
		
		joinVO.setGuNumber(guNumber);
		System.out.println("설정된 구 번호 : " + joinVO.getGuNumber());
		
		if(joinVO.getIntroduction() == null || joinVO.getIntroduction().isEmpty()){
			joinVO.setIntroduction("자기소개를 입력하세요");
		}
		
		if(joinVO.getProfileImage() == null || joinVO.getProfileImage().isEmpty()){
			joinVO.setProfileImage("default.png");
		}
		
		int joinUser = accountDAO.join(joinVO);
		
		if(joinUser > 0){
			return 1;
		}else{
			return 0;
		}
	}
}