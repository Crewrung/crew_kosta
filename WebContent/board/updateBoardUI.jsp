<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>게시글 수정</title>
  <style>
    .form-container {
      max-width: 600px;
      margin: 40px auto;
      background: #fff;
      padding: 24px;
      border: 1px solid #ddd;
      border-radius: 6px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.05);
    }
    .form-container h2 {
      margin-bottom: 16px;
    }
    .form-group {
      margin-bottom: 12px;
    }
    .form-group label {
      display: block;
      margin-bottom: 4px;
      font-weight: bold;
    }
    .form-group input[type="text"],
    .form-group textarea {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 14px;
    }
    .form-group input[disabled] {
      background: #f5f5f5;
      color: #555;
    }
    .btn-submit {
      margin-top: 16px;
      padding: 8px 18px;
      background: #3498db;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 14px;
    }
    .btn-submit:hover {
      background: #2980b9;
    }
    .btn-cancel {
      margin-left: 12px;
      color: #3498db;
      text-decoration: none;
      font-size: 14px;
    }
    .btn-cancel:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<div class="form-container">
  <h2>게시글 수정</h2>

  <form action="${pageContext.request.contextPath}/controller" method="post">
    <!-- 필수 hidden 필드 -->
    <input type="hidden" name="cmd" value="updateBoard"/>
    <input type="hidden" name="boardNumber" value="${board.boardNumber}"/>
    <input type="hidden" name="writerId" value="${board.writerId}"/>

    <!-- 화면에 표시만 하는 비활성화 필드 -->
    <div class="form-group">
      <label for="boardNumber">글번호</label>
      <input type="text" id="boardNumber" 
             value="${board.boardNumber}" disabled/>
    </div>
    <div class="form-group">
      <label for="writerId">작성자</label>
      <input type="text" id="writerId" 
             value="${board.writerId}" disabled/>
    </div>

    <!-- 수정 가능한 필드 -->
    <div class="form-group">
      <label for="title">제목</label>
      <input type="text" id="title" name="title" 
             value="${board.title}" required/>
    </div>
    <div class="form-group">
      <label for="content">내용</label>
      <textarea id="content" name="content" rows="8" required>${board.content}</textarea>
    </div>

    <!-- 제출 버튼 -->
    <button type="submit" class="btn-submit">저장하기</button>
    <a href="${pageContext.request.contextPath}/controller?cmd=detailBoardUI&amp;boardNumber=${board.boardNumber}" 
       class="btn-cancel">취소</a>
  </form>
</div>

</body>
</html>