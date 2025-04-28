<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
/* 헤더 스타일 */
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
</style>

<!-- 헤더 -->
<header>
	<div class="logo">
		<a href="/crew_kosta"> <img src="image/logo.png" alt="크루룽 로고">
			<span class="logo-text">크루룽</span>
		</a>
	</div>

	<nav>
		<ul>
			<li><a href="controller?cmd=flashMobUI">번개 모임</a></li>
			<li><a href="controller?cmd=crewUI">크루</a></li>
			<li><a href="controller?cmd=boardsUI">자유게시판</a></li>
		</ul>
	</nav>

	<div class="user-actions">
		<a href="controller?cmd=mypageAction">
			<div class="user-icon" style="cursor: pointer;">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					viewBox="0 0 24 24" fill="none" stroke="currentColor"
					stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
      <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
      <circle cx="12" cy="7" r="4"></circle>
    </svg>
			</div>
		</a>
		<c:choose>
			<c:when test="${not empty sessionScope.userId}">
				<!-- 로그인 상태일 때 -->
				<p>안녕하세요, ${sessionScope.nickname}님!</p>
				<a href="/crew_kosta/controller?cmd=logoutAction">로그아웃</a>
				<!-- 로그아웃 버튼 -->
			</c:when>
			<c:otherwise>
				<!-- 로그아웃 상태일 때 -->
				<a href="/crew_kosta/controller?cmd=loginUI">로그인</a>
				<!-- 로그인 버튼 -->
			</c:otherwise>
		</c:choose>
	</div>

	<!-- 헤더 아래 구분선 추가 -->
	<div class="header-divider"></div>
</header>