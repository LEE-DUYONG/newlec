<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			<jsp:include page="../includes/header.jsp" />
			<!-- end header -->
<link href="${pageContext.request.contextPath}/joinus/join.css" type="text/css" rel="stylesheet" />
			<div id="content">
				<form action="" method="post">
					<h2>회원가입</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<p id="breadscrumb" class="block_hlist clear">
						<img alt="Step1 개인정보 등록" src="${pageContext.request.contextPath}/images/step2.png" />
					</p>
					<h3 class="hidden">회원가입 폼</h3>
					<div id="join-form" class="join-form margin-large">
						<dl class="join-form-row">
							<dt class="join-form-title">아이디</dt>
							<dd class="join-form-data">
								<input type="text" name="uid" /> <input id="btnCheckUid" class="button" type="button" value="중복확인" />
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">비밀번호</dt>
							<dd class="join-form-data">
								<input type="password" name="pwd" />
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">비밀번호 확인</dt>
							<dd class="join-form-data">
								<input type="password" name="pwd2" />
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">이름</dt>
							<dd class="join-form-data">
								<input type="text" name="name" />
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">성별</dt>
							<dd class="join-form-data">
								<select name="gender">
									<option>남성</option>
									<option>여성</option>
								</select>
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">핸드폰 번호</dt>
							<dd class="join-form-data">
								<input type="text" name="cphone" /><span>[대시(-)를 포함할 것:
									예) 010-3456-2934]</span>
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">이메일</dt>
							<dd class="join-form-data">
								<input type="text" name="email" />
							</dd>
						</dl>
						
					</div>
				</form>
				<div id="buttonLine">
					<input class="btn-okay button" type="submit" value="가입" />
				</div>
			</div>
			<!-- start footer -->
			<jsp:include page="../includes/footer.jsp" />
