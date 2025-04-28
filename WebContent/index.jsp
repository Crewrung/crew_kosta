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
<title>크루룽</title>
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
	font-family: "Pretendard Variable", Pretendard, -apple-system,
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

/* 섹션 스타일 */
.section-title {
	display: flex;
	align-items: center;
	margin-bottom: 1.5rem;
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
</style>
</head>
<body>
	<!-- 헤더 -->
    <%@ include file="header.jsp" %>

	<!-- 배너 슬라이드쇼 -->
	<div id="mainCarousel" class="carousel slide" data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#mainCarousel"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#mainCarousel"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
		</div>

		<div class="carousel-inner">
			<div class="carousel-item active">
				<a href="?cmd=crewDetailUI&crewNumber=1"> <img
					src="image/riding.png" class="d-block w-100" alt="거제 자전거 라이딩 크루">
					<div class="carousel-caption d-none d-md-block">
						<h2>거제 자전거 라이딩 크루로 들어오세요~~~!!</h2>
						<p>함께 달리는 즐거움을 경험해보세요</p>
					</div>
				</a>
			</div>

			<div class="carousel-item">
				<a href="?cmd=crewDetailUI&crewNumber=2"> <img
					src="image/riding.png" class="d-block w-100" alt="자전거 라이딩 모임">
					<div class="carousel-caption d-none d-md-block">
						<h2>매주 주말 정기 라이딩</h2>
						<p>초보자부터 전문가까지 모두 함께하는 라이딩 모임</p>
					</div>
				</a>
			</div>
		</div>

		<button class="carousel-control-prev" type="button"
			data-bs-target="#mainCarousel" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#mainCarousel" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<!-- 메인 콘텐츠 영역 -->
	<main class="container py-5"> <!-- 번개 모임 섹션 -->
	<section class="mb-5">
		<div class="section-title">
			<span class="lightning-icon">⚡</span>
			<h2 class="fs-4 mb-0">번개 모임</h2>
		</div>

		<div class="card-carousel-container">
			<div id="flashMobCarousel" class="carousel slide card-carousel">
				<div class="carousel-inner">
					<%
                    // 직접 서비스 메소드 호출
                    SqlSession dbSession = DBCP.getSqlSessionFactory().openSession();
                    FlashMobService flashMobService = new FlashMobService(new FlashMobDAO(dbSession));
                    List<FlashMobMainViewVO> flashMobList = flashMobService.getAllFlashMobs();
                    
                    // 리스트가 null이면 빈 리스트로 초기화
                    if (flashMobList == null) {
                      flashMobList = new ArrayList<>();
                    }
                    
                    // 4개씩 그룹화하여 슬라이드 생성
                    int totalFlashMobSlides = (int) Math.ceil(flashMobList.size() / 4.0);
                    
                    for (int slideIndex = 0; slideIndex < totalFlashMobSlides; slideIndex++) {
                      // 현재 슬라이드에 표시할 카드 인덱스 계산
                      int startIdx = slideIndex * 4;
                      int endIdx = Math.min(startIdx + 4, flashMobList.size());
                    %>
					<div class="carousel-item <%= slideIndex == 0 ? "active" : "" %>">
						<div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
							<% 
                      for (int i = startIdx; i < endIdx; i++) {
                        // FlashMobMainViewVO 객체 가져오기
                        Object flashMobObj = flashMobList.get(i);
                        
                        // 리플렉션을 사용하여 필드 값 가져오기
                        int flashMobNumber = (int) flashMobObj.getClass().getMethod("getFlashMobNumber").invoke(flashMobObj);
                        String title = (String) flashMobObj.getClass().getMethod("getTitle").invoke(flashMobObj);
                        String content = (String) flashMobObj.getClass().getMethod("getContent").invoke(flashMobObj);
                        String interestCategory = (String) flashMobObj.getClass().getMethod("getInterestCategory").invoke(flashMobObj);
                        String guName = (String) flashMobObj.getClass().getMethod("getGuName").invoke(flashMobObj);
                        int participantCount = (int) flashMobObj.getClass().getMethod("getParticipantCount").invoke(flashMobObj);
                        int maxMember = (int) flashMobObj.getClass().getMethod("getMaxMember").invoke(flashMobObj);
                   
                        Date meetingDate = (Date) flashMobObj.getClass().getMethod("getMeetingDate").invoke(flashMobObj);
                        String image = (String) flashMobObj.getClass().getMethod("getImage").invoke(flashMobObj);
                        
                        // 날짜 포맷팅
                        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
                        String formattedDate = sdf.format(meetingDate);
                    %>
							<div class="col">
								<a
									href="controller?cmd=flashMobDetailUI&flashMobNumber=<%= flashMobNumber %>"
									class="custom-card">
									<div class="card-icon">
										<img src="<%= image != null ? image : "image/flash.png" %>"
											alt="번개 아이콘">
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
                                      <path
																d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z" />
                                    </svg>
													</div>
													<span><%= guName %></span>
												</div>
												<div class="meta-item">
													<div class="meta-icon people">
														<svg xmlns="http://www.w3.org/2000/svg" width="16"
															height="16" fill="currentColor" class="bi bi-people-fill"
															viewBox="0 0 16 16">
                                      <path
																d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" />
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
						</div>
					</div>
					<% } %>

					<% if (flashMobList.isEmpty()) { %>
					<div class="carousel-item active">
						<div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
							<div class="col">
								<div class="custom-card">
									<div class="card-content text-center py-5">
										<p>번개 모임이 없습니다.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<% } %>
				</div>

				<% if (flashMobList.size() > 4) { %>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#flashMobCarousel" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#flashMobCarousel" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>

				<div class="carousel-indicators">
					<% for (int i = 0; i < totalFlashMobSlides; i++) { %>
					<button type="button" data-bs-target="#flashMobCarousel"
						data-bs-slide-to="<%= i %>"
						<%= i == 0 ? "class=\"active\" aria-current=\"true\"" : "" %>
						aria-label="Slide <%= i + 1 %>"></button>
					<% } %>
				</div>
				<% } %>
			</div>
		</div>
	</section>

	<!-- 크루룽 섹션 -->
	<section class="mb-5">
		<div class="section-title">
			<span class="lightning-icon">⚡</span>
			<h2 class="fs-4 mb-0">크루룽</h2>
		</div>

		<div class="card-carousel-container">
			<div id="crewCarousel" class="carousel slide card-carousel">
				<div class="carousel-inner">
					<%
                    // 직접 서비스 메소드 호출
                    CrewService crewService = new CrewService(new CrewDAO(dbSession));
                    List<AllCrewVO> crewList = crewService.getAllCrews();
                    
                    // 리스트가 null이면 빈 리스트로 초기화
                    if (crewList == null) {
                      crewList = new ArrayList<>();
                    }
                    
                    // 4개씩 그룹화하여 슬라이드 생성
                    int totalCrewSlides = (int) Math.ceil(crewList.size() / 4.0);
                    
                    for (int slideIndex = 0; slideIndex < totalCrewSlides; slideIndex++) {
                      // 현재 슬라이드에 표시할 카드 인덱스 계산
                      int startIdx = slideIndex * 4;
                      int endIdx = Math.min(startIdx + 4, crewList.size());
                    %>
					<div class="carousel-item <%= slideIndex == 0 ? "active" : "" %>">
						<div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
							<% 
                  for (int i = startIdx; i < endIdx; i++) {
                    // AllCrewVO 객체 가져오기
                    Object crewObj = crewList.get(i);
                    
                    // 리플렉션을 사용하여 필드 값 가져오기
                    int crewNumber = (int) crewObj.getClass().getMethod("getCrewNumber").invoke(crewObj);
                    String crewName = (String) crewObj.getClass().getMethod("getCrewName").invoke(crewObj);
                    String introduction = (String) crewObj.getClass().getMethod("getIntroduction").invoke(crewObj);
                    String interestCategory = (String) crewObj.getClass().getMethod("getInterestCategory").invoke(crewObj);
                    String guName = (String) crewObj.getClass().getMethod("getGuName").invoke(crewObj);
                    int crewMembersCount = (int) crewObj.getClass().getMethod("getCrewMembersCount").invoke(crewObj);
                    String image = (String) crewObj.getClass().getMethod("getImage").invoke(crewObj);
                %>
							<div class="col">
								<a href="?cmd=crewDetailUI&crewNumber=<%= crewNumber %>"
									class="custom-card">
									<div class="card-icon">
										<img src="<%= image != null ? image : "image/golf.png" %>"
											alt="<%= crewName %>">
									</div>
									<div class="card-content">
										<div class="card-title"><%= crewName %></div>
										<div class="card-subtitle"><%= introduction %></div>
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
                                  <path
																d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z" />
                                </svg>
													</div>
													<span><%= guName %></span>
												</div>
												<div class="meta-item">
													<div class="meta-icon people">
														<svg xmlns="http://www.w3.org/2000/svg" width="16"
															height="16" fill="currentColor" class="bi bi-people-fill"
															viewBox="0 0 16 16">
                                  <path
																d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7Zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216ZM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z" />
                                </svg>
													</div>
													<span>멤버 <%= crewMembersCount %>명
													</span>
												</div>
											</div>
											<div class="meta-right">활동중</div>
										</div>
									</div>
								</a>
							</div>
							<% } %>
						</div>
					</div>
					<% } %>

					<% if (crewList.isEmpty()) { %>
					<div class="carousel-item active">
						<div class="row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4">
							<div class="col">
								<div class="custom-card">
									<div class="card-content text-center py-5">
										<p>크루가 없습니다.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<% } %>
				</div>

				<% if (crewList.size() > 4) { %>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#crewCarousel" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#crewCarousel" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>

				<div class="carousel-indicators">
					<% for (int i = 0; i < totalCrewSlides; i++) { %>
					<button type="button" data-bs-target="#crewCarousel"
						data-bs-slide-to="<%= i %>"
						<%= i == 0 ? "class=\"active\" aria-current=\"true\"" : "" %>
						aria-label="Slide <%= i + 1 %>"></button>
					<% } %>
				</div>
				<% } %>
			</div>
		</div>
	</section>
	</main>

	<!-- 푸터 -->
	<%@ include file="footer.jsp" %>

	<!-- 캐러셀 자동 재생 스크립트 -->
	<script>
    document.addEventListener('DOMContentLoaded', function() {
      // 메인 캐러셀 설정
      var mainCarousel = new bootstrap.Carousel(document.getElementById('mainCarousel'), {
        interval: 5000,
        wrap: true
      });
      
      // 번개모임 캐러셀 설정
      var flashMobCarousel = document.getElementById('flashMobCarousel');
      if (flashMobCarousel) {
        new bootstrap.Carousel(flashMobCarousel, {
          interval: false,
          wrap: true
        });
      }
      
      // 크루 캐러셀 설정
      var crewCarousel = document.getElementById('crewCarousel');
      if (crewCarousel) {
        new bootstrap.Carousel(crewCarousel, {
          interval: false,
          wrap: true
        });
      }
    });
  </script>

	<%
  // 세션 닫기
  dbSession.close();
  %>
</body>
</html>