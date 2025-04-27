package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardVO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;

public class UpdateBoardService {
    private final BoardDAO boardDAO;

    public UpdateBoardService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public void execute(int boardNumber, String writerId, String title, String content) {
        BoardVO vo = new BoardVO(boardNumber, writerId, title, content);
        int result = boardDAO.updateBoard(vo);
        if (result < 1) {
            throw new RuntimeException("게시글 수정에 실패했습니다.");
        }
    }
}