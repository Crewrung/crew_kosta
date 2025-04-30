<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루룽 - 크루 생성하기</title>

<!-- CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css"
	rel="stylesheet" crossorigin="anonymous">

<style>
/* 스타일 전체 복붙 (당신이 준 것 반영) */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: "Pretendard Variable", Pretendard, sans-serif;
	background-color: #f9f9f9;
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
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 20px;
	padding: 8px 16px;
	cursor: pointer;
}

main {
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
}

.content-container {
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin-bottom: 20px;
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

.footer-right {
	border-left: 1px solid #ddd;
	padding-left: 20px;
}

.form-title {
	font-size: 1.5rem;
	font-weight: bold;
	margin-bottom: 5px;
}

.form-subtitle {
	color: #666;
	margin-bottom: 20px;
}

.form-group {
	margin-bottom: 20px;
}

.form-label {
	display: block;
	margin-bottom: 8px;
	font-weight: 500;
}

.form-control, .form-select {
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 14px;
}

textarea.form-control {
	min-height: 100px;
}

.form-actions {
	display: flex;
	justify-content: space-between;
	margin-top: 30px;
}

.btn {
	padding: 10px 20px;
	border-radius: 4px;
	font-size: 14px;
	cursor: pointer;
}

.btn-cancel {
	background-color: #f5f5f5;
	border: 1px solid #ddd;
	color: #333;
}

.btn-submit {
	background-color: #212529;
	border: none;
	color: white;
}

.crew-action-btn {
	background-color: #f8f9fa;
	border: 1px solid #ddd;
	border-radius: 4px;
	padding: 10px 20px;
	font-size: 14px;
	color: #333;
	cursor: pointer;
	margin-bottom: 15px;
	transition: all 0.2s ease;
}

.crew-action-btn:hover {
	background-color: #e9ecef;
}

.crew-action-btn.active {
	background-color: #e9ecef;
	border-color: #ced4da;
}

.promo-message-container {
	display: none;
	margin-bottom: 20px;
	transition: all 0.3s ease;
	overflow: hidden;
}

.promo-message-container.show {
	display: block;
	animation: slideDown 0.3s ease forwards;
}

@
keyframes slideDown {from { opacity:0;
	transform: translateY(-10px);
}

to {
	opacity: 1;
	transform: translateY(0);
}
}
</style>
</head>

<body>
	<!-- Header -->
	<header>
		<div class="logo">
			<img src="<%=request.getContextPath()%>/image/logo.png" alt="크루룽 로고">
			<span class="logo-text">크루룽</span>
		</div>
		<nav>
			<ul>
				<li><a
					href="<%=request.getContextPath()%>/controller?cmd=flashMobUI">번개
						모임</a></li>
				<li><a
					href="<%=request.getContextPath()%>/controller?cmd=crewUI">크루</a></li>
				<li><a
					href="<%=request.getContextPath()%>/controller?cmd=boardsUI">자유게시판</a></li>
			</ul>
		</nav>
		<div class="user-actions">
			<div class="user-icon">
				<i class="bi bi-person"></i>
			</div>
			<button class="login-btn">로그인</button>
		</div>
		<div class="header-divider"></div>
	</header>

	<!-- Main -->
	<main>
	<div class="content-container">
		<div class="form-title">크루 생성하기</div>
		<div class="form-subtitle">크루를 만들어보세요</div>

		<form id="crewForm"
			action="<%=request.getContextPath()%>/controller?cmd=addCrew"
			method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label class="form-label" for="crewName">크루명</label> <input
					type="text" class="form-control" id="crewName" name="crewName"
					required>
			</div>

			<div class="form-group">
				<label class="form-label" for="leaderId">리더 회원 아이디</label> <input
					type="text" class="form-control" id="leaderId" name="crewLeaderId"
					required>
			</div>

			<div class="form-group">
				<label class="form-label" for="image">크루 대표 이미지</label> <input
					type="file" class="form-control" id="image" name="image">
			</div>

			<div class="form-group">
				<label class="form-label" for="introduction">소개</label>
				<textarea class="form-control" id="introduction" name="introduction"></textarea>
			</div>

			<div class="form-group">
				<label class="form-label" for="category">관심사 카테고리</label> <select
					class="form-select" id="category" name="interestCategory" required>
					<option value="여행">여행</option>
					<option value="취미">취미</option>
					<option value="스터디">스터디</option>
					<option value="운동">운동</option>
					<option value="봉사">봉사</option>
					<option value="자기계발">자기계발</option>
					<option value="게임">게임</option>
					<option value="독서">독서</option>
					<option value="요리">요리</option>
					<option value="음악">음악</option>
					<option value="영화/드라마">영화/드라마</option>
					<option value="반려동물">반려동물</option>
					<option value="사진/영상">사진/영상</option>
					<option value="비즈니스/창업">비즈니스/창업</option>
					<option value="언어교환">언어교환</option>
					<option value="힐링/명상">힐링/명상</option>
					<option value="문화생활">문화생활</option>
				</select>
			</div>

			<div class="form-group">
				<label class="form-label" for="activityArea">모임 지역</label><select
					class="form-select" id="activityArea" name="guNumber">
					<option value="1111000000">종로구</option>
					<option value="1114000000">중구</option>
					<option value="1117000000">용산구</option>
					<option value="1120000000">성동구</option>
					<option value="1121500000">광진구</option>
					<option value="1123000000">동대문구</option>
					<option value="1126000000">중랑구</option>
					<option value="1129000000">성북구</option>
					<option value="1130500000">강북구</option>
					<option value="1132000000">도봉구</option>
					<option value="1135000000">노원구</option>
					<option value="1138000000">은평구</option>
					<option value="1141000000">서대문구</option>
					<option value="1144000000">마포구</option>
					<option value="1147000000">양천구</option>
					<option value="1150000000">강서구</option>
					<option value="1153000000">구로구</option>
					<option value="1154500000">금천구</option>
					<option value="1156000000">영등포구</option>
					<option value="1159000000">동작구</option>
					<option value="1162000000">관악구</option>
					<option value="1165000000">서초구</option>
					<option value="1168000000">강남구</option>
					<option value="1171000000">송파구</option>
					<option value="1174000000">강동구</option>
				</select>
			</div>


			<div class="form-group">
				<label class="form-label" for="age">연령</label> <select
					class="form-select" id="age" name="ageRange" required>
					<option value="10대">10대</option>
					<option value="20대">20대</option>
					<option value="30대">30대</option>
					<option value="40대 이상">40대 이상</option>
				</select>
			</div>

			<button type="button" class="crew-action-btn btn-light"
				id="promoButton">홍보하기</button>

			<div class="promo-message-container" id="promoMessageContainer">
				<div class="form-group">
					<label class="form-label" for="promoMessage">홍보 메시지</label>
					<textarea class="form-control" id="promoMessage"
						name="promotionMessage" placeholder="크루를 홍보할 메시지를 입력하세요"></textarea>
				</div>
			</div>

			<input type="hidden" id="isPromotion" name="isPromotion" value="N">

			<div class="form-actions">
				<a href="<%=request.getContextPath()%>/controller?cmd=crewUI"
					class="btn btn-cancel">취소</a>
				<button type="submit" class="btn btn-submit">제출</button>
			</div>
		</form>
	</div>
	</main>

	<script>
		// 홍보하기 버튼 토글
		document.addEventListener('DOMContentLoaded', function() {
			const
			promoButton = document.getElementById('promoButton');
			const
			promoMessageContainer = document
					.getElementById('promoMessageContainer');
			const
			promoMessage = document.getElementById('promoMessage');
			const
			isPromotionInput = document.getElementById('isPromotion');

			promoButton.addEventListener('click', function() {
				promoButton.classList.toggle('active');
				promoMessageContainer.classList.toggle('show');
				if (promoMessageContainer.classList.contains('show')) {
					isPromotionInput.value = "Y";
					promoMessage.focus();
				} else {
					isPromotionInput.value = "N";
				}
			});
		});
	</script>

</body>
</html>
