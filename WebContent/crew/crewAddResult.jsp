<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>크루 생성 결과</title>
</head>
<body>

<%
String errorMessage = (String) request.getAttribute("errorMessage");
String successMessage = (String) request.getAttribute("successMessage");
String redirectUrl = (String) request.getAttribute("redirectUrl");
if (errorMessage != null) {
%>
    <script>
        alert('<%= errorMessage %>');
        location.href = '<%= redirectUrl %>';
    </script>
<%
} else if (successMessage != null) {
%>
    <script>
        alert('<%= successMessage %>');
        location.href = '<%= redirectUrl %>';
    </script>
<%
}
%>

</body>
</html>
