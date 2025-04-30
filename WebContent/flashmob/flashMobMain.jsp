<%@page import="com.crewrung.flashMob.vo.FlashMobMainViewVO"%>
<%@page import="com.crewrung.crew.vo.AllCrewVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="org.apache.ibatis.session.SqlSession"%>
<%@ page import="com.crewrung.crew.dao.CrewDAO" %>
<%@ page import="com.crewrung.crew.service.CrewService" %>
<%@ page import="com.crewrung.db.DBCP" %>
<%@ page import="com.crewrung.flashMob.dao.FlashMobDAO" %>
<%@ page import="com.crewrung.flashMob.service.FlashMobService" %>
<%@ page import="com.crewrung.flashMob.vo.FlashMobMainViewVO" %>
<%@ page import="com.crewrung.crew.dao.CrewDAO" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FlashMob List</title>
<!-- Bootstrap CSS -->
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
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css" />
<style>
/* 기본 스타일 */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: "Pretendard letiable", Pretendard, -apple-system,
		BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI",
		"Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic",
		"Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
	background-color: #f9f9f9;
}


/* 캐러셀 스타일 */
.carousel-item {
	height: 400px;
}

.carousel-item img {
	object-fit: cover;
	height: 100%;
	width: 100%;
}

.carousel-caption {
	background-color: rgba(0, 0, 0, 0.5);
	border-radius: 10px;
	padding: 20px;
	max-width: 80%;
	margin: 0 auto;
	bottom: 30%;
}

.carousel-caption h2 {
	font-size: 2rem;
	font-weight: bold;
	text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
}

.carousel-caption p {
	font-size: 1.2rem;
	text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.7);
}

.lightning-icon {
	font-size: 1.5rem;
	margin-right: 10px;
	color: #ffc107;
}

/* 카드 스타일 */
.custom-card {
	border-radius: 8px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	background-color: white;
	margin-bottom: 20px;
	overflow: hidden;
	transition: transform 0.3s;
	height: 100%;
	text-decoration: none;
	color: inherit;
	display: block;
}

.custom-card:hover {
	transform: translateY(-5px);
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
	color: inherit;
}

.card-icon {
	padding: 15px;
	text-align: center;
	background-color: white;
}

.card-icon img {
	height: 100px;
	width: 250px;
}

.card-content {
	padding: 15px;
}

.card-title {
	font-weight: bold;
	font-size: 16px;
	margin-bottom: 5px;
}

.card-subtitle {
	color: #666;
	font-size: 14px;
	margin-bottom: 15px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.card-meta {
	display: flex;
	justify-content: space-between;
	align-items: center;
	border-top: 1px solid #eee;
	padding-top: 10px;
	font-size: 12px;
}

.meta-left {
	display: flex;
	align-items: center;
}

.meta-item {
	display: flex;
	align-items: center;
	margin-right: 10px;
}

.meta-icon {
	width: 16px;
	height: 16px;
	margin-right: 5px;
	display: flex;
	align-items: center;
	justify-content: center;
}

.meta-icon.location {
	color: #e74c3c;
}

.meta-icon.people {
	color: #3498db;
}

a {
	text-decoration: none;
	color: inherit;
}

/* 카드 캐러셀 스타일 */
.card-carousel .carousel-control-prev, .card-carousel .carousel-control-next
	{
	width: 40px;
	height: 40px;
	background-color: rgba(0, 0, 0, 0.3);
	border-radius: 50%;
	top: 50%;
	transform: translateY(-50%);
}

.card-carousel .carousel-control-prev {
	left: -20px;
}

.card-carousel .carousel-control-next {
	right: -20px;
}

.card-carousel .carousel-control-prev-icon, .card-carousel .carousel-control-next-icon
	{
	width: 20px;
	height: 20px;
}

.card-carousel .carousel-item {
	height: auto;
}

.card-carousel .carousel-indicators {
	bottom: -40px;
}

.card-carousel .carousel-indicators button {
	width: 10px;
	height: 10px;
	border-radius: 50%;
	background-color: #ccc;
	margin: 0 5px;
}

.card-carousel .carousel-indicators button.active {
	background-color: #666;
}

.card-carousel-container {
	position: relative;
	padding-bottom: 50px;
}

.section-title {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-bottom: 1.5rem;
}

.section-title-name {
  display: flex;
  align-items: center;
}

#not-flashMobs {
  display: flex;
  justify-content: center; /* 수평 가운데 정렬 */
  align-items: center;     /* 수직 가운데 정렬 */
  height: 300px;           /* 적당한 높이 설정 (필요에 따라 조정) */
  font-size: 1.5rem;       /* 글자 크기 키우기 (선택사항) */
  color: #666;             /* 글자 색 변경 (선택사항) */
}

