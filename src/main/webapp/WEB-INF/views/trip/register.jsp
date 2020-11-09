<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>
<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 회원정보 > 관광지 > 추가</p>
        </div>
        <div class="col-lg-12">
            <h3 class="page-header" style="color: gray">관광지 관리</h3>
        </div>
        <br>
        <ul class="nav nav-tabs nav-justified">
            <li class="active"><a href="/trip/list">관광지 코드</a></li>
            <li><a href="#">지역별 대표사진 등록</a></li>
        </ul>
        <div class="row">
            <div class="col-sm-6">
                <form id="registerForm" class="form-horizontal" action="/driver/register" method="post"
                      style="margin-top: 50px">
                    <div class="form-group">
                        <label class="col-sm-4 control-label">국가</label>
                        <div class="col-sm-6">
                            <input type="radio" name="country" value="KOREA"/> 국내
                            <input type="radio" name="country" value="JAPAN"/> 일본
                            <input type="radio" name="country" value="CHINA"/> 중국
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
                        <label for="code" class="col-sm-4 control-label">관광지 코드</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="code" name="code">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="name" class="col-sm-4 control-label">관광지 이름</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="phone" class="col-sm-4 control-label">전화번호</label>
                        <div class="col-sm-6">
                            <input type="email" class="form-control" id="phone" name="phone">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="fee" class="col-sm-4 control-label">입장료</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="fee" name="fee">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="operatingTime" class="col-sm-4 control-label">운영시간</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="operatingTime" name="operatingTime">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">tag</label>
                        <div class="col-sm-6">
                            <input type="radio" name="photo" value="photo"/> 사진광
                            <input type="radio" name="sports" value="sports"/> 스포츠 마니아
                            <input type="radio" name="shopping" value="shopping"/> 쇼핑왕
                            <input type="radio" name="eat" value="eat"/>미식가
                            <input type="radio" name="exciting" value="exciting"/>흥폭발
                            <input type="radio" name="study" value="study"/> 학구파
                            <input type="radio" name="nature" value="nature"/> 자연인

                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-4 control-label">언어</label>
                        <div class="col-sm-6">
                            <input type="radio" name="korea" value="korea"/> 한국어
                            <input type="radio" name="english" value="english"/> 영어
                        </div>
                    </div>
                    <input type='hidden' name='fileDtos.fileName' value="">
                    <input type='hidden' name='fileDtos.uuid' value="">
                    <input type='hidden' name='fileDtos.uploadPath' value="">
                    <input type='hidden' name='fileDtos.fileType' value="">
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
                <div class="text-center">
                    <div id="filefullbox" style="border: 1px solid black; width:360px;
                     height:360px; display: inline-block; margin-top: 50px">
                        <div class="mainResult">
                            <c:if test="${trip.fileDtos[0]!=null}">
                                <img style="width: 360px;height: 360px" src='/display?fileName=${trip.fileDtos[0].fileName}'>
                            </c:if>
                        </div>
                        <div class="filebox">

                        </div>
                    </div>
                    <div>
                        <div style="border: 1px solid black; width:360px;
                              height:120px;  display: inline-block">
                            <div class="subResult">
                                <c:if test="${trip.fileDtos[1]!=null}">
                                    <li><img src='/display?fileName=${trip.fileDtos[1].fileName}'></li>
                                </c:if>
                                <c:if test="${trip.fileDtos[2]!=null}">
                                    <li><img src='/display?fileName=${trip.fileDtos[2].fileName}'></li>
                                </c:if>
                                <c:if test="${trip.fileDtos[3]!=null}">
                                    <li><img src='/display?fileName=${trip.fileDtos[3].fileName}'></li>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <button id="upload" class="btn btn-default btn-lg" style="width: 300px;">
                        사진 관리
                    </button>

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
            var str = "";
            var profileDiv = $(".profileResult div");
            str += "<input type='hidden' name='profile.fileName' value='" + profileDiv.data("filename") + "'>";
            str += "<input type='hidden' name='profile.uuid' value='" + profileDiv.data("uuid") + "'>";
            str += "<input type='hidden' name='profile.uploadPath' value='" + profileDiv.data("path") + "'>";
            str += "<input type='hidden' name='profile.fileType' value='" + profileDiv.data("type") + "'>";
            registerForm.append(str).submit();
        });

        var profileResult = $(".profileResult");

        function showProfile(result) {
            console.log("result:" + result)
            profileResult.html("");
            var str = "";
            var filepath = encodeURIComponent(result.uploadPath + "/s_" + result.uuid + "_" + result.fileName);
            str += "<div data-path='" + result.uploadPath + "'";
            str += " data-uuid='" + result.uuid + "' data-filename='" + result.fileName + "' data-type='" + result.image + "'>";
            str += "<img src='/display?fileName=" + filepath + "'>";
            str += "</div>";
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

        $("#upload").on("click", function (e) {
            var backForm = $("#back");
            backForm.attr("action", "/trip/upload");
            backForm.submit();
        });
    })
</script>

<style>
    .filebox, input[type="file"] {
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

