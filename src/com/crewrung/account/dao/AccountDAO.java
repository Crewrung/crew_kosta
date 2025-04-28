package com.crewrung.account.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.vo.JoinVO;
import com.crewrung.account.vo.LoginVO;
import com.crewrung.account.vo.MypageVO;
import com.crewrung.account.vo.FindUserIdVO;
import com.crewrung.account.vo.FindUserPwVO;
import com.crewrung.account.vo.UserUpdateInfoVO;

public class AccountDAO {

	SqlSession con;

	public AccountDAO(SqlSession sqlsession){
		this.con = sqlsession;
	}

	// 로그인 O
	public LoginVO login(LoginVO loginVO){
		return con.selectOne("accountMapper.Login",loginVO);
	}

	// 마이페이지 O
	public MypageVO getMypage(String userId){
		MypageVO mypage = con.selectOne("accountMapper.getMypageInfo", userId);

		if (mypage != null){
			List<String> crewNames = con.selectList("accountMapper.getMypageCrew", userId);
			mypage.setCrewNames(crewNames);

			List<String> flashMobTitles = con.selectList("accountMapper.getMypageFlashMob", userId);
			mypage.setFlashMobTitles(flashMobTitles);
		}
		return mypage;
	}
	
	// 마이페이지  수정 O
	public int setMypage(MypageVO mypageVO){
		return con.update("accountMapper.setMypage", mypageVO);
	}
	
	// 회원가입  O
	public int join(JoinVO joinVO){
		
		int result =  con.insert("accountMapper.Join", joinVO);
		System.out.println("회원가입 쿼리 결과" + result);
		return result;
	}
	
	// 구이름 -> 구넘버
	public int getGuNumberByName(String guName) {
	    Integer guNumber = con.selectOne("accountMapper.getGuNumberByName", guName);
	    
	    if(guNumber == null){
	    	System.out.println("구 번호가 없습니다." + guName);
	    	return 0;
	    }
	    
	    System.out.println("구 번호: " + guNumber);
	    return guNumber;
	}
	
	// 회원탈퇴 O
	public int removeUser(UserUpdateInfoVO vo){
		return con.delete("accountMapper.removeUser", vo);
	}
	
	// 아이디 찾기 O
	public String getUserId(FindUserIdVO useridFindVO){
		return con.selectOne("accountMapper.getUserId", useridFindVO);
	}
	
	// 비밀번호 찾기 O
	public String getUserPw(FindUserPwVO userPwFindVO){
		return con.selectOne("accountMapper.getUserPw", userPwFindVO);
	}
	
	// 개인정보 수정
	public int setUserInfo(UserUpdateInfoVO UserUpdateInfoVO){
		return con.update("accountMapper.setUserInfo", UserUpdateInfoVO);
	}
	
	// 아이디 중복 체크 O
	public int isUserIdExist(JoinVO joinVO){
		return con.selectOne("accountMapper.isUserIdExist", joinVO);
	}
	// 이메일 중복 체크 O
	public int isEmailExist(JoinVO joinVO){
		return con.selectOne("accountMapper.isEmailExist", joinVO);
	}
	// 닉네임 중복 체크 O
	public int isNickNameExist(JoinVO joinVO){
		return con.selectOne("accountMapper.isNickNameExist", joinVO);
	}
	


}