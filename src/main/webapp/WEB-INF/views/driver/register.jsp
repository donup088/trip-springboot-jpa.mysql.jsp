<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>
<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 회원정보 > 기사회원 > 추가</p>
        </div>
        <div class="col-lg-12">
            <h3 class="page-header" style="color: gray">회원정보 연동 및 관리</h3>
        </div>
        <br>
        <ul class="nav nav-tabs nav-justified">
            <li><a href="/member/list">일반회원</a></li>
            <li class="active"><a href="/driver/list">기사회원</a></li>
            <li><a href="/admin/list">관리자</a></li>
        </ul>
        <div class="row">
            <div class="col-sm-6">
                <form id="registerForm" class="form-horizontal" action="/driver/register" method="post"
                      style="margin-top: 50px">
                    <div class="form-group">
                        <label for="userid" class="col-sm-4 control-label">ID</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="userid" name="userid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">국가</label>
                        <div class="col-sm-6">
                            <input type="radio" name="country" value="KOREA"/> 국내
                            <input type="radio" name="country" value="OTHER"/> 해외
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="address" class="col-sm-4 control-label">시/도</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="address" name="address">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="region" class="col-sm-4 control-label">지역</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="region" name="region">
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
                        <label for="car" class="col-sm-4 control-label">차종</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="car" name="car">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="carNumber" class="col-sm-4 control-label">차량번호</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="carNumber" name="carNumber">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">소속</label>
                        <div class="col-sm-6">
                            <input type="radio" name="department" value="private"/> 개인
                            <input type="radio" name="department" value="corporation"/> 법인
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="driverCount" class="col-sm-4 control-label">운행 횟수</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="driverCount" name="driverCount">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="complain" class="col-sm-4 control-label">컴플레인</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="complain" name="complain">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="score" class="col-sm-4 control-label">평점</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="score" name="score">
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
            <div class="col-sm-6">
                <div style="margin-top: 50px">
                    <form action="/driver/list" method="get" style="display: inline">
                        <input type="hidden" name="page" value="${pageDto.page}">
                        <input type="hidden" name="size" value="${pageDto.size}">
                        <input type="hidden" name="country" value="${pageDto.country}">
                        <button id="close" class="btn btn-default btn-lg pull-right">뒤로가기</button>
                    </form>
                    <button id="register" class="btn btn-default btn-lg pull-right">등록</button>
                </div>
                <div class="text-center">
                    <div id="filefullbox" style="border: 1px solid black; width:350px;
                     height:350px; padding: 10px; display: inline-block;margin-top: 50px">
                        <div class="profileResult">

                        </div>
                        <div class="filebox" style="margin-top: 50px">
                            <label id="profileUpload" for="profile" class="btn btn-default btn-lg"
                                   style="width: 300px;">
                                기사 사진 등록
                            </label>
                            <input type="file" id="profile" name="profile">
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
        var registerForm = $("#registerForm");

        $("#register").on("click", function (e) {
            registerForm.submit();
        });

        var profileResult = $(".profileResult")
        function showProfile(result) {
            profileResult.html("");
            var str = "";
            var filepath = encodeURIComponent(result.uploadPath + "/s_" + result.uuid + "_" + result.fileName);
            str += "<img src='/display?fileName=" + filepath + "'>";
            profileResult.append(str);
        }

        $("input[type='file']").change(function (e) {
            var formData = new FormData();
            var inputFile = $("input[name='profile']");
            var file = inputFile[0].files;
            console.log(file);
            formData.append("uploadFile", file[0]);

            $.ajax({
                url: '/uploadProfile',
                processData: false,
                contentType: false,
                data: formData,
                type: 'POST',
                success: function (result) {
                    showProfile(result);
                    alert("success");
                }
            });
        });
    })
</script>

<style>
    .filebox input[type="file"] {
        width: 1px;
        height: 1px;
        padding: 0;
        margin: -1px;
        overflow: hidden;
        clip: rect(0, 0, 0, 0);
        border: 0;
    }

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

    .profileResult img {
        width: 300px;
        height: 300px;
    }
</style>
<%@include file="../include/footer.jsp" %>

