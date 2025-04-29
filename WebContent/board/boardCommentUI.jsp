<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- ... 댓글 리스트 출력 ... -->

<div class="pagination">
  <c:if test="${currentPage > 1}">
    <a href="${pageContext.request.contextPath}/controller?
              cmd=boardCommentUI
              &amp;boardNumber=${board.boardNumber}
              &amp;page=${currentPage - 1}">
      ◀ 이전
    </a>
  </c:if>

  <c:forEach var="i" begin="1" end="${totalPages}">
    <c:choose>
      <c:when test="${i == currentPage}">
        <span class="current">${i}</span>
      </c:when>
      <c:otherwise>
        <a href="${pageContext.request.contextPath}/controller?
                  cmd=boardCommentUI
                  &amp;boardNumber=${board.boardNumber}
                  &amp;page=${i}">
          ${i}
        </a>
      </c:otherwise>
    </c:choose>
  </c:forEach>

  <c:if test="${currentPage < totalPages}">
    <a href="${pageContext.request.contextPath}/controller?
              cmd=boardCommentUI
              &amp;boardNumber=${board.boardNumber}
              &amp;page=${currentPage + 1}">
      다음 ▶
    </a>
  </c:if>
</div>
