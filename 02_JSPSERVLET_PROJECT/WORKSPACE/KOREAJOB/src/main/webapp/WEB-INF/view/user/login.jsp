<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- link  -->
	<%@ include file="/resources/static/jsp/link.jsp" %>
	
	<!-- common.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/common.css" />
	
	<!-- login.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/user/login.css" />
		
	<!-- user/myinfo.css -->
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/common.css" /> --%>
	
	<!-- common.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/common.js" defer></script>
	
	<!-- user/login.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/user/login.js" defer></script>
</head>

<body>
	
	<div class="wrapper">
		<header>
			
			<!-- top-header -->
			<%@ include file="/resources/static/jsp/topHeader.jsp" %>
			<!-- nav -->
			<%@ include file="/resources/static/jsp/nav.jsp" %>

		</header>
       	
       	
       	<main class="layout-150">
       		
 
       		
            <section class=breadcrum-block>
	            <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="#">HOME</a></li>
				    <li class="breadcrumb-item active" aria-current="page">LOGIN</li>
				  </ol>
				</nav>
            </section>
            <section>
       			
       		</section>
            <section>
            	<div class="main-block">
					<!--             		
					<aside class=left>


            		</aside> 
            		-->
            		<div class=right>
						
							<div class="m-2"  style="font-size:.8rem">
								<a href="javascript:void(0)" class="seeker_login">일반 회원</a> | 
								<a href="javascript:void(0)" class="offer_login">기업 회원</a> 
							</div>
							
							<form action="${pageContext.request.contextPath}/user/login" method="post" name="seekerLogin"> 
								<div class="m-2">
									<h2>회원 로그인</h2>
								</div>	
								<div class="mb-3"></div>
								<div class="m-2">
									<label for="">회원 아이디 : </label>
									<input type="text"  name="id" class="form-control" />
								</div>
							
								<div class="m-2">
									<label for="">패스워드 : </label>
									<input type="password" name="password"  class="form-control" />
								</div>
								<div class="row m-0 p-0"  style="font-size:.8rem">	
									<div class="col">							
										<a href="">아이디 찾기</a> | 
										<a href="">패스워드 찾기</a>
									</div>
									<div class="col" style="text-align:right">
										<a href="${pageContext.request.contextPath}/user/join" >회원가입</a>
									</div>
								</div>
								<div class="m-2">
									<button class="btn btn-success w-100">로그인</button>
								</div>			
								<div class="m-2">
									<button class="btn btn-warning w-100 mb-2 text-white">카카오 로그인</button>
									<button class="btn w-100 mb-2" style="border : 1px solid lightgray;">GOOGLE 로그인</button>
								</div>									
								<div>
									<input type="hidden" name="type" value="seekerUser" />
								</div>		
							</form>   
							<form action="${pageContext.request.contextPath}/user/login" method="post" name="offerLogin" class="hidden">
								<div class="m-2">
									<h2>기업 로그인</h2>
								</div>			
								<div class="mb-3"></div>
								<div class="m-2">
									<label for="">기업 아이디 : </label>
									<input type="text" name="id"  class="form-control" />
								</div>
							
								<div class="m-2">
									<label for="">패스워드 : </label>
									<input type="password" name="password"  class="form-control" />
								</div>
								<div class="row m-0 p-0"  style="font-size:.8rem">	
									<div class="col">							
										<a href="">아이디 찾기</a> | 
										<a href="">패스워드 찾기</a>
									</div>
									<div class="col" style="text-align:right">
										<a href="${pageContext.request.contextPath}/user/join" >회원가입</a>
									</div>
								</div>
								<div class="m-2">
									<button class="btn btn-success w-100">로그인</button>
								</div>		
								<div class="m-2">
									<button class="btn btn-warning w-100 mb-2 text-white">카카오 로그인</button>
									<button class="btn w-100 mb-3" style="border : 1px solid lightgray;">GOOGLE 로그인</button>
								</div>									
								<div>
									<input type="hidden" name="type" value="offerUser" />
								</div>			
							</form>   
							 			
            		</div>	
            	</div>
       		
            </section>
            <section></section>
            <section></section>
            <section></section>
            
        </main>
        
        

	</div>
		
</body>	
</html>