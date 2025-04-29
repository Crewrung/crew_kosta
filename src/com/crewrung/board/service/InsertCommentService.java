package com.crewrung.board.service;

import com.crewrung.board.dao.BoardDAO;
import com.crewrung.board.vo.BoardCommentVO;
import com.crewrung.db.DBCP;

/**
 * 게시판 댓글 삽입을 담당하는 서비스 클래스.
 */
public class InsertCommentService {
    private final BoardDAO boardDAO;

    public InsertCommentService() {
        // SqlSessionFactory를 DBCP에서 가져와 DAO 인스턴스 생성
        this.boardDAO = new BoardDAO(DBCP.getSqlSessionFactory());
    }

    /**
     * 댓글을 삽입합니다.
     *
     * @param boardNumber   댓글을 달 게시물 번호
     * @param commenterId   댓글 작성자 아이디 (null 또는 빈 문자열일 수 없음)
     * @param comment       댓글 내용 (null 또는 빈 문자열일 수 없음)
     *
     * @throws IllegalArgumentException 잘못된 파라미터 전달 시
     * @throws RuntimeException         삽입 결과가 기대값과 다를 때
     */
    public void execute(long boardNumber, String commenterId, String comment) {
        // 파라미터 검증
        if (commenterId == null || commenterId.trim().isEmpty()) {
            throw new IllegalArgumentException("commenterId는 필수 입력값입니다.");
        }
        if (comment == null || comment.trim().isEmpty()) {
            throw new IllegalArgumentException("comment는 필수 입력값입니다.");
        }

        // VO 생성 (long → int 캐스팅)
        BoardCommentVO vo = new BoardCommentVO((int) boardNumber, commenterId, comment);

        // DAO를 통해 삽입 수행
        int inserted = boardDAO.insertComment(vo);
        if (inserted != 1) {
            throw new RuntimeException("댓글 삽입에 실패했습니다. boardNumber=" + boardNumber);
        }
    }
}
