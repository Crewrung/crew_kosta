<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>크루룽 로그인</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
        rel="stylesheet" crossorigin="anonymous">
  <!-- Bootstrap Icons -->
  <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  <link rel="stylesheet" as="style" crossorigin
        href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css" />
  <style>
    * { margin: 0; padding: 0; box-sizing: border-box; }

    body {
      font-family: "Pretendard Variable", Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
      background-color: #f9f9f9;
      display: flex;
      flex-direction: column;
      min-height: 100vh;
    }

    main {
      flex: 1;
      max-width: 1200px;
      margin: 0 auto;
      padding: 20px;
    }

    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 15px 20px;
      background-color: #fff;
      position: relative;
    }

    .header-divider {
      height: 1px;
      background-color: #ddd;
      width: 100%;
      position: absolute;
      bottom: 0;
      left: 0;
    }

    .logo {
      display: flex;
      align-items: center;
    }

    .logo img {
      width: 24px;
      height: 24px;
      margin-right: 8px;
    }

    .logo-text {
      font-weight: bold;
      font-size: 18px;
      color: #000;
    }

    nav ul {
      display: flex;
      list-style: none;
      gap: 200px;
      margin-bottom: 0;
    }

    nav ul li a {
      text-decoration: none;
      color: #333;
    }

    .user-actions {
      display: flex;
      align-items: center;
    }

    .user-icon {
      width: 32px;
      height: 32px;
      border-radius: 50%;
      background-color: #f5f5f5;
      display: flex;
      align-items: center;
      justify-content: center;
      margin-right: 10px;
    }

    .login-btn {
      background-color: #ffffff;
      border: 1px solid #ddd;
      border-radius: 20px;
      padding: 8px 16px;
      cursor: pointer;
    }

    .login-form {
      background-color: #fff;
      padding: 100px;
      border-radius: 20px;
      box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      margin-top: 100px;
      margin-bottom: 100px;
    }

    .login-form h3 {
      margin-bottom: 1.8rem;
    }

    footer {
      background-color: #f5f5f5;
      padding: 15px 20px;
      font-size: 12px;
      color: #666;
      line-height: 1.6;
      border-top: 1px solid #ddd;
    }

    .footer-content {
      max-width: 1200px;
      margin: 0 auto;
      display: flex;
      justify-content: space-between;
    }

    .footer-left, .footer-right {
      display: flex;
      flex-direction: column;
      gap: 5px;
    }

    .footer-left { text-align: left; }

    .footer-right {
      border-left: 1px solid #ddd;
      padding-left: 20px;
    }

    .footer-copyright { margin-top: 5px; }

    .btn-custom {
      background-color: #fff;
      border: 1px solid #ddd;
      border-radius: 20px;
      padding: 10px 20px;
      cursor: pointer;
      font-size: 14px;
      transition: background-color 0.3s ease, color 0.3s ease, border 0.3s ease;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .btn-custom:hover {
      background-color: #FFA500;
      color: white;
      border-color: #FFA500;
      box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
    }

    .btn-custom:focus, .btn-custom:active {
      outline: none;
      box-shadow: 0 0 0 2px rgba(255, 165, 0, 0.6);
      border-color: #FFA500;
    }

    a { text-decoration: none; color: inherit; }
  </style>
</head>
<body>

<%@ include file="/header.jsp" %>

<!-- 메인 로그인 폼 -->
<main>
  <div class="login-form text-center">
    <h3>로그인</h3>
    <form method="post" action="/kosta/controller?cmd=loginAction">
      <div class="mb-3">
        <input type="text" class="form-control" name="userId" placeholder="아이디" required />
      </div>
      <div class="mb-2">
        <input type="password" class="form-control" name="userPw" placeholder="비밀번호" required />
      </div>
      <div class="text-end text-muted mb-3" style="font-size: 0.85rem;">
        <a href="/kosta/controller?cmd=findUserIdUIAction" class="text-decoration-none text-muted me-2">아이디 찾기</a> |
        <a href="/kosta/controller?cmd=findUserPwUIAction" class="text-decoration-none text-muted ms-2">비밀번호 찾기</a>
      </div>
      <div class="d-grid gap-2">
        <button type="submit" class="btn-custom">로그인</button>
        <a href="/kosta/controller?cmd=joinUIAction"><button type="button" class="btn-custom">회원가입</button></a>
      </div>
    </form>

    <!-- 로그인 실패 시 메시지 표시 -->
    <c:if test="${not empty errorMsg}">
      <div class="mt-3 text-danger">${errorMsg}</div>
    </c:if>
  </div>
</main>

<!-- 푸터 -->
<%@ include file="/footer.jsp" %>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
