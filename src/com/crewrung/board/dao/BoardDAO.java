package com.crewrung.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.crewrung.board.vo.*;

public class BoardDAO {
    private final SqlSessionFactory sqlSessionFactory;

    public BoardDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public int insertComment(BoardCommentVO comment) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.insert("boardMapper.insertBoardComment", comment);
            session.commit();
            return result;
        }
    }

    public int deleteComment(BoardCommentVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("boardMapper.deleteComment", vo);
            session.commit();
            return result;
        }
    }

    public List<BoardCommentListVO> getAllComments() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("boardMapper.getAllComments");
        }
    }

    public int insertBoard(BoardDetailVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.insert("boardMapper.insertBoard", vo);
            session.commit();
            return result;
        }
    }

    public int deleteBoard(BoardVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.delete("boardMapper.deleteBoard", vo);
            session.commit();
            return result;
        }
    }

    public BoardDetailVO getBoardDetail(Long boardNumber) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("boardMapper.getBoardDetail", boardNumber);
        }
    }

    public List<BoardVO> getAllBoards() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("boardMapper.getAllBoards");
        }
    }

    public int updateBoard(BoardVO vo) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int result = session.update("boardMapper.updateBoard", vo);
            session.commit();
            return result;
        }
    }

    // from BoardViewIncrementDAO 12

        public int incrementView() {
            try (SqlSession session = sqlSessionFactory.openSession()) {
                int result = session.update("boardMapper.incrementView");
                return result;
            }
        }

}
