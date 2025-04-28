<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기 결과 - 크루룽</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: 'Noto Sans KR', sans-serif;
            background-color: #f9f9f9;
            color: #333;
        }
        
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        
        .page-title {
            margin-bottom: 30px;
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }
        
        .success-icon {
            width: 60px;
            height: 60px;
            margin: 0 auto 20px;
            background-color: #4CAF50;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .success-icon svg {
            width: 30px;
            height: 30px;
            color: white;
        }
        
        .result-message {
            margin-bottom: 15px;
            font-size: 16px;
            color: #666;
        }
        
        .user-id {
            display: inline-block;
            margin: 20px 0;
            padding: 15px 30px;
            background-color: #f5f5f5;
            border-radius: 4px;
            font-size: 18px;
            font-weight: bold;
            letter-spacing: 1px;
        }
        
        .buttons {
            margin-top: 30px;
            display: flex;
            justify-content: center;
            gap: 15px;
        }
        
        .btn {
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            font-size: 15px;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        
        .primary-btn {
            background-color: #333;
            color: #fff;
        }
        
        .primary-btn:hover {
            background-color: #555;
        }
        
        .secondary-btn {
            background-color: #f5f5f5;
            color: #333;
            border: 1px solid #ddd;
        }
        
        .secondary-btn:hover {
            background-color: #eaeaea;
        }
        
        .note {
            margin-top: 25px;
            font-size: 14px;
            color: #888;
        }
    </style>
</head>
<body>
    <!-- 헤더 포함 -->
    <jsp:include page="/header.jsp" />
    
    <div class="container">
        <h1 class="page-title">아이디 찾기 결과</h1>
        
        <div class="success-icon">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <polyline points="20 6 9 17 4 12"></polyline>
            </svg>
        </div>
        
        <p class="result-message">
            입력하신 정보와 일치하는 아이디를 찾았습니다.
        </p>
        
        <div class="user-id">
            ${userId}
        </div>
        
        <p class="note">
        
            개인정보 보호를 위해 일부는 *로 표시됩니다.
        </p>
        
        <div class="buttons">
            <a href="/kosta/controller?cmd=loginUI">
                <button class="btn primary-btn">로그인하기</button>
            </a>
            <a href="/kosta/controller?cmd=findUserPwUI">
                <button class="btn secondary-btn">비밀번호 찾기</button>
            </a>
        </div>
    </div>
    
    <!-- 푸터 포함 -->
    <jsp:include page="/footer.jsp" />
</body>
</html>
