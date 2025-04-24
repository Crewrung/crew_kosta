package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardCommentVO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;

public class DeleteCommentService {
    private final BoardDAO boardDAO;

    public DeleteCommentService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public void execute(long commentNumber, String commenterId) {
        BoardCommentVO vo = new BoardCommentVO(commentNumber, commenterId);
        int result = boardDAO.deleteComment(vo);
        if (result < 1) {
            throw new RuntimeException("댓글 삭제에 실패했습니다.");
        }
    }
}