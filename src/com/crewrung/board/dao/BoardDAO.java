package com.crewrung.board.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.crewrung.board.vo.*;
import com.crewrung.db.DBCP;

public class BoardDAO {
    private final SqlSessionFactory sqlSessionFactory;
    private final SqlSessionFactory factory = DBCP.getSqlSessionFactory();
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

    public List<BoardCommentListVO> getAllComments(int boardNumber) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
        return session.selectList("boardMapper.getAllComments", boardNumber);
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

    public BoardDetailVO getBoardDetail(int boardNumber) {
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
        if (factory == null) {
            throw new IllegalStateException("SqlSessionFactory가 초기화되지 않았습니다.");
        }
        try (SqlSession session = factory.openSession()) {
            // namespace.updateBoard는 boardMapper.xml의 <update id="updateBoard">를 가리킵니다.
            int updated = session.update("boardMapper.updateBoard", vo);
            session.commit();
            return updated;
        }
    }

        // 조회수 증가
        public int incrementView(int boardNumber) {
            try (SqlSession session = sqlSessionFactory.openSession()) {
                int result = session.update(
                    "boardMapper.incrementView",
                   boardNumber
                );
                session.commit();
                return result;
            }
        }
}
