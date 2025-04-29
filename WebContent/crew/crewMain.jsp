<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>컴리드 - 크루 메인</title>

<!-- CSS 여러 가져오기 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard-dynamic-subset.min.css"
	rel="stylesheet" crossorigin="anonymous">

<style>
/* 스타일 정의 */
body {
	background-color: #f9f9f9;
	font-family: 'Pretendard', sans-serif;
}

.card {
	transition: transform 0.2s;
}

.card:hover {
	transform: translateY(-5px);
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.innerImage {
	width: 100%;
	height: 200px;
	object-fit: cover;
}

.card-img-container {
	height: 200px;
	overflow: hidden;
}

.card-text {
	overflow: hidden;
	text-overflow: ellipsis;
	display: -webkit-box;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	max-height: 3em;
}
</style>
</head>
<body>
	<!-- Header -->
	<%@ include file="../header.jsp"%>

	<!-- 필터 영역 + 크루 생성하기 버튼 -->
	<div class="container my-4">
		<div class="row mb-4 align-items-end">
			<!-- 필터 세트 -->
			<div class="col-md-9">
				<div class="row">
					<div class="col-md-4">
						<select id="interestCategory" class="form-select">
							<option value="">전체</option>
							<option value="여행">여행</option>
							<option value="취미">취미</option>
							<option value="스터디">스터디</option>
							<!-- 필요시 추가 -->
						</select>
					</div>
					<div class="col-md-4">
						<select id="guName" class="form-select">
							<option value="">지역 선택</option>
							<option value="마포구">마포구</option>
							<!-- 필요시 추가 -->
						</select>
					</div>
					<div class="col-md-4">
						<select id="ageRange" class="form-select">
							<option value="">연령대</option>
							<option value="10대">10대</option>
							<!-- 필요시 추가 -->
						</select>
					</div>
				</div>
			</div>

			<!-- 크루 생성 버튼 -->
			<div class="col-md-3 text-end">
			<!-- 수정된 크루 생성하기 버튼 -->
<a href="<%= request.getContextPath() %>/controller?cmd=addCrewUI" class="btn btn-dark">크루 생성하기</a>
			</div>
		</div>
	</div>

	<!-- 크루 카드 리스트 -->
	<div class="container">
		<div class="row g-4" id="crewCardsContainer"></div>
	</div>

	<!-- Footer -->
	<!-- 푸터 -->
	<%@ include file="../footer.jsp"%>

	<!-- JavaScript -->
	<script>
  document.addEventListener('DOMContentLoaded', function() {
    var interestCategorySelect = document.getElementById('interestCategory');
    var guNameSelect = document.getElementById('guName');
    var ageRangeSelect = document.getElementById('ageRange');

    function loadCrewCards() {
    	  var interestCategory = interestCategorySelect.value;
    	  var guName = guNameSelect.value;
    	  var ageRange = ageRangeSelect.value;

    	  var params = new URLSearchParams();
    	  params.append("interestCategory", interestCategory);
    	  params.append("guName", guName);
    	  params.append("ageRange", ageRange);

    	  fetch("<%= request.getContextPath() %>/controller?cmd=crewFilter&" + params.toString())
    	    .then(function(response) {
    	      if (!response.ok) {
    	        throw new Error('네트워크 응답 오류');
    	      }
    	      var contentType = response.headers.get('Content-Type');
    	      if (!contentType || !contentType.includes('application/json')) {
    	        throw new Error('응답이 JSON 형식이 아닙니다.');
    	      }
    	      return response.json();
    	    })
    	    .then(function(data) {
    	      console.log(data);
    	      var container = document.getElementById('crewCardsContainer');
    	      container.innerHTML = '';

    	      if (data.length === 0) {
    	        container.innerHTML = '<div class="col-12"><p class="text-center my-5">검색 결과가 없습니다.</p></div>';
    	        return;
    	      }

    	      for (var i = 0; i < data.length; i++) {
    	        var crew = data[i];
    	        var crewNumber = crew.crewNumber || '';
    	        var introduction = crew.introduction || '';
    	        var image = crew.image ? crew.image : '<%=request.getContextPath()%>/image/placeholder.png';
    	        var crewName = crew.crewName || '';
    	        var interestCat = crew.interestCategory || '';
    	        var guNameVal = crew.guName || '';
    	        var memberCount = crew.crewMembersCount || 0;

    	        var cardHtml = '<div class="col-md-6 col-lg-3">' +
    	          '<div class="card h-100 border" style="cursor:pointer;" data-crew-number="' + crewNumber + '">' +
    	            '<div class="card-img-container">' +
    	              '<img src="' + image + '" alt="' + crewName + '" class="innerImage">' +
    	            '</div>' +
    	            '<div class="card-body p-3">' +
    	              '<h5 class="card-title fw-bold mb-2">' + crewName + '</h5>' +
    	              '<p class="card-text small">' + introduction + '</p>' +
    	              '<div class="d-flex align-items-center mt-3">' +
    	                '<span class="badge rounded-pill bg-light text-dark me-2">' + interestCat + '</span>' +
    	                '<span class="text-muted mx-2">|</span>' +
    	                '<span class="small">' + guNameVal + '</span>' +
    	                '<span class="text-muted mx-2">|</span>' +
    	                '<div class="d-flex align-items-center participant-count">' +
    	                  '<i class="bi bi-people-fill me-1"></i>' +
    	                  '<span>' + memberCount + '명</span>' +
    	                '</div>' +
    	              '</div>' +
    	            '</div>' +
    	          '</div>' +
    	        '</div>';

    	        container.innerHTML += cardHtml;
    	      }
    	    }, function(error) {
    	      console.error('크루 목록 불러오기 실패:', error);
    	      var container = document.getElementById('crewCardsContainer');
    	      container.innerHTML = '<div class="col-12"><p class="text-center my-5 text-danger">데이터를 불러오지 못했습니다: ' + error.message + '</p></div>';
    	    });
    	}


    // 이벤트 리스너 연결
    interestCategorySelect.addEventListener('change', loadCrewCards);
    guNameSelect.addEventListener('change', loadCrewCards);
    ageRangeSelect.addEventListener('change', loadCrewCards);

    // 초기 데이터 로딩
    loadCrewCards();
    
 // 카드 클릭 이벤트: 크루 상세 페이지 이동
    document.addEventListener('click', function(event) {
      var card = event.target.closest('.card');
      if (card && card.hasAttribute('data-crew-number')) {
        var crewNumber = card.getAttribute('data-crew-number');
        if (crewNumber) {
          location.href = '<%= request.getContextPath() %>/controller?cmd=crewDetailUI&crewNumber=' + crewNumber;
        }
      }
    });
  });
  </script>
</body>
</html>