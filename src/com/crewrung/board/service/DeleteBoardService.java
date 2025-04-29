package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardVO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;

public class DeleteBoardService {
    private final BoardDAO boardDAO;

    public DeleteBoardService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public void execute(int boardNumber, String writerId) {
    	BoardVO vo = new BoardVO(boardNumber, writerId);
        vo.setBoardNumber(boardNumber);
        vo.setWriterId(writerId);

        int result = boardDAO.deleteBoard(vo);
        if (result < 1) {
            throw new RuntimeException("게시글 삭제에 실패했습니다.");
        }
    }
}