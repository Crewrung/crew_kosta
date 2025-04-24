package com.crewrung.account.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.crewrung.account.vo.JoinVO;
import com.crewrung.account.vo.LoginVO;
import com.crewrung.account.vo.MypageVO;
import com.crewrung.account.vo.UserIdFindVO;
import com.crewrung.account.vo.UserInfoVO;
import com.crewrung.account.vo.UserPwFindVO;
import com.crewrung.account.vo.UserSetVO;

public class AccountDAO {

	SqlSession con;

	public AccountDAO(SqlSession sqlsession){
		this.con = sqlsession;
	}

	// 로그인
	public boolean login(LoginVO loginVO){
		return con.selectOne("accountMapper.Login",loginVO) != null ? true : false;
	}

	// 마이페이지
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
	
	// 마이페이지  수정
	public int setMypage(MypageVO mypageVO){
		return con.update("accountMapper.setMypage", mypageVO);
	}
	
	// 회원가입
	public int join(JoinVO joinVO){
		return con.insert("accountMapper.Join", joinVO);
	}
	
	// 회원탈퇴
	public int removeUser(UserInfoVO userInfoVO){
		return con.delete("accountMapper.removeUser", userInfoVO);
	}
	
	// 아이디 찾기
	public String getUserId(UserIdFindVO useridFindVO){
		return con.selectOne("accountMapper.getUserId", useridFindVO);
	}
	
	// 비밀번호 찾기
	public String getUserPw(UserPwFindVO userPwFindVO){
		return con.selectOne("accountMapper.getUserPw", userPwFindVO);
	}
	
	// 개인정보 수정
	public int setUserInfo(UserInfoVO userInfoVO){
		return con.update("accountMapper.setUserInfo", userInfoVO);
	}
	
	// 아이디 중복 체크
	public int isUserIdExist(JoinVO joinVO){
		return con.selectOne("accountMapper.isUserIdExist", joinVO);
	}
	// 이메일 중복 체크
	public int isEmailExist(JoinVO joinVO){
		return con.selectOne("accountMapper.isEmailExist", joinVO);
	}
	// 닉네임 중복 체크
	public int isNickNameExist(JoinVO joinVO){
		return con.selectOne("accountMapper.isNickNameExist", joinVO);
	}
	


}
