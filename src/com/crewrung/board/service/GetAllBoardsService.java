package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardVO;
import com.crewrung.db.DBCP;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class GetAllBoardsService {
    private final BoardDAO boardDAO;

    public GetAllBoardsService() {
        SqlSessionFactory factory = DBCP.getSqlSessionFactory();
        this.boardDAO = new BoardDAO(factory);
    }

    public List<BoardVO> execute() {
        return boardDAO.getAllBoards();
    }
}