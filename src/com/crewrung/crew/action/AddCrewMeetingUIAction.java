package com.crewrung.crew.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.crewrung.servlet.Action;

public class AddCrewMeetingUIAction implements Action {

    public AddCrewMeetingUIAction() {} // 기본 생성자

    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        // ✅ 크루 모임(정기모임) 생성 폼으로 이동
        return "crew/crewMeetingAddPage.html"; 
    }
}
