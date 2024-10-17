<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="top-header layout-150">
				<div class="left"></div>
				<div class="right">
					<ul class=menu>
						<!-- 인증이후 -->
						
						<c:if test="${not empty sessionDto}">
							<li class=username><a href=""><span>${sessionDto.username } </span></a></li>
							<li><a href="${pageContext.request.contextPath}/user/myinfo">나의정보</a></li>
							<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
						</c:if>
						
						<c:if test="${empty sessionDto}">
							<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
							<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
						</c:if>
						<!-- 공통 -->
						<li><a href="javascript:void(0)">고객센터</a></li>
						<li><a href="javascript:void(0)" data-bs-toggle="modal" data-bs-target="#staticBackdrop">전체메뉴</a></li>			
					</ul>
				</div>
</div>




<!-- Modal -->
<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body" style="height:600px;">
        <div>
        	...TEST...
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Understood</button>
      </div>
    </div>
  </div>
</div>