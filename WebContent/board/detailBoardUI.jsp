<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">

	
  <title>게시글 상세</title>
  <style>
    body {
      font-family: "Noto Sans KR", sans-serif;
      background: #f5f5f5;
      margin: 0px;
    }
    
    /* 전체 콘텐츠 영역에 여백 추가 */
    main {
      padding: 0 40px; /* 좌우 여백 40px 추가 */
      max-width: 1200px; /* 최대 너비 설정 */
      margin: 0 auto; /* 가운데 정렬 */
    }
    
    .page-title {
      text-align: center;
      font-size: 24px;
      margin: 30px 0 20px; /* 상단 여백 증가 */
      font-weight: bold;
    }
    
    .detail-container {
      max-width: 800px;
      margin: 0 auto;
      background: #fff;
      border: 2px solid #ccc;
      border-radius: 6px;
      padding: 30px; /* 내부 패딩 증가 */
      position: relative;
      box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }
    
    .meta {
      display: flex;
      justify-content: space-between;
      margin-bottom: 30px; /* 여백 증가 */
    }
    
    .meta .meta-item {
      flex: 1;
      text-align: center;
      font-size: 14px;
      color: #555;
    }
    
    .content {
      font-size: 16px;
      line-height: 1.7;
      margin-bottom: 80px; /* 여백 증가 */
      padding: 0 10px; /* 내용 좌우 여백 추가 */
    }
    
    .back-link {
      position: absolute;
      bottom: 20px; /* 위치 조정 */
      left: 30px; /* 위치 조정 */
      font-size: 14px;
      color: #3498db;
      text-decoration: none;
    }
    
    .back-link:hover {
      text-decoration: underline;
    }
    
    .actions {
      position: absolute;
      bottom: 20px; /* 위치 조정 */
      right: 30px; /* 위치 조정 */
    }
    
    .actions a {
      margin-left: 8px;
      padding: 6px 12px;
      background: #2ecc71;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      font-size: 14px;
    }
    
    .actions a.btn-delete {
      background: #e74c3c;
    }
    
    .actions a:hover {
      opacity: 0.9;
    }
    
    .comment-section {
      max-width: 800px;
      margin: 50px auto 40px; /* 상하 여백 증가 */
      text-align: center;
      padding: 0 10px; /* 좌우 여백 추가 */
    }
    
    .comment-form {
      margin-bottom: 30px; /* 여백 증가 */
      text-align: left;
    }
    
    .comment-form textarea {
      width: 100%;
      height: 80px;
      padding: 12px; /* 패딩 증가 */
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 14px;
      resize: vertical;
    }
    
    .comment-form button {
      margin-top: 12px; /* 여백 증가 */
      padding: 8px 16px; /* 패딩 증가 */
      background: #333;
      color: #fff;
      border: none;
      border-radius: 4px;
      font-size: 14px;
      cursor: pointer;
    }
    
    .comments-list .comment-item {
      padding: 15px 10px; /* 패딩 증가 */
      border-bottom: 1px solid #eee;
      text-align: left;
    }
    
    .comment-header {
      font-size: 13px;
      color: #666;
      margin-bottom: 8px; /* 여백 증가 */
    }
    
    .comment-body {
      font-size: 15px;
      line-height: 1.6;
      padding: 0 5px; /* 내용 좌우 여백 추가 */
    }
    
    .pagination {
      margin-top: 30px; /* 여백 증가 */
      text-align: center;
    }
    
    .pagination a, .pagination span {
      margin: 0 5px; /* 여백 증가 */
      padding: 8px 12px; /* 패딩 증가 */
      font-size: 14px;
      color: #3498db;
      text-decoration: none;
    }
    
    .pagination a:hover {
      text-decoration: underline;
    }
    
    .pagination .current {
      font-weight: bold;
      color: #000;
    }
  </style>
</head>

<body>
  <!-- 헤더 -->
	<%@ include file="../header.jsp"%>
	
  <!-- 제목 -->
  <div class="page-title">${board.title}</div>
