<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String userId = (String) session.getAttribute("userId");
    if (userId == null) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/account/login.jsp");
        dispatcher.forward(request, response);
        return;
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css" />
  <title>크루룽</title>
  <style>
    /* 기본 리셋 */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
    
    body {
      font-family: "Pretendard Variable", Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
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
      max-width: 40%;
      align-items: center;
      margin: 0 auto;
      padding: 20px;
    }
    
    /* 메인 콘텐츠 내부 빈 컨테이너 스타일 */
    .content-container {
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 1px 3px rgba(0,0,0,0.1);
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
    <!-- 여기까지가 공통 css-->

    .mypage-container {
            display: flex;
            justify-content: center;
            background-color: #f5f5f5;
            padding: 20px;
            width: 30px;
            background-color: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
      }

      .mypage-container .header {
          text-align: center;
          padding: 20px;
          font-size: 20px;
          font-weight: bold;
          border-bottom: 1px solid #eee;
      }

     .profile {
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }
        
.profile-image {
    width: 120px;
    height: 120px;
    background-color: #f0e6ff;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 20px;
}
        
  .profile-icon {
    width: 100px;  /* 크기 조정 */
    height: 100px;  /* 크기 조정 */
    border: 4px solid #6b4aa0;
    border-radius: 50%;
    position: relative;
    overflow: hidden;  /* 이미지가 잘리지 않도록 */
}
.profile-icon img {
    width: 100%;
    height: 100%;
    object-fit: cover;  /* 이미지가 원형 영역에 맞게 비율을 유지하며 채워지도록 */
}
        
        .profile-icon::after {
            content: "";
            position: absolute;
            width: 100%;
            height: 50%;
            border-radius: 100px 100px 0 0;
            background-color: #6b4aa0;
            bottom: -20px;
            left: 0;
        }
        
        .profile-info {
            text-align: center;
            width: 100%;
        }
        
        .profile-name {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }
        
        .profile-email, .profile-phone {
            color: #666;
            margin-bottom: 5px;
            font-size: 14px;
        }
        
        .profile-greeting {
            margin: 15px 0;
            color: #333;
            font-size: 14px;
        }
        
        .section {
            margin: 10px 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            overflow: hidden;
        }
        
        .section-header {
            background-color: #3c4043;
            color: white;
            padding: 10px 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        
        .section-content {
            padding: 15px;
        }
        
        .group-item {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px solid #eee;
        }
        
        .group-item:last-child {
            border-bottom: none;
        }
        
        .status {
            padding: 3px 8px;
            border-radius: 3px;
            font-size: 12px;
            color: white;
        }
        
        .status-green {
            background-color: #a3d977;
        }
        
        .status-red {
            background-color: #e88a8a;
        }
        
        .arrow-down {
            width: 0;
            height: 0;
            border-left: 6px solid transparent;
            border-right: 6px solid transparent;
            border-top: 6px solid white;
        }
        
        .buttons {
            display: flex;
            justify-content: space-between;
            padding: 20px;
        }
        
        .btn {
            padding: 10px 15px;
            border: 1px solid #ddd;
            background-color: white;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            width: 48%;
            text-align: center;
        }
    
  </style>
</head>
<body>
  <!-- 헤더 -->
	<%@ include file="/header.jsp" %>
  
  <!-- 메인 콘텐츠 영역 - 양 옆 간격 설정과 빈 컨테이너 -->
<main>
   <div class="mypage-container">
        <div class="header">마이페이지</div>
        
        <div class="profile">
            <div class="profile-image">
                <div class="profile-icon">
                    <!-- 프로필 이미지가 비어 있으면 default.png로 대체 -->
                    <img src="image/${empty mypage.profileImage ? 'default.png' : mypage.profileImage}" style="width:150px; height:150px; border-radius:50%;">
                </div>
            </div>
            
            <div class="profile-info">
                <div class="profile-name">${mypage.nickname}님</div>
                <div class="profile-email">${mypage.email}</div>
                <div class="profile-phone">${mypage.phoneNumber}</div>
                <div class="profile-greeting">${mypage.introduction}</div>
            </div>
        </div>
        
        <div class="section">
            <div class="section-header">
                <span>그룹 조회</span>
                <span class="arrow-down"></span>
            </div>
            <div class="section-content">
                <c:choose>
                    <c:when test="${not empty mypage.crewNames}">
                        <c:forEach var="crew" items="${mypage.crewNames}">
                            <div class="group-item">
                                <span>${crew}</span>
                                <span>
                                    <a href="/crew/crewDetail.jsp?crewName=${crew}">
                                        <button>크루 페이지</button>
                                    </a>
                                </span>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="group-item">가입한 크루가 없습니다.</div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        
        <div class="section">
            <div class="section-header">
                <span>모임 조회</span>
                <span class="arrow-down"></span>
            </div>
            <div class="section-content">
                <c:choose>
                    <c:when test="${not empty mypage.flashMobTitles}">
                        <c:forEach var="mob" items="${mypage.flashMobTitles}">
                            <div class="group-item">
                                <span>${mob}</span>
                                <span>
                                    <a href="/flashmob/flashmobDetail.jsp?title=${mob}">
                                        <button>모임 페이지</button>
                                    </a>
                                </span>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <div class="group-item">참여한 모임이 없습니다.</div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        
        <div class="buttons">
            <div class="btn">
                <a href="/kosta/controller?cmd=removeUserUIAction" style="text-decoration:none; color:inherit;">회원탈퇴</a>
            </div>
            <div class="btn">
                <a href="/kosta/controller?cmd=userUpdateInfoUIAction" style="text-decoration:none; color:inherit;">개인정보 수정</a>
            </div>
        </div>
    </div> 
</main>
  
<%@ include file="/footer.jsp" %>

</body>
</html>