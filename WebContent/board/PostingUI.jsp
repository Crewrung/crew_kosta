<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시글 등록</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

  <!-- 헤더 -->
	<%@ include file="../header.jsp"%>
<main>
  <div class="container py-5">
    <div class="card mx-auto" style="max-width:600px;">
      <div class="card-header text-center">
        <h4>게시글 등록</h4>
      </div>
      <div class="card-body">
        <form action="controller?cmd=uploadboard" method="post">
          <div class="mb-3">
            <label for="writerId" class="form-label">작성자 ID</label>
            <input type="text" class="form-control" id="writerId" name="writerId" required />
          </div>
          <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" name="title" required />
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <textarea class="form-control" id="content" name="content" rows="8" required></textarea>
          </div>
          <div class="d-flex justify-content-between">
            <a href="controller?cmd=boardsUI" class="btn btn-link">취소</a>
            <button type="submit" class="btn btn-dark">등록</button>
          </div>
        </form>
      </div>
    </div>
  </div>
  
  </main>

	<!-- 푸터 - 두 열 레이아웃 -->
	<%@ include file="../footer.jsp"%>
</body>
</html>
