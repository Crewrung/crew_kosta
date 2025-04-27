<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String message = request.getParameter("message");
    String redirectUrl = request.getParameter("redirectUrl");

    if (message == null) {
        message = "처리가 완료되었습니다.";
    }
    if (redirectUrl == null) {
        redirectUrl = "/"; // 기본은 메인으로
    }
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>알림</title>
    <script type="text/javascript">
        alert("<%= message %>");
        window.location.href = "<%= redirectUrl %>";
    </script>
</head>
<body>
</body>
</html>
