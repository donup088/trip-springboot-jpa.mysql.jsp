<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>
<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 회원정보 > 관리자 > 추가</p>
        </div>
        <div class="col-lg-12">
            <h3 class="page-header" style="color: gray">회원정보 연동 및 관리</h3>
        </div>
        <br>
        <ul class="nav nav-tabs nav-justified">
            <li><a href="/member/list">일반회원</a></li>
            <li><a href="/driver/list">기사회원</a></li>
            <li class="active"><a href="/admin/list">관리자</a></li>
        </ul>
        <div class="row">
            <form action="/admin/list" method="get" style="margin-top: 50px">
                <input type="hidden" name="page" value="${pageDto.page}">
                <input type="hidden" name="size" value="${pageDto.size}">
                <input type="hidden" name="country" value="${pageDto.country}">
                <button id="close" class="btn btn-default btn-lg pull-right">뒤로가기</button>
            </form>

            <form id="registerForm" class="form-horizontal" action="/admin/register" method="post" style="margin-top: 50px">
                <div id="btn">
                    <button type="submit" id="register" class="btn btn-default btn-lg pull-right">등록</button>
                </div>

                <div class="form-group">
                    <label for="userid" class="col-sm-4 control-label">ID</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="userid" name="userid">
                    </div>
                </div>

                <div class="form-group">
                    <label for="password" class="col-sm-4 control-label">비밀번호</label>
                    <div class="col-sm-6">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>

                <div class="form-group">
                    <label for="name" class="col-sm-4 control-label">이름</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                </div>

                <div class="form-group">
                    <label for="birth" class="col-sm-4 control-label">생년월일</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="birth" name="birth">
                    </div>
                </div>

                <div class="form-group">
                    <label for="phone" class="col-sm-4 control-label">전화번호</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="phone" name="phone">
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="col-sm-4 control-label">이메일</label>
                    <div class="col-sm-6">
                        <input type="email" class="form-control" id="email" name="email">
                    </div>
                </div>

                <div class="form-group">
                    <label for="country" class="col-sm-4 control-label">국적</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="country" name="country">
                    </div>
                </div>

                <div class="form-group">
                    <label for="englishName" class="col-sm-4 control-label">영어이름</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="englishName" name="englishName">
                    </div>
                </div>

                <div class="form-group">
                    <label for="address" class="col-sm-4 control-label">주소</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="address" name="address">
                    </div>
                </div>

                <div class="form-group">
                    <label for="joinDate" class="col-sm-4 control-label">입사년도</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="joinDate" name="joinDate">
                    </div>
                </div>

                <div class="form-group">
                    <label for="job" class="col-sm-4 control-label">직무</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="job" name="job">
                    </div>
                </div>

                <div class="form-group">
                    <label for="department" class="col-sm-4 control-label">부서</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="department" name="department">
                    </div>
                </div>

                <div class="form-group">
                    <label for="etc" class="col-sm-4 control-label">기타</label>
                    <div class="col-sm-6">
                        <textarea rows="5" class="form-control" id="etc" name="etc"></textarea>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

</body>
<script>
    $(document).ready(function () {

    })
</script>

<style>
    .container-fluid {
        background-color: #e7e7e7;
    }

    .page a {
        color: black;
        text-decoration: none;
    }

    #close {
        margin-right: 50px;
    }

    #register {
        margin-right: 30px;
    }

    #register, #close {
        width: 200px;
        color: black;
    }

    #btn {
        width: 100%;
    }

    label {
        font-size: 12px;
    }

    .form-group {
        width: 400px;
    }
</style>
<%@include file="../include/footer.jsp" %>

