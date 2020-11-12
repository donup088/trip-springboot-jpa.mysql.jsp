<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>
<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 회원정보 > 관광지코드 > 추가</p>
        </div>
        <div class="col-lg-12">
            <h3 class="page-header" style="color: gray">관광지 관리</h3>
        </div>
        <br>
        <ul class="nav nav-tabs nav-justified">
            <li class="active"><a href="/trip/list">관광지 코드</a></li>
            <li><a href="#">지역 코드 관리</a></li>
        </ul>
        <div class="row">
            <div class="col-sm-6">
                <form id="registerForm" class="form-horizontal" action="/tour/register" method="post"
                      style="margin-top: 50px">

                    <div class="form-group">
                        <label for="name" class="col-sm-4 control-label">투어 이름</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">국가</label>
                        <div class="col-sm-6">
                            <input type="radio" name="country" value="K"/> 국내
                            <input type="radio" name="country" value="J"/> 일본
                            <input type="radio" name="country" value="C"/> 중국
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="city" class="col-sm-4 control-label">시/도</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="city" name="city">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="region" class="col-sm-4 control-label">지역</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="region" name="region">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">투어 구분</label>
                        <div class="col-sm-6">
                            <input type="radio" name="tourType" value="other"> 일반
                            <input type="radio" name="tourType" value="taxi"> 택시
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="tourDate" class="col-sm-4 control-label">투어 날짜</label>
                        <div class="col-sm-6">
                            <input type="date" class="form-control" id="tourDate" name="tourDate">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="personCount" class="col-sm-4 control-label">인원</label>
                        <div class="col-sm-6">
                            <input type="number" class="form-control" id="personCount" name="personCount">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="payment" class="col-sm-4 control-label">가격</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="payment" name="payment">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">투어 시작 시간</label>
                        <div class="col-sm-6">
                            <input type="time" name="startTime">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">투어 소요 시간</label>
                        <div class="col-sm-6">
                            <input type="number" name="takeTime" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">투어 장소 수</label>
                        <div class="col-sm-6">
                            <input type="number" name="visitCount" class="form-control">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">기사 이름</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="driver.driverName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">구매 코드</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="code">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">구매방식</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="buyType">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">구매가격</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="buyPay">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">구매자 ID</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="userid">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">구매자 이름</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="member.name">
                        </div>
                    </div>
                </form>
            </div>

            <div class="col-sm-6">
                <div style="margin-top: 50px">
                    <form id="back" action="/trip/list" method="get" style="display: inline">
                        <input type="hidden" name="page" value="${pageDto.page}">
                        <input type="hidden" name="size" value="${pageDto.size}">
                        <input type="hidden" name="country" value="${pageDto.country}">
                        <input type="hidden" name="city" value="${pageDto.city}">
                        <input type="hidden" name="region" value="${pageDto.region}">
                        <button id="close" class="btn btn-default btn-lg pull-right">뒤로가기</button>
                    </form>
                    <button id="register" class="btn btn-default btn-lg pull-right">등록</button>
                </div>

            </div>
        </div>
    </div>
</div>
</div>

</div>

</body>
<script>
    $(document).ready(function () {
        var form=$("#registerForm");
        $("#register").on("click",function (e) {
            e.preventDefault();

            form.submit();
        })
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
        margin-right: 100px;
    }

    #register, #close {
        width: 200px;
        color: black;
    }

    .form-group {
        width: 550px;
    }

    .subResult {
        display: flex;
        flex-flow: row;

    }

    .subResult li {
        list-style: none;
    }

    .subResult li img {
        width: 120px;
        height: 120px;
    }
</style>
<%@include file="../include/footer.jsp" %>

