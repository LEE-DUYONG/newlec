<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			<jsp:include page="../includes/header.jsp" />
			<!-- end header -->
<link href="${pageContext.request.contextPath}/joinus/join.css" type="text/css" rel="stylesheet" />
			<div id="content">
				<form action="joinProc.yjc" id="joinProcForm" method="post">
					<h2>회원가입</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<p id="breadscrumb" class="block_hlist clear">
						<img alt="Step1 개인정보 등록" src="${pageContext.request.contextPath}/joinus/images/step2.png" />
					</p>
					<h3 class="hidden">회원가입 폼</h3>
					<div id="join-form" class="join-form margin-large">
						<dl class="join-form-row">
							<dt class="join-form-title">아이디</dt>
							<dd class="join-form-data">
								<input type="text" id="uid" name="uid" />
								<input id="btnCheckUid" class="button" type="button" value="중복확인" />
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">비밀번호</dt>
							<dd class="join-form-data">
								<input type="password" id="pwd" name="pwd" />
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">비밀번호 확인</dt>
							<dd class="join-form-data">
								<input type="password" id="pwd2" name="pwd2" />
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">이름</dt>
							<dd class="join-form-data">
								<input type="text" id="name" name="name" />
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">성별</dt>
							<dd class="join-form-data">
								<select name="gender">
									<option value="M">남성</option>
									<option value="F">여성</option>
								</select>
							</dd>
						</dl>
						<dl class="join-form-row">
							<dt class="join-form-title">핸드폰 번호</dt>
							<dd class="join-form-data">
								<input type="text" name="cphone" />
								<span>[대시(-)를 포함할 것: 예) 010-3456-2934]</span>
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
					<input class="btn-okay button" id="joinProcSubmit" type="submit" value="가입" />
				</div>
			</div>
			<!-- start footer -->
			<jsp:include page="../includes/footer.jsp" />

<script type="text/javascript">
//아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )
var idck = 0;

//btnCheckUid 버튼을 클릭했을 때 
$("#btnCheckUid").click(function(){
//	alert("btnCheckUid");
/* 	alert($('#uid').val()); */
	console.log();
	$.ajax({
        url: 'joinIdCk.yjc',
        data: {
            uid : $('#uid').val()
        },
        type: 'post',
        dataType: "json",
		success : function(data) {
			// 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
//			alert("성공:"+data.result);
			if( "OK" == data.result ) {
				alert("사용 가능한 아이디입니다.");
				idck = 1;
			} else {
				alert("중복된 아이디입니다.");
//				$('#uid').val('');
			}
		},
		error:function(request,status,error){
			alert("실패");
			//  실패 처리
 			alert("code : " + request.status);
 			alert("message : " + request.responseText);
 			alert("error : " + error);
		},
		complete : function(data) {
			//  실패했어도 완료가 되었을 때 처리
//			alert("완료");
		}
	});
});

//btnCheckUid 버튼을 클릭했을 때 
$("#joinProcSubmit").click(function(){
	console.log();
	if( "0" == idck ) {
		alert("아이디 중복을 확인해주세요");
	} else if( "1" == idck ) {
		// 비밀번호 확인
		alert("pwd : " + $('#pwd').val() + " / pwd2 : " + $('#pwd2').val());
		if( $('#pwd').val() == $('#pwd2').val() ) {
			if( "" != $('#name').val() ) {
				// 회원가입 submit
				document.getElementById('joinProcForm').submit();
			} else {
				alert("이름의 빈칸을 채워주세요.");
			}
		} else{
			alert("비밀번호 확인이 다릅니다.");
		}
	} else {
		alert("idck이상:"+idck);
	}
});

</script>