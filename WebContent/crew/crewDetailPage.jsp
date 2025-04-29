<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
	crossorigin="anonymous"></script>
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css" />
<title>크루룽</title>

<style>
/* 기본 리셋 */
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
.banner-text {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	color: #888;
	font-size: 1.2rem;
}

.crew-banner {
	width: 100%;
	height: auto;
}

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

/* 크루 상세 정보 스타일 */
.crew-header {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	margin-bottom: 20px;
	position: relative;
}

.crew-banner-container {
	position: relative;
	width: 100%;
	margin-bottom: 15px;
}

.crew-banner {
	width: 100%;
	height: 200px;
	object-fit: cover;
	border-radius: 8px;
}

.image-upload-btn {
	position: absolute;
	bottom: 10px;
	right: 10px;
	width: 40px;
	height: 40px;
	background-color: rgba(255, 255, 255, 0.8);
	border-radius: 50%;
	display: flex;
	align-items: center;
	justify-content: center;
	cursor: pointer;
	border: none;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
	transition: all 0.2s ease;
}

.image-upload-btn:hover {
	background-color: rgba(255, 255, 255, 1);
	transform: scale(1.05);
}

.upload-icon {
	font-size: 20px;
	color: #333;
}

.crew-info {
	display: flex;
	flex-direction: column;
}

.crew-name {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 5px;
}

.crew-category {
	color: #666;
	font-size: 14px;
	margin-bottom: 15px;
}

.crew-actions {
	display: flex;
	gap: 10px;
}

.crew-action-btn {
	padding: 6px 12px;
	border-radius: 4px;
	font-size: 12px;
	cursor: pointer;
}

.crew-set-btn {
	padding: 6px 12px;
	border-radius: 4px;
	font-size: 12px;
	cursor: pointer;
}

.btn-dark {
	background-color: #333;
	color: white;
	border: none;
}

.btn-light {
	background-color: #f5f5f5;
	border: 1px solid #ddd;
}

.crew-description {
	margin-bottom: 30px;
}

.crew-description ul {
	list-style-position: inside;
	margin-left: 10px;
	margin-bottom: 15px;
}

.crew-description li {
	margin-bottom: 5px;
	line-height: 1.5;
}

.crew-description p {
	line-height: 1.6;
	margin-bottom: 10px;
}

.section-title {
	font-size: 18px;
	font-weight: bold;
	margin-bottom: 15px;
	padding-bottom: 10px;
	border-bottom: 1px solid #eee;
}

.meeting {
	font-size: 18px;
	font-weight: bold;
}

.crew-members {
	display: flex;
	gap: 20px;
	margin-bottom: 30px;
}

.member-card {
	width: 100px;
	text-align: center;
}

.member-img {
	width: 60px;
	height: 60px;
	border-radius: 50%;
	object-fit: cover;
	margin-bottom: 8px;
}

.member-name {
	font-size: 14px;
}

.activity-cards {
	display: flex;
	gap: 20px;
	margin-bottom: 30px;
}

.activity-card {
	width: calc(33.33% - 14px);
	border: 1px solid #eee;
	border-radius: 8px;
	overflow: hidden;
}

.activity-img {
	width: 100%;
	height: 120px;
	object-fit: cover;
}

.activity-content {
	padding: 12px;
}

.activity-title {
	font-weight: bold;
	margin-bottom: 8px;
	font-size: 16px;
}

.activity-info {
	font-size: 12px;
	color: #666;
	margin-bottom: 5px;
}

.add-crew-flashmob {
	text-align: right;
	margin-top: 10px;
}

.join-crew-btn {
	display: block;
	width: 100%;
	padding: 12px;
	background-color: #8a2be2;
	color: white;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	font-weight: bold;
	cursor: pointer;
	margin-bottom: 20px;
	margin-top: 10px;
}

.comments-section {
	margin-top: 30px;
}

.comment-list {
	margin-bottom: 20px;
}

.comment-item {
	padding: 15px 0;
	border-bottom: 1px solid #eee;
}

.comment-body {
	display: flex;
	justify-content: space-between;
	margin-bottom: 8px;
}

.comment-user {
	font-weight: bold;
}

.comment-date {
	font-size: 12px;
	color: #999;
}

.comment-text {
	line-height: 1.5;
}

.comment-form {
	display: flex;
	margin-top: 20px;
}

.comment-input {
	flex: 1;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	resize: none;
}

.comment-submit {
	padding: 10px 15px;
	background-color: #333;
	color: white;
	border: none;
	border-radius: 4px;
	margin-left: 10px;
	cursor: pointer;
}

.rating-section {
	display: flex;
	overflow-x: auto;
	margin-bottom: 20px;
	padding: 10px 0;
}

.rating-item {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-right: 15px;
}

