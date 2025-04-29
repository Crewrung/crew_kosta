<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루룽 - 번개 모임</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css" />
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
	margin-bottom: 0px;
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

.hero-banner::before {
	content: "";
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.3);
}

.profile-img {
	width: 100px;
	height: 100px;
	background-color: #f0f0f0;
	border-radius: 5px;
}

.small-profile-img {
	width: 60px;
	height: 60px;
	background-color: #f0f0f0;
	border-radius: 5px;
}

.crew-card {
	border: 1px solid #e0e0e0;
	border-radius: 5px;
	padding: 15px;
	margin-bottom: 20px;
}

.crew-member-card {
	border: 1px solid #e0e0e0;
	border-radius: 5px;
	padding: 15px;
	margin-bottom: 20px;
	height: 100%;
}

.section-title {
	font-size: 1.3rem;
	font-weight: bold;
	margin-bottom: 20px;
	margin-top: 30px;
}

.crew-info {
	display: flex;
	align-items: flex-start;
}

.crew-details {
	margin-left: 15px;
	flex-grow: 1;
}

.crew-name {
	font-weight: bold;
	font-size: 1.1rem;
	margin-bottom: 5px;
}

.crew-meta {
	display: flex;
	align-items: center;
	margin-bottom: 10px;
	font-size: 0.9rem;
}

.crew-meta .person-icon {
	color: #FFC107;
	margin-right: 5px;
}

.crew-meta .location-icon {
	color: #6c757d;
	margin: 0 5px 0 10px;
}

.crew-meta .area-icon {
	color: #0d6efd;
	margin: 0 5px 0 10px;
}

.crew-description {
	font-size: 0.9rem;
	color: #333;
	margin-bottom: 15px;
	line-height: 1.5;
}

.action-buttons {
	display: flex;
	justify-content: flex-end;
	gap: 5px;
}

.btn-reject {
	background-color: #f8f9fa;
	border: 1px solid #dee2e6;
	color: #212529;
}

.btn-approve {
	background-color: #212529;
	color: white;
}

.btn-sm {
	font-size: 0.8rem;
	padding: 0.25rem 0.5rem;
}
</style>
</head>
<body>
	<!-- 헤더  -->
	<c:import url="../header.jsp"></c:import>

	<div class="container-fluid p-0">



		<!-- Main Content -->
		<div class="container py-4">
			<!-- Crew Application List -->
			<h2 class="section-title">크루 가입 신청자 목록</h2>

			<c:forEach var="applicant" items="${crewApplicants}">
				<div class="crew-card">
					<div class="crew-info">
						<%-- <img src="${ applicant.profileImage }"> --%>
						<div class="profile-img"></div>
						<div class="crew-details">
							<div class="crew-name">${ applicant.nickname }</div>
							<div class="crew-meta">
								<i class="bi bi-person-fill person-icon"></i> ${ applicant.age }세
								<i class="bi bi-gender-female location-icon"></i> ${ applicant.gender }
								<i class="bi bi-geo-alt-fill area-icon"></i> ${ applicant.city }
							</div>
							<div class="crew-description">${ applicant.introduction }</div>
						</div>
					</div>
					<div class="action-buttons">
						<form action="controller?cmd=rejectCrewJoinRequest" method="POST" onsubmit="return confirm('정말 가입 신청을 거절하시겠습니까?');">
							<input type="hidden" name="crewNumber" value="${crewNumber}">
							<input type="hidden" name="crewApplyNumber"
								value="${applicant.crewApplyNumber}">
							<button type="submit" class="btn btn-reject btn-sm">가입
								거절</button>
						</form>
						<form action="controller?cmd=approveCrewJoinRequest" method="POST" onsubmit="return confirm('정말 가입 승인을 하시겠습니까?');">
							<input type="hidden" name="crewNumber" value="${crewNumber}">
							<input type="hidden" name="userId" value="${applicant.userId}">
							<input type="hidden" name="crewApplyNumber"
								value="${applicant.crewApplyNumber}">
							<button class="btn btn-approve btn-sm">가입 승인</button>
						</form>
					</div>
				</div>

			</c:forEach>
			<!-- Crew Members -->
			<h2 class="section-title">크루원</h2>

			<div class="container">
				<div class="row g-3">
					<c:forEach var="member" items="${crewMembers}">
						<!-- 3 개씩 배치하기 위해 col-md-6 사용 -->
						<div class="col-md-6 col-lg-4">
							<div class="crew-member-card">
								<div class="crew-info">
									<div class="small-profile-img"></div>
									<div class="crew-details">
										<div class="crew-name">${ member.nickname }</div>
										<div class="crew-meta">
											<i class="bi bi-person-fill person-icon"></i> ${ member.age }세
											<i class="bi bi-gender-female location-icon"></i> ${ member.gender }
											<i class="bi bi-geo-alt-fill area-icon"></i> ${ member.city }
										</div>
									</div>
								</div>
								<div class="action-buttons mt-2">
									<form action="controller?cmd=deleteCrewMember" method="POST" onsubmit="return confirm('정말 추방 하시겠습니까?');">
										<input type="hidden" name="crewNumber" value="${crewNumber}">
										<input type="hidden" name="crewUserId" value="${member.userId}">
										<button class="btn btn-approve btn-sm">추방하기</button>
									</form>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<c:import url="../footer.jsp"></c:import>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
<script>
	
</script>
</html>