#filterContainer {
    display: flex;
    flex-wrap: wrap; /* Ensure elements wrap to new rows if necessary */
    gap: 16px; /* Add spacing between the select elements */
    margin-bottom: 1rem; /* Add margin to the bottom */
}

#filterContainer .form-group {
    flex: 1; /* Allow select elements to grow */
    min-width: 150px; /* Minimum width for each select */
}

@media (max-width: 767px) {
    #filterContainer {
        flex-direction: column; /* Stack the selects vertically on small screens */
    }

    #filterContainer .form-group {
        width: 100%; /* Make each select take full width on small screens */
    }
}


</style>
</head>
<body>
	<!-- 헤더 -->
    <%@ include file="/header.jsp" %>
    

	<!-- 메인 콘텐츠 영역 -->
	<main class="container py-5"> <!-- 번개 모임 섹션 -->
	<section class="mb-5">
    <div class="section-title">
    	<div class="section-title-name">
        <span class="lightning-icon">⚡</span>
        <h2 class="fs-4 mb-0">번개 모임</h2>
        </div>
        <a href="controller?cmd=addFlashMobUI" class="btn btn-primary">
            <i class="bi bi-plus-lg"></i> 번개모임 추가
        </a>
    </div>

    <!-- 필터 컨테이너 추가 위치 -->
    <div id="filterContainer" class="filter-container mb-4">
        <div class="form-group">
            <select class="form-select" id="interestCategory" name="interestCategory">
                <option value="전체" selected>전체</option>
                <option value="여행">여행</option>
                <option value="음악">음악</option>
                <option value="게임">게임</option>
                <option value="베이킹">베이킹</option>
                <option value="영화">영화</option>
                <option value="독서">독서</option>
                <option value="사진">사진</option>
                <option value="패션">패션</option>
                <option value="운동">운동</option>
                <option value="공예">공예</option>
                <option value="프로그램">프로그래밍</option>
                <option value="반려동물">반려동물</option>
                <option value="미술">미술</option>
                <option value="캠핑">캠핑</option>
            </select>
        </div>

        <div class="form-group">
            <select class="form-select" id="guNumber" name="guNumber">
                <option value="전체" selected>전체</option>
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
        </div>

        <div class="form-group">
            <select class="form-select" id="ageRange" name="ageRange">
                <option value="전체" selected>전체</option>
                <option value="10대">10대</option>
                <option value="20대">20대</option>
                <option value="30대">30대</option>
                <option value="40대이상">40대이상</option>
            </select>
        </div>
        
        <div class="form-group">
			<button id="searchButton" class="btn btn-primary w-100" >검색</button>
		</div>
    </div>
    
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4" id="flashMobListContainer">
        <%
        SqlSession dbSession = DBCP.getSqlSessionFactory().openSession();
        FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(dbSession));
        List<FlashMobMainViewVO> flashMobList = flashMobService.getAllFlashMobs();

        if (flashMobList == null) {
            flashMobList = new ArrayList<>();
        }

        for (FlashMobMainViewVO flashMob : flashMobList) {
            int flashMobNumber = (int) flashMob.getClass().getMethod("getFlashMobNumber").invoke(flashMob);
            String title = (String) flashMob.getClass().getMethod("getTitle").invoke(flashMob);
            String content = (String) flashMob.getClass().getMethod("getContent").invoke(flashMob);
            String interestCategory = (String) flashMob.getClass().getMethod("getInterestCategory").invoke(flashMob);
            String guName = (String) flashMob.getClass().getMethod("getGuName").invoke(flashMob);
            int participantCount = (int) flashMob.getClass().getMethod("getParticipantCount").invoke(flashMob);
            int maxMember = (int) flashMob.getClass().getMethod("getMaxMember").invoke(flashMob);
            Date meetingDate = (Date) flashMob.getClass().getMethod("getMeetingDate").invoke(flashMob);
            String image = (String) flashMob.getClass().getMethod("getImage").invoke(flashMob);

            SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
            String formattedDate = sdf.format(meetingDate);
        %>
        <div class="col">
            <a href="controller?cmd=flashMobDetailUI&flashMobNumber=<%= flashMobNumber %>" class="custom-card">
                <div class="card-icon">
                    <img src="<%= image != null ? image : "image/flash.png" %>" alt="번개 아이콘">
                </div>
                <div class="card-content">
                    <div class="card-title"><%= title %></div>
                    <div class="card-subtitle"><%= content %></div>
                    <div class="card-meta">
                        <div class="meta-left">
                            <div class="meta-item">
                                <span>🎯<%= interestCategory %></span>
                            </div>
                            <div class="meta-item">
                                <div class="meta-icon location">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16"
                                        height="16" fill="currentColor"
                                        class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                                        <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z" />
                                    </svg>
                                </div>
                                <span><%= guName %></span>
                            </div>
                            <div class="meta-item">
                                <div class="meta-icon people">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16"
                                        height="16" fill="currentColor" class="bi bi-people-fill"
                                        viewBox="0 0 16 16">
                                        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" />
                                    </svg>
                                </div>
                                <span><%= participantCount %>/<%= maxMember %></span>
                            </div>
                        </div>
                        <div class="meta-right"><%= formattedDate %></div>
                    </div>
                </div>
            </a>
        </div>
        <% } %>

        <% if (flashMobList.isEmpty()) { %>
        <div class="col">
            <div class="custom-card">
                <div class="card-content text-center py-5">
                    <p>번개 모임이 없습니다.</p>
                </div>
            </div>
        </div>
        <% } %>
    </div>

