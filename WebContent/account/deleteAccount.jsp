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

<%@ include file="/header.jsp" %>
<!-- 탈퇴 폼 시작 -->
<div class="content">
    <h2>회원 탈퇴</h2>
    <form action="controller?cmd=removeUserAction" method="post" onsubmit="return confirm('정말 탈퇴하시겠습니까?');">
        <div>
    	<label for="userId">아이디</label>
    	<input type="text" id="userId" name="userId"  value="<%= userId %>" disabled placeholder="아이디 입력">
        </div>
        <div>
            <label for="userPw">비밀번호: </label>
            <input type="password" id="userPw" name="userPw" required>
        </div>
        <div>
            <input type="submit" value="탈퇴하기">
        </div>
    </form>
</div>

<%@ include file="/footer.jsp" %>