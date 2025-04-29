<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<!-- 헤더 -->
	<%@ include file="../header.jsp"%>
	
  <meta charset="UTF-8">
  <title>자유게시판</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 40px;
      background-color: #f9f9f9;
    }
    h1 {
      font-size: 28px;
      color: #333;
      margin-bottom: 10px;
      position: relative;
    }
    /* 글쓰기 버튼 */
    .button-write {
      position: absolute;
      right: 0;
      top: 0;
      padding: 8px 14px;
      background-color: #3498db;
      color: #fff;
      text-decoration: none;
      border-radius: 4px;
      font-size: 14px;
    }
    .button-write:hover {
      background-color: #2980b9;
    }
    /* 게시판 테이블 */
    table.board-table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
      background-color: #fff;
      box-shadow: 0 2px 4px rgba(0,0,0,0.05);
    }
    table.board-table th,
    table.board-table td {
      padding: 12px 10px;
      text-align: left;
      border-bottom: 1px solid #ececec;
    }
    table.board-table th {
      background-color: #2c3e50;
      color: #fff;
      font-weight: normal;
    }
    table.board-table tr:hover td {
      background-color: #f2f2f2;
    }
    /* 페이징 */
    .pagination {
      text-align: center;
      margin: 20px 0;
    }
    .pagination a,
    .pagination span {
      display: inline-block;
      margin: 0 6px;
      padding: 6px 10px;
      text-decoration: none;
      color: #3498db;
      font-size: 14px;
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

  <h1>
    자유게시판
    <a href="controller?cmd=postingUI" class="button-write">글쓰기</a>
  </h1>

  <table class="board-table">
    <thead>
      <tr>
        <th style="width: 80px;">번호</th>
        <th>제목</th>
        <th style="width: 140px;">작성일</th>
        <th style="width: 120px;">작성자</th>
        <th style="width: 100px;">조회수</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="b" items="${boards}">
        <tr>
          <td>${b.boardNumber}</td>
          <td>
            <a href="controller?cmd=detailBoardUI&amp;boardNumber=${b.boardNumber}">
              ${b.title}
            </a>
          </td>
          <td>
            <fmt:formatDate value="${b.writingDate}" pattern="yyyy-MM-dd"/>
          </td>
          <td>${b.writerId}</td>
          <td>${b.viewCount}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <div class="pagination">
    <!-- 이전 -->
    <c:if test="${currentPage > 1}">
      <a href="controller?cmd=boardsUI&amp;page=${currentPage - 1}">◀</a>
    </c:if>

    <!-- 페이지 번호 -->
    <c:forEach var="i" begin="1" end="${totalPages}">
      <c:choose>
        <c:when test="${i == currentPage}">
          <span class="current">${i}</span>
        </c:when>
        <c:otherwise>
          <a href="controller?cmd=boardsUI&amp;page=${i}">${i}</a>
        </c:otherwise>
      </c:choose>
    </c:forEach>

    <!-- 다음 -->
    <c:if test="${currentPage < totalPages}">
      <a href="controller?cmd=boardsUI&amp;page=${currentPage + 1}">▶</a>
    </c:if>
  </div>

</body>

	<!-- 푸터 - 두 열 레이아웃 -->
	<%@ include file="../footer.jsp"%>
</html>