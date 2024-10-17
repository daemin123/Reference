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
	

	<!-- join.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/user/join.css" />
	
	<!-- common.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/common.js" defer></script>
	
	<!-- user/join.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/user/join.js" defer></script>
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
				    <li class="breadcrumb-item active" aria-current="page">JOIN</li>
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
						
							<div class="m-2 header"  >
								<a href="javascript:void(0)" class="seeker_join">일반 회원</a> | 
								<a href="javascript:void(0)" class="offer_join">기업 회원</a> 
							</div>
							
							<form action="${pageContext.request.contextPath}/seeker/join" method="post" name="seekerJoin"> 
								<div class="m-2">
									<h3>일반회원 가입</h3>
								</div>	
								<div class="mb-3"></div>
								<div class="m-2">
									<label for="">회원 아이디 : </label>
									<input type="text" name="id"  class="form-control" />
								</div>
							
								<div class="m-2">
									<label for="">패스워드 : </label>
									<input type="password" name="password" class="form-control" />
								</div>
								<div class="m-2">
									<label for="">패스워드 확인 : </label>
									<input type="password"  name="repassword" class="form-control" />
								</div>
								<div class="m-2">
									<label for="">우편번호 : </label>
									<div class="" style="display:flex;justify-content:space-between;">
										<input type="zipcode"  class="form-control me-2" style="width:250px;" />							
										<a href="" class="btn btn-secondary" style="width:80px">검색</a>
									</div>
								</div>								
								<div class="m-2">
									<label for="">주소 : </label>
									<div>
										<input type="address"  name="address" class="form-control mb-2"  placeholder="기본주소" />
										<input type="addr_details"  name="addr_details"  class="form-control mb-2"  placeholder="상세주소" />
									</div>
								</div>
								<div class="m-2">
									<label for="">연락처 : </label>
									<input type="text"  class="form-control" name="tel" placeholder="-없이 입력" />
								</div>
								<div class="m-2">
									<button class="btn btn-success w-100 mb-2">회원가입</button>
									<button class="btn btn-success w-100">이전으로</button>
								</div>			
								<div>
									<input type="hidden" name="type" value="seekerUser" />
								</div>		
							</form>   
							
							<form action="${pageContext.request.contextPath}/offer/join" method="post" name="offerJoin" class="hidden">
								<div class="m-2">
									<h3>기업회원 가입</h3>
								</div>	
								<div class="mb-3"></div>
								<div class="m-2">
									<label for="">기업 아이디 : </label>
									<input type="text" name="id"  class="form-control" />
								</div>
							
								<div class="m-2">
									<label for="">패스워드 : </label>
									<input type="password" name="password" class="form-control" />
								</div>
								<div class="m-2">
									<label for="">패스워드 확인 : </label>
									<input type="password"  name="repassword" class="form-control" />
								</div>
								<div class="m-2">
									<label for="">회사명 : </label>
									<input type="text"  class="form-control" name="offername" placeholder="-없이 입력" />
								</div>
								<div class="m-2">
									<label for="">사업자 No. : </label>
									<input type="text"  class="form-control" name="offeruumber" placeholder="-없이 입력" />
								</div>								
								<div class="m-2">
									<label for="">우편번호 : </label>
									<div class="" style="display:flex;justify-content:space-between;">
										<input type="zipcode" name="zipcode"  class="form-control me-2" style="width:250px;" />							
										<a href="" class="btn btn-secondary" style="width:80px">검색</a>
									</div>
								</div>									
								<div class="m-2">
									<label for="">회사 주소 : </label>
									<div>
										<input type=text name="offeraddress"  class="form-control mb-2"  placeholder="기본주소" />
										<input type="text" name="addr_details" class="form-control mb-2"  placeholder="상세주소" />
									</div>
								</div>
								<div class="m-2">
									<label for="">TEL : </label>
									<input type="text"  class="form-control" name="offertel" placeholder="-없이 입력" />
								</div>
								

								<div class="m-2">
									<button class="btn btn-success w-100 mb-3">회원가입</button>
									<button class="btn btn-success w-100 mb-3">이전으로</button>
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
        
        
        <footer>
        	<!-- footer  -->
			<%@ include file="/resources/static/jsp/footer.jsp" %>
       </footer>
        	
	</div>
		
</body>	
</html>