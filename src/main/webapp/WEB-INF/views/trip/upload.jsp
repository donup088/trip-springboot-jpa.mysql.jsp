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
                <div class="text-center">
                    <div id="filefullbox" style="border: 1px solid black; width:360px;
                     height:360px; display: inline-block; margin-top: 50px">
                        <div class="mainResult">

                        </div>
                        <div class="filebox">

                        </div>
                    </div>
                    <div style="border: 1px solid black; width:360px;
                              height:120px;  display: inline-block">
                        <div class="subResult">

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div style="margin-top: 50px">
                    <form id="scform" action="/trip/register" method="get" style="display: inline">
                        <input type="hidden" name="page" value="${pageDto.page}">
                        <input type="hidden" name="size" value="${pageDto.size}">
                        <input type="hidden" name="country" value="${pageDto.country}">
                        <input type="hidden" name="city" value="${pageDto.city}">
                        <input type="hidden" name="region" value="${pageDto.region}">
                        <button type="submit" id="close" class="btn btn-default btn-lg pull-right">닫기</button>
                    </form>
                    <button id="save" class="btn btn-default btn-lg pull-right">저장</button>
                </div>
                <label id="mainUpload" for="mainPhoto" class="btn btn-default btn-lg" style="margin-top: 50px">
                    메인 사진 추가
                </label>
                <input type="file" id="mainPhoto" name="mainPhoto">

                <label id="subUpload" for="subPhoto" class="btn btn-default btn-lg" style="margin-top: 50px">
                    서브 사진 추가
                </label>
                <input type="file" id="subPhoto" name="subPhoto" multiple>
            </div>
        </div>
    </div>

</div>

</body>
<script>
    $(document).ready(function () {
        var scform = $("#scform");
        var mainResult = $(".mainResult");
        var subResult = $(".subResult");

        function showMainPhoto(result) {
            console.log("result:" + result)
            mainResult.html("");
            var str = "";
            var filepath = encodeURIComponent(result[0].uploadPath + "/s_" + result[0].uuid + "_" + result[0].fileName);
            str += "<div data-path='" + result[0].uploadPath + "'";
            str += " data-uuid='" + result[0].uuid + "' data-filename='" + result[0].fileName + "' data-type='" + result[0].image + "'>";
            str += "<img src='/display?fileName=" + filepath + "'>";
            str += "</div>";
            mainResult.append(str);
        }

        function showSubPhoto(result) {
            $(result).each(function (i, obj) {
                var str = "";
                var filepath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
                str += "<li data-path='" + obj.uploadPath + "'";
                str += " data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.image + "'>";
                str += "<img src='/display?fileName=" + filepath + "'>";
                str += "</li>";
                subResult.append(str);
            });
        }

        $("#mainPhoto").change(function (e) {
            var formData = new FormData();
            var inputFile = $("input[name='mainPhoto']");
            var file = inputFile[0].files;
            console.log(file);
            formData.append("uploadFile", file[0]);

            $.ajax({
                url: '/upload',
                processData: false,
                contentType: false,
                data: formData,
                type: 'POST',
                success: function (result) {
                    showMainPhoto(result);
                    alert("success");
                }
            });
        });

        $("#subPhoto").change(function (e) {
            var formData = new FormData();
            var inputFile = $("input[name='subPhoto']");
            var files = inputFile[0].files;

            for (var i = 0; i < files.length; i++) {
                formData.append("uploadFile", files[i]);
            }

            $.ajax({
                url: '/upload',
                processData: false,
                contentType: false,
                data: formData,
                type: 'POST',
                success: function (result) {
                    showSubPhoto(result);
                    alert("success");
                }
            });
        });

        $("#save").on("click", function (e) {
            e.preventDefault();
            var str = "";
            var mainDiv=$(".mainResult div");


            str+="<input type='hidden' name='fileDtos[0].fileName' value='"+mainDiv.data("filename")+"'>";
            str+="<input type='hidden' name='fileDtos[0].uuid' value='"+mainDiv.data("uuid")+"'>";
            str+="<input type='hidden' name='fileDtos[0].uploadPath' value='"+mainDiv.data("path")+"'>";
            str+="<input type='hidden' name='fileDtos[0].image' value='"+mainDiv.data("type")+"'>";

            $(".subResult li").each(function (i, obj) {
                var jobj = $(obj);
                console.log(jobj);
                str += "<input type='hidden' name='fileDtos[" + (i+1) + "].fileName' value='" + jobj.data("filename") + "'>";
                str += "<input type='hidden' name='fileDtos[" + (i+1) + "].uuid' value='" + jobj.data("uuid") + "'>";
                str += "<input type='hidden' name='fileDtos[" + (i+1) + "].uploadPath' value='" + jobj.data("path") + "'>";
                str += "<input type='hidden' name='fileDtos[" + (i+1) + "].image' value='" + jobj.data("type") + "'>";
            });

            scform.attr("action","/trip/photo/save");
            scform.attr("method","post");

            scform.append(str).submit();
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

    #save {
        margin-right: 100px;
    }

    #save, #close {
        width: 200px;
        color: black;
    }

    .mainResult img {
        width: 360px;
        height: 360px;
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

