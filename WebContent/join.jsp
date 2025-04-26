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
	<!-- 헤더 -->
	<header>
		<div class="logo">
			<img src="/placeholder.svg" alt="크루룽 로고"> <span
				class="logo-text">크루룽</span>
		</div>

		<nav>
			<ul>
				<li><a href="#">번개 모임</a></li>
				<li><a href="#">크루</a></li>
				<li><a href="#">자유게시판</a></li>
			</ul>
		</nav>

		<div class="user-actions">
			<div class="user-icon">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					viewBox="0 0 24 24" fill="none" stroke="currentColor"
					stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
					<path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
					<circle cx="12" cy="7" r="4"></circle>
				</svg>
			</div>
			<button class="login-btn">로그인</button>
		</div>

		<!-- 헤더 아래 구분선 추가 -->
		<div class="header-divider"></div>
	</header>

	<!-- 메인 콘텐츠 영역 -->
	<main>
	<form class="signup-form" action="controller?cmd=join" method="post">
		<h2>회원가입</h2>
		<label for="userid">아이디</label> <input type="text" id="userid"
			name="userid" required minlength="4" maxlength="16"
			placeholder="아이디 입력"> <label for="userPw">비밀번호</label> <input
			type="password" id="userPw" name="userPw" required minlength="6"
			placeholder="비밀번호 입력"> <label for="userPwCheck">비밀번호
			확인</label> <input type="password" id="userPwCheck" name="userPwCheck"
			required minlength="6" placeholder="비밀번호 재입력"> <label
			for="name">이름</label> <input type="text" id="name" name="name"
			required placeholder="이름 입력"> <label for="email">이메일</label>
		<input type="email" id="email" name="email" required
			placeholder="example@email.com"> <label for="phoneNumber">전화번호</label>
		<input type="text" id="phoneNumber" name="phoneNumber" required
			placeholder="010-xxx-xxxx"> <label for="nickname">닉네임</label>
		<input type="text" id="nickname" name="nickname" required
			maxlength="12" placeholder="닉네임 입력"> <label for="gender">성별</label>
		<select id="gender" name="gender" required>
			<option value="">선택하세요</option>
			<option value="male">남성</option>
			<option value="female">여성</option>
			<option value="other">기타</option>
		</select> <label for="guName">지역</label> <select id="guName" name="guName"
			required>
			<option value="">선택하세요</option>
			<option value="jongno">종로구</option>
			<option value="junggu">중구</option>
			<option value="yongsan">용산구</option>
			<option value="seongdong">성동구</option>
			<option value="gwangjin">광진구</option>
			<option value="dongdaemun">동대문구</option>
			<option value="jungnang">중랑구</option>
			<option value="seongbuk">성북구</option>
			<option value="gangbuk">강북구</option>
			<option value="dobong">도봉구</option>
			<option value="nowon">노원구</option>
			<option value="eunpyeong">은평구</option>
			<option value="seodaemun">서대문구</option>
			<option value="mapo">마포구</option>
			<option value="yangcheon">양천구</option>
			<option value="gangseo">강서구</option>
			<option value="guro">구로구</option>
			<option value="geumcheon">금천구</option>
			<option value="yeongdeungpo">영등포구</option>
			<option value="dongjak">동작구</option>
			<option value="gwanak">관악구</option>
			<option value="seocho">서초구</option>
			<option value="gangnam">강남구</option>
			<option value="songpa">송파구</option>
			<option value="gangdong">강동구</option>
		</select>

		<div>
			<label for="question">질문</label> <select id="question"
				name="question" required>
				<option>선택하세요</option>
				<option>기억에 남는 추억의 장소는?</option>
				<option>졸업한 초등학교는?</option>
			</select> <input type="text" id="answer" name="answer" required minlength="6"
				placeholder="질문에 대한 답 입력">
		</div>

		<label for="birthDate">생년월일</label> <input type="date" id="birthDate"
			name="birthDate" required>

		<button type="submit">가입하기</button>
	</form>
	</main>

	<!-- 푸터 - 두 열 레이아웃 -->
	<footer>
		<div class="footer-content">
			<!-- 왼쪽 열 - 회사 정보 -->
			<div class="footer-left">
				<div>Corporate Name: 주식회사 크루 Owner: 김훈희 Business License:
					234-18-4251</div>
				<div>E-commerce Registration: 2022-서울강남-02241 Phone: 1533
					KR(Kakao only) Contact Mail: Biz.at@gmail.com</div>
				<div>Address: 서울특별시 강남구 테헤란로 51길(역삼동) AB Personal Information
					Manager: 김도기 (info@gmail.com)</div>
				<div class="footer-copyright">© LIGHTNING CO., LTD. ALL RIGHTS
					RESERVED.</div>
			</div>

			<!-- 오른쪽 열 - CS Center 정보 -->
			<div class="footer-right">
				<div>CS Center: 1588-4321</div>
				<div>10:00AM - 7:00PM (Lunch 12:30 - 13:30)</div>
				<div>Sat/Sun/Holiday CLOSED</div>
			</div>
		</div>
	</footer>
</body>
</html>
