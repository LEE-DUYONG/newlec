<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link href="index.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div id="header">
		<div class="top-wrapper">
			<h1 id="logo">
				<a href="index.yjc"><img src="${pageContext.request.contextPath}/images/logo.png" alt="뉴렉처" /></a>
			</h1>
			<h2 class="hidden">메인메뉴</h2>
			<ul id="mainmenu" class="block_hlist">
				<li><a href="">학습가이드</a></li>
				<li><a href="">과정선택</a></li>
				<li><a href="">인기과정</a></li>
			</ul>
			<form id="searchform" action="" method="get">
				<fieldset>
					<legend class="hidden"> 과정검색폼 </legend>
					<label for="query">과정검색</label> <input type="text" name="query" />
					<input type="submit" class="button" value="검색" />
				</fieldset>
			</form>
			<h3 class="hidden">로그인메뉴</h3>
			<ul id="loginmenu" class="block_hlist">
				<li><a href="index.yjc">HOME</a></li>
				<li><a href="login.yjc">로그인</a></li>
				<li><a href="join.yjc">회원가입</a></li>
			</ul>
			<h3 class="hidden">회원메뉴</h3>
			<ul id="membermenu" class="clear">
				<li><img src="${pageContext.request.contextPath}/images/menuMyPage.png" alt="마이페이지" /></li>
				<li><a href="notice.yjc"><img src="${pageContext.request.contextPath}/images/menuCustomer.png" alt="고객센터" /></a></li>
			</ul>
		</div>
	</div>
	<div id="visual">
		<div class="content-container">
			<h2 class="hidden">신규 강좌목록</h2>
			<!-- <ul class="mov-button">
				<li class="prev-button">이전</li>
				<li class="next-button">다음</li>
			</ul> -->
			<ul class="banner">
				<li class="banner1">
				</li>
			</ul>
			
			<ul class="banner-button-list" style="color:#ffff00; font-size:20px;position:absolute; left:10px; bottom:5px; z-index: 100px; display: flex; flex-direction: row;">			
				<li></li>			
			</ul>
		</div>
	</div>
	
	
	<div id="main">
	
	</div>
	<div id="footer">
		<div class="top-wrapper">
			<h2>
				<img src="images/footerLogo.png" alt="뉴렉처" />
			</h2>
			<p>
			<address id="ad">
				사업자등록번호 : 000-00-00000000 통신판매업신고 : 서울 0000-000 관리자 : 홍길동 <br /> 주소
				: 서울시 000구 001동 000-0 00빌딩 0층 전화 : 02-000-0000 팩스 : 02-000-0000
			</address>
			<p>Copyright ⓒ newlecture.com 2012-2012 All Right Reserved.
				Contact master@newlecture.com for more information</p>
		</div>
	</div>
</body>
</html>