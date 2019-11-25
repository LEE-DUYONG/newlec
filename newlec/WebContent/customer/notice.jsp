<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<jsp:include page="../includes/header.jsp" />
			<!-- end header -->
			<div id="content">
				<h2>공지사항</h2>
				<h3 class="hidden">방문페이지 로그</h3>
				<ul id="breadscrumb" class="block_hlist clear">
					<li>HOME</li>
					<li>고객센터</li>
					<li>공지사항목록</li>
				</ul>
				<h3 class="hidden">공지사항 목록</h3>
				<form id="content-searchform" class="article-search-form"
					action="notice.yjc?page=${pageVO.curPage}" method="get">
					<fieldset>
						<legend class="hidden"> 목록 검색 폼 </legend>
						<!-- <input type="hidden" name="pg" value="" /> -->
						<label for="f" class="hidden">검색필드</label>
						<select name="f">
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
						</select>
						<label class="hidden" for="q">검색어</label>
						<input type="text" name="q" value="${q}" />
						<input type="submit" value="검색" />
					</fieldset>
				</form>
				<table class="article-list margin-small">
					<caption class="hidden">공지사항</caption>
					<thead>
						<tr>
							<th class="seq">번호</th>
							<th class="title">제목</th>
							<th class="writer">작성자</th>
							<th class="regdate">작성일</th>
							<th class="hit">조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="notice" items="${noticeList}" varStatus="status">
						    <tr>
								<td class="seq">${notice.num}</td>
								<td class="title"><a href="noticeDetail.yjc?page=${pageVO.curPage}&contentNum=${notice.num}&f=${f}&q=${q}">${notice.title}</a></td>
								<td class="writer">${notice.memberId}</td>
								<td class="regdate">${notice.createdDate}</td>
								<td class="hit">${notice.hit}</td>
						    </tr>
					    </c:forEach>
					</tbody>
				</table>
				<p class="article-comment margin-small">
					<c:choose>
						<c:when test="${empty sessionScope.loginDTO.userName}">
							<a class="btn-write button" href="" onclick="alert('로그인을 해주세요.');return false;"></a>
						</c:when>
						<c:otherwise>
							<a class="btn-write button" href="noticeReg.yjc?page=${pageVO.curPage}&f=${f}&q=${q}"></a>
						</c:otherwise>
					</c:choose>
				</p>
				<p id="cur-page" class="margin-small">
					<span class="strong">${pageVO.curPage}</span> / ${pageVO.totalPage} page
				</p>
				<div id="pager-wrapper" class="margin-small">
					<div class="pager clear">
						<c:choose>
							<c:when test="${pageVO.curPage == 1}"></c:when>
							<c:otherwise>
								<p id="btnPrev">
									<a class="button btn-prev" href="notice.yjc?page=${pageVO.curPage-1}">이전</a>
								</p>
							</c:otherwise>
						</c:choose>
						<ul>
							<c:forEach var="i" begin="${pageVO.startPage}" end="${pageVO.lastPage}" step="1" >
								<li><a class="strong" href="notice.yjc?page=${i}&f=${f}&q=${q}">${i}</a></li>
							</c:forEach>
						</ul>
						<c:choose>
							<c:when test="${pageVO.curPage == pageVO.totalPage}"></c:when>
							<c:otherwise>
								<p id="btnNext">
									<a class="button btn-next" href="notice.yjc?page=${pageVO.curPage+1}&f=${f}&q=${q}">다음</a>
								</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<!-- start footer -->
			<jsp:include page="../includes/footer.jsp" />
