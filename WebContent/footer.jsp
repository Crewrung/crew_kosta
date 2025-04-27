<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
/* 푸터 스타일 */
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
    text-align: left;
    border-left: 1px solid #ddd;
    padding-left: 20px;
}
</style>

<!-- 푸터 -->
<footer>
    <div class="footer-content">
        <!-- 왼쪽 열 - 회사 정보 -->
        <div class="footer-left">
            <div>Corporate Name: 주식회사 크루 Owner: 김훈희 Business License: 234-18-4251</div>
            <div>E-commerce Registration: 2022-서울강남-02241 Phone: 1533 KR(Kakao only) Contact Mail: Biz.at@gmail.com</div>
            <div>Address: 서울특별시 강남구 테헤란로 51길(역삼동) AB Personal Information Manager: 김도기 (info@gmail.com)</div>
            <div class="footer-copyright">© LIGHTNING CO., LTD. ALL RIGHTS RESERVED.</div>
        </div>

        <!-- 오른쪽 열 - CS Center 정보 -->
        <div class="footer-right">
            <div>CS Center: 1588-4321</div>
            <div>10:00AM - 7:00PM (Lunch 12:30 - 13:30)</div>
            <div>Sat/Sun/Holiday CLOSED</div>
        </div>
    </div>
</footer>