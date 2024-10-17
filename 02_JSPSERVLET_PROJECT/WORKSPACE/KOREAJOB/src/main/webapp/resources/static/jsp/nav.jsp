<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
			<nav class=layout-150>
				<div class="left">
					<div class="sitemenu">
						<a href="${pageContext.request.contextPath}/">
							<span class="material-symbols-outlined">home</span>
						</a>
					</div>
					<div class="logo">
						<img src="${pageContext.request.contextPath}/resources/static/assets/logo_2.png" alt="logo" />
					</div>	
					<div class="search">
						<form action="">
							<input type="text" class="form-control w-100" placeholder="검색할 KEYWORD를 입력하세요." />
						</form>
					</div>
					
				</div>
				<div class="right">
					<ul class=menu>

						<li>
							<a href="">채용정보</a>
						</li>
						<li>
							<a href="">신입|인턴</a>
						</li>
						<li>
							<a href="">기업|연봉</a>
						</li>
						<li>
							<a href="">커뮤니티</a>
						</li>																																																									
					</ul>
				</div>
			</nav>	