.rating-icon {
	width: 40px;
	height: 40px;
	background-color: #ffd700;
	border-radius: 50%;
	display: flex;
	align-items: center;
	justify-content: center;
	margin-bottom: 5px;
}

.rating-label {
	font-size: 12px;
	color: #666;
}

.rating-form {
	background-color: #f9f9f9;
	padding: 15px;
	border-radius: 8px;
	margin-bottom: 20px;
}

.rating-input {
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	margin-bottom: 10px;
}

.rating-submit {
	padding: 8px 15px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
</style>
</head>
<body>
	<!-- 헤더 -->
	<%@ include file="../header.jsp"%>

	<!-- 메인 콘텐츠 영역 - 크루 상세 정보 -->
	<main> <!-- 크루 상세 정보 컨테이너 -->
	<div class="content-container">
		<!-- 크루 배너 이미지와 업로드 버튼 -->
		<div class="crew-banner-container" style="position: relative;">
			<!-- <div id="bannerText" class="banner-text">이미지를 넣어주세요.</div> -->
			<img src="flash.png" alt="크루 배너 이미지">
			<!-- <button type="button" class="image-upload-btn"
				onclick="document.getElementById('bannerUpload').click()">
				<i class="bi bi-camera-fill upload-icon"></i>
			</button>

			<input type="file" id="bannerUpload" accept="image/*"
				style="display: none;" onchange="handleImageUpload(event)"> -->
		</div>
		<!-- 크루 헤더 정보 -->
		<div class="crew-header">
			<div class="crew-info">
				<h1 id="crew-name">크루명: ${crew.crewName}</h1>
				<p id="crew-interestCategory">크루분야: ${crew.interestCategory}</p>
			</div>
			<div class="crew-actions">
				<button class="crew-action-btn btn-light"
					onclick="location.href='controller?cmd=updateCrewUI&crewNumber=${crewNumber}'">크루관리</button>
			</div>
			<!-- if모임장일때 필요-->
		</div>

		<!-- 크루 설명 -->
		<div class="crew-description">
			<p id="crew-content">${crew.introduction}</p>
		</div>

		<!-- 크루 멤버 섹션 -->
		<div class=section-title>크루원</div>
		<div class="crew-members">
			<c:forEach var="member" items="${crewMembers}">
				<div class="member-card">
					<img src="https://avatars.dicebear.com/api/adventurer/12345.svg"
						alt="멤버 이미지" class="img-fluid rounded-circle">
					<div class="member-nickname">${member.nickname}</div>
				</div>
			</c:forEach>
		</div>

		<!-- 활동 및 모임 섹션 -->
		<div class="d-flex justify-content-between align-items-center">
			<div class="meeting">활동 및 모임 일정</div>
			<div class="add-crew-flashmob">
				<form action="controller?cmd=addCrewMeetingUI" method="POST">
					<button class="crew-set-btn btn-light" type="submit">크루모임
						등록</button>
				</form>
			</div>
		</div>
		<hr class="w-100">
		<div class="activity-cards">
			<c:forEach var="meeting" items="${crewMeetings}">
				<div class="activity-card"
					onclick="location.href='controller?cmd=crewMeetingDetailUI&number=${meeting.crewMeetingNumber}'"
					style="cursor: pointer;">
					<!-- 크루미팅넘버 가져오게하기  -->
					<%-- <img src="${meeting.image}" alt="활동 이미지" class="activity-img"> --%>
					<img src="default.png" alt="활동 이미지" class="activity-img">
					<div class="activity-title">${meeting.title}</div>
					<div class="activity-content">${meeting.content}</div>
					<div class="activity-date">${meeting.meetingDate}</div>
				</div>
			</c:forEach>




		</div>
		<button class="join-crew-btn" onclick="location.href='controller?cmd=applyCrewUI'">가입하기</button>
		<!-- 사용자가 이 크루에 가입되어있는지 -->
		<!-- 댓글 섹션 -->
		<div class="content-container">
			<div class="section-title">전체 댓글 ${crewCommentCount}개</div>

			<!-- 댓글 입력 폼 -->
			<!-- 크루아이디, 작성자id 갖고오기 -->
			<div class="comment-form">
				<textarea class="comment-input" placeholder="댓글을 입력하세요..."></textarea>
				<button class="comment-submit">등록</button>
			</div>

			<!-- 댓글 목록 -->
			<!-- 크루원이 아니면 비공개로 보이게 -->
			<div class="comment-list">
				<c:forEach var="comment" items="${crewComments}">
					<div class="comment-item">
						<div class="comment-user">${ comment.nickname }</div>
						<div class="comment-body">
							<div class="comment-text">${ comment.crewComment }</div>
							<div class="comment-date"><%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date())%></div>
							<!-- VO에 날짜 필요 + SQL  -->
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
	</main>

	<!-- 푸터 - 두 열 레이아웃 -->
	<c:import url="../footer.jsp"></c:import>
	</script>
</body>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</html>