</section>
	
	</main>

	<!-- 푸터 -->
	<%@ include file="/footer.jsp" %>
	
	<script type="text/javascript">
	$(document).ready(function() {
		  $("#searchButton").click(function() {
		    // jQuery 방식으로 값 얻기
		    let interestCategory = $("#interestCategory").val();
		    let guNumber = $("#guNumber").val();
		    let ageRange = $("#ageRange").val();
		    
			console.log(interestCategory);
			console.log(guNumber);
			console.log(ageRange);

		    let dataObj = {
			  cmd: "flashMobFilter",
			};

		    if (guNumber != "전체") dataObj.guNumber = guNumber;
		    if (interestCategory != "전체") dataObj.interestCategory = interestCategory;
		    if (ageRange != "전체") dataObj.ageRange = ageRange;
			
			console.log(dataObj);
			

			$.ajax({
	            url: "/kosta/controller",
	            type: "GET",
	            data: dataObj,
	            dataType: "json",
	            success: function(response) {
	                let container = $("#flashMobListContainer");
	                container.empty();
	                if ($("#not-flashMobs").length) $("#not-flashMobs").remove();
	                console.log(response);
	                

	                if (typeof response === "object" && Object.keys(response).length === 0) {
	                	$('#filterContainer').after(
	                                    '<div id="not-flashMobs">번개 모임이 없습니다.</div>'
	                    );
	                } else {
	                    response.forEach(function(flashMob) {
	                        let flashMobNumber = flashMob.flashMobNumber || 0;
	                        let title = flashMob.title || "제목 없음";
	                        let content = flashMob.content || "내용 없음";
	                        let interestCategory = flashMob.interestCategory || "카테고리 없음";
	                        let guName = flashMob.guName || "장소 없음";
	                        let participantCount = flashMob.participantCount || 0;
	                        let maxMember = flashMob.maxMember || 0;
	                        let meetingDate = flashMob.meetingDate || new Date();
	                        let image = flashMob.image || "image/flash.png";
	                      

	                        let date = new Date(meetingDate);

	                        let year = String(date.getFullYear()).slice(-2); // 연도 뒤 2자리
	                        let month = String(date.getMonth() + 1).padStart(2, '0'); // 월(2자리)
	                        let day = String(date.getDate()).padStart(2, '0'); // 일(2자리)

	                        let formattedDate = year + '/' + month + '/' + day;
	                        console.log(formattedDate); // 예: 25/07/13
	                        
	                        let html = ''
	                            + '<div class="col">'
	                            + '<a href="controller?cmd=flashMobDetailUI&flashMobNumber=' + flashMobNumber + '" class="custom-card">'
	                                + '<div class="card-icon">'
	                                    + '<img src="' + image + '" alt="번개 아이콘">'
	                                + '</div>'
	                                + '<div class="card-content">'
	                                    + '<div class="card-title">' + title + '</div>'
	                                    + '<div class="card-subtitle">' + content + '</div>'
	                                    + '<div class="card-meta">'
	                                        + '<div class="meta-left">'
	                                            + '<div class="meta-item">'
	                                                + '<span>🎯 ' + interestCategory + '</span>'
	                                            + '</div>'
	                                            + '<div class="meta-item">'
	                                                + '<div class="meta-icon location">'
	                                                    + '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">'
	                                                        + '<path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z"/>'
	                                                    + '</svg>'
	                                                + '</div>'
	                                                + '<span>' + guName + '</span>'
	                                            + '</div>'
	                                            + '<div class="meta-item">'
	                                                + '<div class="meta-icon people">'
	                                                    + '<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">'
	                                                        + '<path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z"/>'
	                                                    + '</svg>'
	                                                + '</div>'
	                                                + '<span>' + participantCount + '/' + maxMember + '</span>'
	                                            + '</div>'
	                                        + '</div>'
	                                        + '<div class="meta-right">' + formattedDate + '</div>'
	                                    + '</div>'
	                                + '</div>'
	                            + '</a>'
	                            + '</div>';

	                        container.append(html);
	                    });
	                }
	            },
	            error: function(xhr, status, error) {
	                console.error("에러 발생:", status, error);
	            }
	        });
	    });
	});
	</script>

	<%
  // 세션 닫기
  dbSession.close();
  %>
</body>
</html>

