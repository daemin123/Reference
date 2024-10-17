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
	
	<!-- index.css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/index.css" />
		
	<!-- user/myinfo.css -->
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/static/css/common.css" /> --%>
	
	<!-- common.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/common.js" defer></script>

	<!-- index.js -->
	<script src="${pageContext.request.contextPath}/resources/static/js/index.js" defer></script>
	
</head>

<body>
	
	<div class="wrapper">
		<header>
			
			<!-- top-header -->
			<%@ include file="/resources/static/jsp/topHeader.jsp" %>
			<!-- nav -->
			<%@ include file="/resources/static/jsp/nav.jsp" %>

		</header>
       <main class="">
       		<section>
       		
       		</section>
            <section class="main-block layout-150">
            
            		<div class="left">
            		 LEFT
            		</div>
                    
                    <div class="banner-section" >
                        <div class="notification">
                         	NOTIFICATION
                        </div>
                         <!-- Slider main container -->
	                    <div class="swiper centers">
	                        <!-- Additional required wrapper -->
	                        <div class="swiper-wrapper">
	                            
	                            <!-- Slides -->
	                            <div class="swiper-slide">  <a href="javascript:void(0)"><img src="" alt=""> </a>   </div>
	                            <div class="swiper-slide">  <a href="javascript:void(0)"><img src="" alt=""> </a>   </div>
	                            <div class="swiper-slide">  <a href="javascript:void(0)"><img src="" alt=""> </a>   </div>
	                            <div class="swiper-slide">  <a href="javascript:void(0)"><img src="" alt=""> </a>   </div>
	                            <div class="swiper-slide">  <a href="javascript:void(0)"><img src="" alt=""> </a>   </div>
	                            <div class="swiper-slide">  <a href="javascript:void(0)"><img src="" alt=""> </a>   </div>
	                            <div class="swiper-slide">  <a href="javascript:void(0)"><img src="" alt=""> </a>   </div>
	                            <div class="swiper-slide">  <a href="javascript:void(0)"><img src="" alt=""> </a>   </div>

	                        </div>
	                        <!-- If we need pagination -->
	                        <!-- 
	                        <div class="swiper-pagination"> </div>
	                     	-->
	                        <!-- If we need navigation buttons -->
	                        <div class="swiper-button-prev">
	                            <span class="material-symbols-outlined">arrow_left</span>
	                        </div>
	                        <div class="swiper-button-next">
	                            <span class="material-symbols-outlined">arrow_right</span>
	                        </div>
	                    
	                        <!-- If we need scrollbar -->
	                        <div class="swiper-scrollbar"></div>
	                    </div>
	                    
                    </div>
             		<div class="right">
            		 right
            		</div>
            </section>
            
            
            <section class="company_items">
            	<div class="items">
            	
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            		<div class="item">모집공고</div>
            	</div>
            </section>
            
            <!-- 다중슬라이더 구현 -->
            <section class="multi-slider">
                    <!-- Slider main container -->
                    <div class="swiper">
                        <!-- Additional required wrapper -->
                        <div class="swiper-wrapper">
                            <!-- Slides -->
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
                            <div class="swiper-slide">
                                <a href="javascript:void(0)">
                                    <img src="" alt="">
                                </a>
                            </div>
 
                        </div>
                        <!-- If we need pagination -->
                        <div class="swiper-pagination"></div>
                    
                        <!-- If we need navigation buttons -->
                        <div class="swiper-button-prev">
                            <span class="material-symbols-outlined">arrow_left</span>
                        </div>
                        <div class="swiper-button-next">
                            <span class="material-symbols-outlined">arrow_right</span>
                        </div>
                    </div>

            </section>


            <section></section>
        </main>
        
        	<footer>
        		<!-- footer  -->
				<%@ include file="/resources/static/jsp/footer.jsp" %>
        	</footer>
        	
	</div>
		
</body>	
</html>