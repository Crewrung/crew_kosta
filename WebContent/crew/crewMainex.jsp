<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><title>\u크루룽 - 크루 메인<title>\u크루룽 - 크루 메인\u</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css" />

<style>
/* 스타일은 그대로 유지 */
* { margin: 0; padding: 0; box-sizing: border-box; }
body { font-family: "Pretendard Variable", Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI", "Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic", "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif; background-color: #f9f9f9; }
header { display: flex; justify-content: space-between; align-items: center; padding: 15px 20px; background-color: #fff; position: relative; }
.header-divider { height: 1px; background-color: #ddd; width: 100%; position: absolute; bottom: 0; left: 0; }
.logo { display: flex; align-items: center; }
.logo img { width: 24px; height: 24px; margin-right: 8px; }
.logo-text { font-weight: bold; font-size: 18px; color: #000; }
nav ul { display: flex; list-style: none; gap: 200px; margin-bottom: 0; }
nav ul li a { text-decoration: none; color: #333; }
.user-actions { display: flex; align-items: center; }
.user-icon { width: 32px; height: 32px; border-radius: 50%; background-color: #f5f5f5; display: flex; align-items: center; justify-content: center; margin-right: 10px; }
.login-btn { background-color: #fff; border: 1px solid #ddd; border-radius: 20px; padding: 8px 16px; cursor: pointer; }
main { max-width: 1200px; margin: 0 auto; padding: 20px; }
.content-container { background-color: #fff; border-radius: 8px; box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1); padding: 20px; min-height: 400px; margin-bottom: 20px; }
footer { background-color: #f5f5f5; padding: 15px 20px; font-size: 12px; color: #666; line-height: 1.6; border-top: 1px solid #ddd; }
.footer-content { max-width: 1200px; margin: 0 auto; display: flex; justify-content: space-between; }
.footer-left, .footer-right { display: flex; flex-direction: column; gap: 5px; }
.footer-left { text-align: left; }
.footer-right { text-align: left; border-left: 1px solid #ddd; padding-left: 20px; }
.footer-copyright { margin-top: 5px; }
.innerImage { width: 100%; height: 100%; object-fit: cover; }
.card-img-container { height: 200px; overflow: hidden; display: flex; align-items: center; justify-content: center; border-bottom: 1px solid #eee; }
.card { transition: transform 0.2s; }
.card:hover { transform: translateY(-5px); box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
.participant-count { font-size: 0.85rem; }
</style>
</head>

<body>
<header>
  <div class="logo">
    <img src="image/logo.png" alt="크루룽 로고">
    <span class="logo-text">크루룽</span>
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
      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" viewBox="0 0 24 24">
        <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
        <circle cx="12" cy="7" r="4"></circle>
      </svg>
    </div>
    <button class="login-btn">로그인</button>
  </div>
  <div class="header-divider"></div>
</header>

<main>
<div class="container mb-5">
  <div class="row g-4" id="crewCardContainer">
    <!-- 여기서 서버 데이터로 동적 카드 생성 -->
  </div>
</div>
</main>

<footer>
  <div class="footer-content">
    <div class="footer-left">
      <div>Corporate Name: 주식회사 크루 Owner: 김훈희 Business License: 234-18-4251</div>
      <div>E-commerce Registration: 2022-서울강남-02241 Phone: 1533 KR (Kakao only) Contact Mail: Biz.at@gmail.com</div>
      <div>Address: 서울특별시 강남구 테헤란로 51길(역삼동) AB Personal Information Manager: 김도기 (info@gmail.com)</div>
      <div class="footer-copyright">© LIGHTNING CO., LTD. ALL RIGHTS RESERVED.</div>
    </div>
    <div class="footer-right">
      <div>CS Center: 1588-4321</div>
      <div>10:00AM - 7:00PM (Lunch 12:30 - 13:30)</div>
      <div>Sat/Sun/Holiday CLOSED</div>
    </div>
  </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
<script>
document.addEventListener("DOMContentLoaded", function() {
  loadCrewCards();

  function loadCrewCards() {
    fetch('/controller?cmd=crewListUI')
      .then(response => response.json())
      .then(data => {
        const container = document.getElementById('crewCardContainer');
        container.innerHTML = '';
        data.forEach(crew => {
          const cardHtml = `
            <div class="col-md-6 col-lg-3">
              <div class="card h-100 border">
                <div class="card-img-container">
                  <img src="${crew.image ? crew.image : 'image/placeholder.png'}" alt="${crew.crewName}" class="innerImage">
                </div>
                <div class="card-body p-3">
                  <h5 class="card-title fw-bold mb-2">${crew.crewName}</h5>
                  <p class="card-text small text-truncate">${crew.introduction}</p>
                  <div class="d-flex align-items-center mt-3">
                    <span class="badge rounded-pill bg-light text-dark me-2">${crew.interestCategory}</span>
                    <span class="text-muted mx-2">|</span>
                    <span class="small">${crew.guName}</span>
                    <span class="text-muted mx-2">|</span>
                    <div class="d-flex align-items-center participant-count">
                      <i class="bi bi-people-fill me-1"></i>
                      <span>${crew.crewMembersCount}명</span>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          `;
          container.insertAdjacentHTML('beforeend', cardHtml);
        });
      })
      .catch(error => console.error('크루 목록 불러오기 실패:', error));
  }
});
</script>

</body>
</html>
