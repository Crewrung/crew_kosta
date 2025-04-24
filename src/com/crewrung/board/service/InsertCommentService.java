package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardCommentVO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;

public class InsertCommentService {
    private final BoardDAO boardDAO;

    public InsertCommentService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public void execute(int boardNumber, String commenterId, String comment) {
        BoardCommentVO vo = new BoardCommentVO(boardNumber, commenterId, comment);
        int result = boardDAO.insertComment(vo);
        if (result < 1) {
            throw new RuntimeException("댓글 등록에 실패했습니다.");
        }
    }
}