<main>


  <!-- 상세 컨테이너 -->
  <div class="detail-container">

    <!-- 메타 정보 -->
    <div class="meta">
      <div class="meta-item">
        작성자<br/><strong>${board.writerId}</strong>
      </div>
      <div class="meta-item">
        작성일<br/>
        <strong>
          <fmt:formatDate value="${board.writingDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
        </strong>
      </div>
      <div class="meta-item">
        조회수<br/><strong>${board.viewCount}</strong>
      </div>
    </div>

    <!-- 본문 -->
    <div class="content">
      ${board.content}
    </div>

    <!-- 뒤로가기 -->
    <a href="<c:url value='/controller'><c:param name='cmd' value='boardsUI'/></c:url>" class="back-link">뒤로가기</a>

	
	<div class="actions">
	    <c:if test="${sessionScope.userId == board.writerId}">
	      <!-- 수정 링크 (녹색 배경) -->
	      <c:url var="editURL" value="/controller">
	        <c:param name="cmd"         value="updateBoardUI"/>
	        <c:param name="boardNumber" value="${board.boardNumber}"/>
	      </c:url>
	      <a href="${editURL}">
	      수정
	      </a>
	
	      <!-- 삭제 링크 (빨간 배경) -->
	      <c:url var="deleteURL" value="/controller">
	        <c:param name="cmd"         value="deleteBoard"/>
	        <c:param name="boardNumber" value="${board.boardNumber}"/>
	        <c:param name="writerId"    value="${sessionScope.userId}"/>
	      </c:url>
	      <a href="${deleteURL}" class="btn-delete"
	         onclick="return confirm('정말 삭제하시겠습니까?');">
	        삭제
	      </a>
	    </c:if>
	  </div>
</div>
  <!-- 댓글 섹션 -->
  <div class="comment-section">

	<form action="<c:url value='/controller'/>" method="post" class="comment-form">
	  <input type="hidden" name="cmd"              value="insertComment"/>
	  <input type="hidden" name="boardNumber"      value="${board.boardNumber}"/>
	  <input type="hidden" name="boardCommenterId" value="${sessionScope.userId}"/>
	  <textarea name="boardComment"
	            maxlength="100"
	            placeholder="댓글을 입력하세요 (최대 100자)"></textarea><br/>
	  <button type="submit">댓글 작성</button>
	</form>


    <!-- 댓글 목록 -->
    <div class="comments-list">
      <c:forEach var="c" items="${commentsList}">
        <div class="comment-item">
          <div class="comment-header">
            ${c.commenter} &nbsp;|&nbsp;
            <fmt:formatDate value="${c.commentDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
          </div>
          <div class="comment-body">${c.comment}</div>
        </div>
      </c:forEach>
    </div>

    <!-- 페이지 네비게이션 -->
    <div class="pagination">
      <c:if test="${currentPage > 1}">
        <c:url var="prevUrl" value="/controller">
          <c:param name="cmd"         value="detailBoardUI"/>
          <c:param name="boardNumber" value="${board.boardNumber}"/>
          <c:param name="page"        value="${currentPage - 1}"/>
        </c:url>
        <a href="${pageContext.request.contextPath}${prevUrl}">◀ 이전</a>
      </c:if>

      <c:forEach var="i" begin="1" end="${totalPages}">
        <c:choose>
          <c:when test="${i == currentPage}">
            <span class="current">${i}</span>
          </c:when>
          <c:otherwise>
            <c:url var="pageUrl" value="/controller">
              <c:param name="cmd"         value="detailBoardUI"/>
              <c:param name="boardNumber" value="${board.boardNumber}"/>
              <c:param name="page"        value="${i}"/>
            </c:url>
            <a href="${pageContext.request.contextPath}${pageUrl}">${i}</a>
          </c:otherwise>
        </c:choose>
      </c:forEach>

      <c:if test="${currentPage < totalPages}">
        <c:url var="nextUrl" value="/controller">
          <c:param name="cmd"         value="detailBoardUI"/>
          <c:param name="boardNumber" value="${board.boardNumber}"/>
          <c:param name="page"        value="${currentPage + 1}"/>
        </c:url>
        <a href="${pageContext.request.contextPath}${nextUrl}">다음 ▶</a>
      </c:if>
    </div>

  </div>
</main>

	<!-- 푸터 - 두 열 레이아웃 -->
	<%@ include file="../footer.jsp"%>
</body>


</html>
