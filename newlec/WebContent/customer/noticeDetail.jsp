<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<jsp:include page="../includes/header.jsp" />
			<!-- end header -->
			<div id="content">
				<h2>공지사항</h2>
				<h3 class="hidden">방문페이지위치</h3>
				<ul id="breadscrumb" class="block_hlist">
					<li id="home"><a href="">HOME</a></li>
					<li><a href="">고객센터</a></li>
					<li><a href="">공지사항</a></li>
				</ul>
				<div id="notice-article-detail" class="article-detail margin-large">
					<dl class="article-detail-row">
						<dt class="article-detail-title">제목</dt>
						<dd class="article-detail-data">${notice.title}</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">작성일</dt>
						<dd class="article-detail-data">${notice.createdDate}</dd>
					</dl>
					<dl class="article-detail-row half-row">
						<dt class="article-detail-title">작성자</dt>
						<dd class="article-detail-data half-data">${notice.memberId}</dd>
					</dl>
					<dl class="article-detail-row half-row">
						<dt class="article-detail-title">조회수</dt>
						<dd class="article-detail-data half-data">${notice.hit}</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">첨부파일</dt>
						<dd class="article-detail-data">
							<a href="">flag.png</a>
						</dd>
					</dl>

					<div class="article-content">
						${notice.content}
					</div>
				</div>
				<p class="article-comment margin-small">
					<a class="btn-list button" href="notice.yjc?page=1"></a>
					<a class="btn-edit button" href="noticeEdit.yjc?page=1&contentNum=${notice.num}"></a>
					<a class="btn-del button" href="noticeDel.yjc?page=1"></a>
				</p>
				<div class="margin-small" style="border-top: 1px solid #dfdfdf;">
					<dl class="article-detail-row">
						<dt class="article-detail-title">▲ 다음글</dt>
						<dd class="article-detail-data">
							<c:choose>
								<c:when test="${empty nextTitle}">
									다음 게시글이 없습니다.
								</c:when>
								<c:otherwise>
									${nextTitle}
								</c:otherwise>
							</c:choose>
						</dd>
					</dl>
					<dl class="article-detail-row">
						<dt class="article-detail-title">▼ 이전글</dt>
						<dd class="article-detail-data">
							<c:choose>
								<c:when test="${empty previousTitle}">
									이전 게시글이 없습니다.
								</c:when>
								<c:otherwise>
									${previousTitle}
								</c:otherwise>
							</c:choose>
						</dd>
					</dl>
				</div>
			</div>
						<!-- start footer -->
			<jsp:include page="../includes/footer.jsp" />