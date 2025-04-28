package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class ApplyCrewUIAction implements Action {

    public ApplyCrewUIAction() {} // 기본 생성자

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // ✅ 크루 가입 신청 폼으로 이동
        return "crew/crewApplyPage.html"; 
    }
}
