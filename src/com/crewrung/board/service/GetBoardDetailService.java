package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardDetailVO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;

public class GetBoardDetailService {
    private final BoardDAO boardDAO;

    public GetBoardDetailService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public BoardDetailVO execute(long boardNumber) {
        BoardDetailVO detail = boardDAO.getBoardDetail(boardNumber);
        if (detail == null) {
            throw new RuntimeException("해당 게시글을 찾을 수 없습니다.");
        }
        return detail;
    }
}