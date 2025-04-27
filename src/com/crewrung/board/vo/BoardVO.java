package com.crewrung.board.vo;

import java.util.Date;

public class BoardVO {
    private int boardNumber;
    private String writerId;
    private String title;
    private String content;
    private Date writingDate;
    private int viewCount;

    // ����Ʈ, delete ��
    public BoardVO(int boardNumber, String writerId, String title) {
        this.boardNumber = boardNumber;
        this.writerId = writerId;
        this.title = title;
    }

    // update ��
    public BoardVO(int boardNumber, String writerId, String title, String content) {
        this.boardNumber = boardNumber;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
    }

    public BoardVO() {}

    // full ������
    public BoardVO(int boardNumber, String writerId, String title, String content, Date writingDate, Integer viewCount) {
        this.boardNumber = boardNumber;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.writingDate = writingDate;
        this.viewCount = viewCount;
    }

    // getters/setters
    public int getBoardNumber() { return boardNumber; }
    public void setBoardNumber(int boardNumber) { this.boardNumber = boardNumber; }

    public String getWriterId() { return writerId; }
    public void setWriterId(String writerId) { this.writerId = writerId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Date getWritingDate() { return writingDate; }
    public void setWritingDate(Date writingDate) { this.writingDate = writingDate; }

    public Integer getViewCount() { return viewCount; }
    public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }

	@Override
	public String toString() {
		return "BoardVO [boardNumber=" + boardNumber + ", writer_id=" + writerId + ", title=" + title + ", content="
				+ content + ", writingDate=" + writingDate + ", viewCount=" + viewCount + "]";
	}
  
}
