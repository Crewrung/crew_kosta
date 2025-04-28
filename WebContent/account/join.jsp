<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루룽</title>
<style>
/* 기본 리셋 */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
	background-color: #f9f9f9;
}

/* 헤더 스타일 */
header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 15px 20px;
	background-color: #fff;
	position: relative; /* 구분선 위치 설정을 위해 추가 */
}

/* 헤더 아래 구분선 추가 */
.header-divider {
	height: 1px;
	background-color: #ddd; /* 연한 회색 */
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

/* 네비게이션 간격 더 넓히기 */
nav ul {
	display: flex;
	list-style: none;
	gap: 200px; /* 간격 더 증가 */
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
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 20px;
	padding: 8px 16px;
	cursor: pointer;
}

/* 메인 콘텐츠 영역 - 양 옆 간격 설정 */
main {
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
}

/* 메인 콘텐츠 내부 빈 컨테이너 스타일 */
.content-container {
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	padding: 20px;
	min-height: 400px;
	margin-bottom: 20px;
}

/* 푸터 스타일 - 두 열 레이아웃 */
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

.footer-left {
	text-align: left;
}

.footer-right {
	text-align: left;
	border-left: 1px solid #ddd;
	padding-left: 20px;
}

.footer-copyright {
	margin-top: 5px;
}

/* 회원가입 폼 스타일 */
.signup-form {
	width: 350px;
	margin: 40px auto;
	padding: 30px;
	background: #ffffff;
	border-radius: 8px;
	box-shadow: 0 2px 8px #ccc;
}

.signup-form h2 {
	text-align: center;
	margin-bottom: 20px;
}

.signup-form label {
	display: block;
	margin-top: 15px;
}

.signup-form input, .signup-form select {
	width: 100%;
	padding: 8px;
	margin-top: 5px;
	box-sizing: border-box;
}

.signup-form button {
	width: 100%;
	padding: 10px;
	margin-top: 20px;
	background: #007bff;
	color: #fff;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	cursor: pointer;
}

.signup-form button:hover {
	background: #0056b3;
}
</style>
</head>
<body>
	<%@ include file="/header.jsp" %>
	<!-- 메인 콘텐츠 영역 -->
	<main>
	 <c:if test="${not empty errorMsg}">
        <div class="error">${errorMsg}</div>
    </c:if>
	<form class="signup-form" action="/crew_kosta/controller?cmd=joinAction" method="post">
		<h2>회원가입</h2>
		<label for="userId">아이디</label> 
		<input type="text" id="userId" name="userId" required minlength="4" maxlength="16" placeholder="아이디 입력"> 
		
		<label for="userPw">비밀번호</label> 
		<input type="password" id="userPw" name="userPw" required minlength="6" placeholder="비밀번호 입력"> 
		
		<label for="userPwCheck">비밀번호확인</label> 
		<input type="password" id="userPwCheck" name="userPwCheck" required minlength="6" placeholder="비밀번호 재입력">
		
		<label for="name">이름</label> 
		<input type="text" id="name" name="name" required placeholder="이름 입력"> 
		
		<label for="email">이메일</label>
		<input type="email" id="email" name="email" required placeholder="example@email.com"> 
		
		<label for="phoneNumber">전화번호</label>
		<input type="text" id="phoneNumber" name="phoneNumber" required placeholder="010-xxx-xxxx"> 
		
		<label for="nickname">닉네임</label>
		<input type="text" id="nickname" name="nickname" required maxlength="12" placeholder="닉네임 입력"> 
			
		<label for="gender">성별</label>
		<select id="gender" name="gender" required>
			<option value="">선택하세요</option>
			<option value="남성">남성</option>
			<option value="여성">여성</option>
			<option value="기타">기타</option>
			
			
		</select> <label for="guName">지역</label> <select id="guName" name="guName"
			required>
			<option value="">선택하세요</option>
			<option value="종로구">종로구</option>
			<option value="중구">중구</option>
			<option value="용산구">용산구</option>
			<option value="성동구">성동구</option>
			<option value="광진구">광진구</option>
			<option value="동대문구">동대문구</option>
			<option value="중랑구">중랑구</option>
			<option value="성북구">성북구</option>
			<option value="강북구">강북구</option>
			<option value="도봉구">도봉구</option>
			<option value="노원구">노원구</option>
			<option value="은평구">은평구</option>
			<option value="서대문구">서대문구</option>
			<option value="마포구">마포구</option>
			<option value="양천구">양천구</option>
			<option value="강서구">강서구</option>
			<option value="구로구">구로구</option>
			<option value="금천구">금천구</option>
			<option value="영등포구">영등포구</option>
			<option value="동작구">동작구</option>
			<option value="관악구">관악구</option>
			<option value="서초구">서초구</option>
			<option value="강남구">강남구</option>
			<option value="송파구">송파구</option>
			<option value="강동구">강동구</option>
		</select>

		<div>
			<label for="question">질문</label> <select id="question" name="question" required>
				<option>선택하세요</option>
				<option>기억에 남는 추억의 장소는?</option>
				<option>졸업한 초등학교는?</option>
			</select>
			 <input type="text" id="answer" name="answer" required minlength="1" placeholder="질문에 대한 답 입력">
		</div>

		<label for="birthDate">생년월일</label> 
		<input type="date" id="birthDate" name="birthDate" required>

		<button type="submit">가입하기</button>
	</form>
	</main>


<%@ include file="/footer.jsp" %>
</body>
</html>
