package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardDetailVO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.Date;

public class InsertBoardService {
    private final BoardDAO boardDAO;

    public InsertBoardService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public void execute(String writerId, String title, String content) {
        BoardDetailVO vo = new BoardDetailVO(writerId, title, content, new Date(), 0);
        int result = boardDAO.insertBoard(vo);
        if (result < 1) {
            throw new RuntimeException("게시글 등록에 실패했습니다.");
        }
    }
}