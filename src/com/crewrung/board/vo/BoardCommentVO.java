package com.crewrung.board.vo;

import java.sql.Date;

public class BoardCommentVO {
    private int boardCommentNumber;
    private int boardNumber;
    private String boardCommenterId;
    private String boardComment;
    private Date commentDate;

    // insert 용
    public BoardCommentVO(int boardNumber, String boardCommenterId, String boardComment) {
        this.boardNumber = boardNumber;
        this.boardCommenterId = boardCommenterId;
        this.boardComment = boardComment;
    }

    // delete 용 (comment 번호, 사용자)
    public BoardCommentVO(long boardCommentNumber, String boardCommenterId) {
        this.boardCommentNumber = (int)boardCommentNumber;
        this.boardCommenterId = boardCommenterId;
    }

    public BoardCommentVO() {}

    public int getBoardCommentNumber() { return boardCommentNumber; }
    public void setBoardCommentNumber(int boardCommentNumber) { this.boardCommentNumber = boardCommentNumber; }

    public int getBoardNumber() { return boardNumber; }
    public void setBoardNumber(int boardNumber) { this.boardNumber = boardNumber; }

    public String getBoardCommenterId() { return boardCommenterId; }
    public void setBoardCommenterId(String boardCommenterId) { this.boardCommenterId = boardCommenterId; }

    public String getBoardComment() { return boardComment; }
    public void setBoardComment(String boardComment) { this.boardComment = boardComment; }

    public Date getCommentDate() { return commentDate; }
    public void setCommentDate(Date commentDate) { this.commentDate = commentDate; }



	@Override
	public String toString() {
		return "BoardCommentVO [boardCommentNumber=" + boardCommentNumber + ", boardNumber=" + boardNumber
				+ ", boardCommenterId=" + boardCommenterId + ", boardComment=" + boardComment + ", commentDate="
				+ commentDate + "]";
	}
	
	
	
	
	
}
