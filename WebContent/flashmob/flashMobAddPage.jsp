<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>크루룽</title>
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

/* 메인 콘텐츠 내부 컨테이너 스타일 */
.content-container {
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin-bottom: 20px;
}

/* 폼 스타일 */
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

.form-control {
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 14px;
}

.form-control:disabled, .form-control[readonly] {
	background-color: #f8f9fa;
	opacity: 1;
}

textarea.form-control {
	min-height: 100px;
}

.form-select {
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	font-size: 14px;
	appearance: none;
	background-image:
		url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 24 24' fill='none' stroke='%23333' stroke-width='2' stroke-linecap='round' stroke-linejoin='round'%3E%3Cpolyline points='6 9 12 15 18 9'%3E%3C/polyline%3E%3C/svg%3E");
	background-repeat: no-repeat;
	background-position: right 10px center;
}

.form-check {
	display: flex;
	align-items: center;
	margin-bottom: 20px;
}

.form-check-input {
	margin-right: 8px;
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

.terms-link {
	display: block;
	margin-top: 5px;
	font-size: 12px;
	color: #666;
	text-decoration: none;
}
</style>
</head>

<body>
	<!-- 헤더 -->
	<%@ include file="../header.jsp"%>

	<!-- 메인 콘텐츠 영역 -->
	<main> <!-- 번개모임 생성하기 폼 -->
	<div class="content-container">
		<div class="form-title">번개모임 생성하기</div>
		<div class="form-subtitle">번개모임을 만들어보세요</div>

		<form action="controller?cmd=addFlashMob" method="POST">
			<div class="form-group">
				<label class="form-label" for="title">제목</label> <input type="text"
					class="form-control" id="title" name="title"
					placeholder="제목을 입력하세요">
			</div>

			<div class="form-group">
				<label class="form-label" for="hostId">주최자 회원 아이디</label> <input
					type="text" class="form-control" id="hostId" name="hostId"
					value="${userId}" readonly>
			</div>

			<div class="form-group">
				<label class="form-label" for="content">내용</label>
				<textarea class="form-control" id="content" name="content"
					placeholder="내용을 입력하세요"></textarea>
			</div>

			<div class="form-group">
				<label class="form-label" for="interestCategory">관심사 카테고리</label> <select
					class="form-select" id="interestCategory" name="interestCategory">
					<option value="">선택하세요</option>
					<option>여행</option>
					<option>음악</option>
					<option>게임</option>
					<option>베이킹</option>
					<option>영화</option>
					<option>독서</option>
					<option>사진</option>
					<option>패션</option>
					<option>운동</option>
					<option>공예</option>
					<option>프로그래밍</option>
					<option>반려동물</option>
					<option>미술</option>
					<option>캠핑</option>
				</select>
			</div>

			<div class="form-group">
				<label class="form-label" for="guNumber">모임지역</label> <select
					class="form-select" id="guNumber" name="guNumber">
					<option value="">선택하세요</option>
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
					<option value="0">온라인</option>
				</select>
			</div>

			<div class="form-group">
				<label class="form-label" for="ageRange">연령대</label> <select
					class="form-select" id="ageRange" name="ageRange">
					<option value="">선택하세요</option>
					<option>10대</option>
					<option>20대</option>
					<option>30대</option>
					<option>40대이상</option>
				</select>
			</div>

			<div class="form-group">
				<label class="form-label" for="maxMember">최대 인원</label> <input
					type="number" class="form-control" id="maxMember" name="maxMember"
					placeholder="최대 인원수를 입력하세요">
			</div>

			<div class="form-group">
				<div class="mb-3">
					<label class="form-label" for="meetingDate">모임 날짜</label> <input
						type="date" class="form-control" id="meetingDate"
						name="meetingDate">
				</div>
			</div>

			<div class="mb-3">
				<label class="form-label" for="time">시간</label> <input type="time"
					class="form-control" id="time" name="time">
			</div>

			<div class="form-actions">
				<button type="button" class="btn btn-cancel"
					onclick="history.back()">취소</button>
				<button type="submit" class="btn btn-submit">제출</button>
			</div>
		</form>
	</div>
	</main>

	<!-- 푸터 - 두 열 레이아웃 -->
	<%@ include file="../footer.jsp"%>
</body>
</html>