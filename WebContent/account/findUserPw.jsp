<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기 - 크루룽</title>
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
        }
        
        .page-title {
            text-align: center;
            margin-bottom: 30px;
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
        }
        
        input, select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 14px;
        }
        
        input:focus, select:focus {
            outline: none;
            border-color: #666;
        }
        
        .submit-btn {
            width: 100%;
            padding: 12px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            font-weight: 500;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        
        .submit-btn:hover {
            background-color: #555;
        }
        
        .links {
            margin-top: 20px;
            text-align: center;
        }
        
        .links a {
            color: #666;
            text-decoration: none;
            margin: 0 10px;
            font-size: 14px;
        }
        
        .links a:hover {
            text-decoration: underline;
        }
        
        .error-message {
            color: #e74c3c;
            font-size: 14px;
            margin-top: 5px;
            display: none;
        }
    </style>
</head>
<body>
    <!-- 헤더 포함 -->
    <jsp:include page="/header.jsp" />
    
    <main>
    
    
    
    <div class="container">
        <h1 class="page-title">비밀번호 찾기</h1>
        
        <form action="/kosta/controller?cmd=findUserPwAction" method="post" id="findIdForm">
            <input type="hidden" name="cmd" value="findIdAction">
            
           	<div class="form-group">
                <label for="userId">아이디</label>
                <input type="text" id="userId" name="userId" placeholder="아이디를 입력하세요" required>
            </div>
            
            <div class="form-group">
                <label for="email">이메일</label>
                <input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required>
                <div id="emailError" class="error-message">유효한 이메일 주소를 입력해주세요.</div>
            </div>
            

            
            <button type="submit" class="submit-btn">비밀번호 찾기</button>
        </form>
    </div>
    
        <c:if test="${not empty errorMsg}">
        <div style="color: red; font-weight: bold;">
            ${errorMsg}
        </div>
    </c:if>
    
    <!-- 푸터 포함 -->
    <jsp:include page="/footer.jsp" />
    </main>
    
    <script>
        // 이메일 유효성 검사
        const emailInput = document.getElementById('email');
        const emailError = document.getElementById('emailError');
        const form = document.getElementById('findIdForm');
        
        form.addEventListener('submit', function(e) {
            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            
            if (!emailPattern.test(emailInput.value)) {
                emailError.style.display = 'block';
                e.preventDefault();
            } else {
                emailError.style.display = 'none';
            }
        });
        
        emailInput.addEventListener('input', function() {
            emailError.style.display = 'none';
        });
    </script>
</body>
</html>
