package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;

public class IncrementViewService {
    private final BoardDAO boardDAO;

    public IncrementViewService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public void execute(int boardNumber) {
        int result = boardDAO.incrementView(boardNumber);
        if (result < 1) {
            throw new RuntimeException("조회수 증가에 실패했습니다.");
        }
    }
}