<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>크루 상세 보기</title>
</head>
<body>

<h1>크루 상세 정보</h1>

<div>
    <h2>${crewDetail.crewName}</h2>
    <p>${crewDetail.introduction}</p>
    <p>관심사: ${crewDetail.interestCategory}</p>
    <p>모임 지역: ${crewDetail.guName}</p>
    <p>현재 인원수: ${crewDetail.crewMembersCount}명</p>

    <c:if test="${not empty crewDetail.image}">
        <img src="${crewDetail.image}" alt="${crewDetail.crewName}" style="max-width:300px;">
    </c:if>
</div>

<a href="/controller?cmd=crewUI">목록으로 돌아가기</a>

</body>
</html>
