<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Flash Mob List</title>
</head>
<body>
  <h2>번개 모임 목록</h2>
  <ul>
    <c:forEach var="mob" items="${flashMobList}">
      <li>${mob.title} - ${mob.content}</li>
    </c:forEach>
  </ul>
</body>
</html>
