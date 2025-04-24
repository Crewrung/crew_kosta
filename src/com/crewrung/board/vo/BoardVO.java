package com.crewrung.board.vo;

import java.util.Date;

public class BoardVO {
    private Long boardNumber;
    private String writer_id;
    private String title;
    private String content;
    private Date writingDate;
    private Integer viewCount;

    // 리스트, delete 용
    public BoardVO(long boardNumber, String writerId, String title) {
        this.boardNumber = boardNumber;
        this.writer_id = writer_id;
        this.title = title;
    }

    // update 용
    public BoardVO(long boardNumber, String writerId, String title, String content) {
        this.boardNumber = boardNumber;
        this.writer_id = writer_id;
        this.title = title;
        this.content = content;
    }

    public BoardVO() {}

    // full 생성자
    public BoardVO(Long boardNumber, String writerId, String title, String content, Date writingDate, Integer viewCount) {
        this.boardNumber = boardNumber;
        this.writer_id = writer_id;
        this.title = title;
        this.content = content;
        this.writingDate = writingDate;
        this.viewCount = viewCount;
    }

    // getters/setters
    public Long getBoardNumber() { return boardNumber; }
    public void setBoardNumber(Long boardNumber) { this.boardNumber = boardNumber; }

    public String getWriterId() { return writer_id; }
    public void setWriterId(String writerId) { this.writer_id = writer_id; }

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
		return "BoardVO [boardNumber=" + boardNumber + ", writer_id=" + writer_id + ", title=" + title + ", content="
				+ content + ", writingDate=" + writingDate + ", viewCount=" + viewCount + "]";
	}
  
}
