package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardCommentListVO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class GetAllCommentsService {
    private final BoardDAO boardDAO;

    public GetAllCommentsService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public List<BoardCommentListVO> execute() {
        return boardDAO.getAllComments();
    }
}