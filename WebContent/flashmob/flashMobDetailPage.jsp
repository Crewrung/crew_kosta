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
<title>크루룽 - ${flashmob.title}</title>

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

.comment-header {
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
	<main>
		<!-- 크루 상세 정보 컨테이너 -->
		<div class="content-container">
			<!-- 크루 배너 이미지와 업로드 버튼 -->
			<div class="crew-banner-container">
				<img src="./image/panel_image2.png" alt="크루 배너 이미지"
					class="crew-banner">
				<button class="image-upload-btn">
					<i class="bi bi-camera-fill upload-icon"></i>
				</button>
			</div>

			<!-- 크루 헤더 정보 -->
			<div class="crew-header">
				<div class="crew-info">
					<h1 class="crew-name">${flashmob.title}</h1>
				</div>

				<div class="crew-actions">
					<!-- 수정하기 버튼: 로그인한 사용자가 방장인 경우에만 표시 -->
					<c:if test="${isHost}">
						<form action="controller?cmd=updateFlashMobUI" method="post">
							<input type="hidden" name="flashMobNumber"
								value="${flashmob.flashMobNumber}" />
							<button type="submit" class="crew-set-btn btn-light">수정하기</button>
						</form>
					</c:if>
				</div>
			</div>

			<!-- 크루 설명 -->
			<div class="crew-description">
				<p>${flashmob.content}</p>
			</div>

			<!-- 신청 버튼: 로그인하지 않았거나, 로그인했지만 방장이 아니고 아직 신청하지 않은 경우에만 표시 -->
			<c:choose>
				<c:when test="${isHost}">
					<!-- 로그인했고 방장인 경우: 신청하기 버튼 숨김 -->
				</c:when>
				<c:when test="${isParticipant}">
					<!-- 로그인했고 이미 참가한 경우: 신청하기 버튼 숨김 -->
				</c:when>
				<c:otherwise>
					<!-- 로그인했고 아직 참가하지 않은 경우 -->
					<form action="controller?cmd=applyFlashMob" method="post">
						<input type="hidden" name="flashMobNumber"
							value="${flashmob.flashMobNumber}" />
						<button type="submit" class="join-crew-btn">신청하기</button>
					</form>
				</c:otherwise>
			</c:choose>


			<!-- 크루 멤버 섹션 -->
			<div class="section-title">모임원</div>
			<div class="crew-members">
				<!-- 방장 정보 -->
				<div class="member-card">
					<img src="./image/placeholder.png" alt="멤버 이미지" class="member-img">
					<div class="member-rank">모임장</div>
					<div class="member-name">${leader.nickname}</div>
				</div>

				<!-- 참가자 목록 -->
				<c:forEach var="participant" items="${participants}">
					<div class="member-card">
						<img src="./image/placeholder.png" alt="멤버 이미지" class="member-img">
						<div class="member-rank">참석자</div>
						<div class="member-name">${participant.nickname}</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- 댓글 섹션 -->
		<div class="content-container">
			<div class="section-title">전체 댓글 ${comments != null ? comments.size() : 0}개</div>

			<!-- 댓글 입력 폼 -->
			<form class="comment-form" action="controller?cmd=addFlashMobComment"
				method="POST">

				<!-- 숨겨진 flashmob 번호 -->
				<input type="hidden" name="flashMobNumber"
					value="${flashmob.flashMobNumber}" />
				<textarea name="comment" class="comment-input"
					placeholder="댓글을 입력하세요..."></textarea>
				<button type="submit" class="comment-submit">등록</button>
			</form>

			<!-- 댓글 목록 -->
			<div class="comment-list">
				<c:forEach var="comment" items="${comments}">
					<div class="comment-item">
						<div class="comment-header">
							<c:set var="nickname"
								value="${comment.userId}" />
							<div class="comment-user">${nickname}</div>
							<div class="comment-date">${comment.commentDate}</div>
						</div>
						<div class="comment-text">${comment.flashMobComment}</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</main>

	<!-- 푸터 - 두 열 레이아웃 -->
	<%@ include file="../footer.jsp"%>
</body>
</html>
