<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>컴리드 - 크루 메인</title>

<!-- CSS 여러 가져오기 -->
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
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: "Pretendard Variable", Pretendard, -apple-system,
		BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI",
		"Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic",
		"Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
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
	min-height: 400px;
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

.innerImage {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.card-img-container {
	height: 200px;
	overflow: hidden;
	display: flex;
	align-items: center;
	justify-content: center;
	border-bottom: 1px solid #eee;
}

.card {
	transition: transform 0.2s;
}

.card:hover {
	transform: translateY(-5px);
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.participant-count {
	font-size: 0.85rem;
}
</style>
</head>

<body>
	<!-- Header -->
	<header>
		<div class="logo">
			<img src="image/logo.png" alt="크루룽 로고"> <span class="logo-text">크루룽</span>
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
				<i class="bi bi-person"></i>
			</div>
			<button class="login-btn">로그인</button>
		</div>
		<div class="header-divider"></div>
	</header>

	<!-- 필터 영역 -->
	<div class="container my-4">
		<div class="row g-3">
			<div class="col-md-4">
				<select class="form-select" id="interestCategory">
					<option value="">관심사 전체</option>
					<option value="여행">여행</option>
					<option value="취미">취미</option>
					<option value="스터디">스터디</option>
					<option value="운동">운동</option>
					<option value="봉사">봉사</option>
					<option value="게임">게임</option>
					<option value="독서">독서</option>
					<option value="요리">요리</option>
					<option value="음악">음악</option>
				</select>
			</div>
			<div class="col-md-4">
				<select class="form-select" id="guName">
					<option value="">지역 전체</option>
					<option value="서울 강남구">서울 강남구</option>
					<option value="서울 관악구">서울 관악구</option>
					<option value="서울 금천구">서울 금천구</option>
					<option value="온라인">온라인</option>
				</select>
			</div>
			<div class="col-md-4">
				<select class="form-select" id="ageRange">
					<option value="">연령대 전체</option>
					<option value="10대">10대</option>
					<option value="20대">20대</option>
					<option value="30대">30대</option>
					<option value="40대 이상">40대 이상</option>
				</select>
			</div>
		</div>
	</div>

	<!-- 크루 카드 리스트 -->
	<div class="container">
		<div class="row g-4" id="crewCardsContainer"></div>
	</div>

	<!-- Footer -->
	<footer>
		<div class="footer-content">
			<div class="footer-left">
				<div>Corporate Name: 주식회사 크루 Owner: 김훈희 Business License:
					234-18-4251</div>
				<div>E-commerce Registration: 2022-서울강남-02241 Phone: 1533 KR
					(Kakao only) Contact Mail: Biz.at@gmail.com</div>
				<div>Address: 서울특별시 강남구 테헤란로 51길(역삼동) AB Personal Information
					Manager: 김도기 (info@gmail.com)</div>
				<div class="footer-copyright">© LIGHTNING CO., LTD. ALL RIGHTS
					RESERVED.</div>
			</div>
			<div class="footer-right">
				<div>CS Center: 1588-4321</div>
				<div>10:00AM - 7:00PM (Lunch 12:30 - 13:30)</div>
				<div>Sat/Sun/Holiday CLOSED</div>
			</div>
		</div>
	</footer>

	<!-- JavaScript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>

	<!-- 크루 동적 로딩 스크립트 -->
	<script>
	// JavaScript 부분
	document.addEventListener('DOMContentLoaded', function() {
	  const interestCategorySelect = document.getElementById('interestCategory');
	  const guNameSelect = document.getElementById('guName');
	  const ageRangeSelect = document.getElementById('ageRange');

	  loadCrewCards();

	  interestCategorySelect.addEventListener('change', loadCrewCards);
	  guNameSelect.addEventListener('change', loadCrewCards);
	  ageRangeSelect.addEventListener('change', loadCrewCards);

	  function loadCrewCards() {
	    const interestCategory = interestCategorySelect.value;
	    const guName = guNameSelect.value;
	    const ageRange = ageRangeSelect.value;

	    const params = new URLSearchParams({
	      interestCategory,
	      guName,
	      ageRange
	    });

	    fetch('/kosta/controller?cmd=crewFilterUI&' + params.toString())
	      .then(response => {
	        if (!response.ok) {
	          throw new Error('네트워크 응답 오류');
	        }
	        return response.json();
	      })
	      .then(data => {
	        const container = document.getElementById('crewCardsContainer'); // ★★★ 여기 crewCardsContainer!!
	        container.innerHTML = '';

	        if (data.length === 0) {
	          container.innerHTML = `<p class="text-center my-5">검색 결과가 없습니다.</p>`;
	          return;
	        }

	        data.forEach(crew => {
	          const cardHtml = `
	            <div class="col-md-6 col-lg-3">
	              <div class="card h-100 border">
	                <div class="card-img-container">
	                  <img src="${crew.image ? crew.image : '/kosta/image/placeholder.png'}" alt="${crew.crewName}" class="innerImage">
	                </div>
	                <div class="card-body p-3">
	                  <h5 class="card-title fw-bold mb-2">${crew.crewName}</h5>
	                  <p class="card-text small text-truncate">${crew.introduction || ''}</p>
	                  <div class="d-flex align-items-center mt-3">
	                    <span class="badge rounded-pill bg-light text-dark me-2">${crew.interestCategory || ''}</span>
	                    <span class="text-muted mx-2">|</span>
	                    <span class="small">${crew.guName || ''}</span>
	                    <span class="text-muted mx-2">|</span>
	                    <div class="d-flex align-items-center participant-count">
	                      <i class="bi bi-people-fill me-1"></i>
	                      <span>${crew.crewMembersCount || 0}명</span>
	                    </div>
	                  </div>
	                </div>
	              </div>
	            </div>
	          `;
	          container.insertAdjacentHTML('beforeend', cardHtml);
	        });
	      })
	      .catch(error => {
	        console.error('크루 목록 불러오기 실패:', error);
	        const container = document.getElementById('crewCardsContainer');
	        container.innerHTML = `<p class="text-center my-5 text-danger">데이터를 불러오지 못했습니다.</p>`;
	      });
	  }
	});
  </script>
</body>
</html>
