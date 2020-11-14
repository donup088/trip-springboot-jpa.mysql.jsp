<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>
<div class="col-sm-9 page" style="height: 100%">
    <div class="row" style=height:100%>
        <div class="container-fluid">
            <p>홈 > 공지사항 > 공지사항 관리 > 추가</p>
        </div>
        <div class="col-lg-12">
            <h3 class="page-header" style="color: gray">공지사항 및 기타</h3>
        </div>
        <br>
        <ul class="nav nav-tabs nav-justified">
            <li><a href="#">알림 관리</a></li>
            <li class="active"><a href="/notice/list">공지사항 관리</a></li>
            <li><a href="#">문의사항 관리</a></li>
        </ul>
        <div class="container">
            <form id="close" action="/notice/list" method="get">
                <div style="margin-top: 50px;">
                    <button id="closeBtn" class="btn btn-default-lg pull-right" style="width: 200px">닫기</button>
                    <button id="registerBtn" class="btn btn-default-lg pull-right"
                            style="width: 200px;margin-right: 100px">
                        등록
                    </button>
                </div>
                <input type="hidden" name="page" value="${pageDto.page}">
                <input type="hidden" name="size" value="${pageDto.size}">
            </form>

            <div class="row" style="margin-top: 120px;width: 70%;">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form role="form" action="/notice/register" method="post" id="registerForm">
                                <div class="form-group">
                                    <label>제목</label>
                                    <input class="form-control" name="title">
                                </div>

                                <div class="form-group">
                                    <label>공개여부</label>
                                    <div class="form-control">
                                        <input type="radio" name="secret" value="false">공개
                                        <input type="radio" name="secret" value="true">비공개
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>등록자</label>
                                    <input class="form-control" name="adminDto.userid">
                                </div>

                                <div class="form-group">
                                    <label>첨부파일</label>
                                    <div class="form-control">
                                        <label id="upload" for="noticeFile" class=" pull-right">
                                            파일 등록
                                        </label>
                                        <div id="uploadResult">

                                        </div>
                                        <input type="file" id="noticeFile" multiple>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label>상단 노출</label>
                                    <div class="form-control">
                                        상단 노출
                                        <input type="checkbox" name="top" value="true">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>내용</label>
                                    <textarea class="form-control" rows="5" name="content"></textarea>
                                </div>
                            </form>
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

        $("#registerBtn").on("click", function (e) {
            e.preventDefault();
            var str = "";

            $("#uploadResult li").each(function (i, obj) {
                var jobj = $(obj);

                str += "<input type='hidden' name='fileDtos[" + i + "].fileName' value='" + jobj.data("filename") + "'>";
                str += "<input type='hidden' name='fileDtos[" + i + "].uuid' value='" + jobj.data("uuid") + "'>";
                str += "<input type='hidden' name='fileDtos[" + i + "].uploadPath' value='" + jobj.data("path") + "'>";
                str += "<input type='hidden' name='fileDtos[" + i + "].image' value='" + jobj.data("type") + "'>";
            });

            registerForm.append(str).submit();
        });

        function showNoticeFile(result) {
            var uploadResult = $("#uploadResult");
            $(result).each(function (i, obj) {
                var str = "";
                str += "<li data-path='" + obj.uploadPath + "'";
                str += " data-uuid='" + obj.uuid + "' data-filename='" + obj.fileName + "' data-type='" + obj.image + "'>";
                str += obj.fileName;
                str += "</li>&ensp;";
                uploadResult.append(str);
            });
        }

        $("#noticeFile").change(function (e) {
            var formData = new FormData();
            var inputFile = $("#noticeFile");
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
                    showNoticeFile(result);
                    alert("success");
                }
            });
        });
    })
</script>

<style>
    input[type="file"] {
        width: 1px;
        height: 1px;
        padding: 0;
        margin: -1px;
        overflow: hidden;
        clip: rect(0, 0, 0, 0);
        border: 0;
    }

    #uploadResult {
        display: flex;
        flex-flow: row;

    }

    #uploadResult li {
        list-style: none;
    }

    .container-fluid {
        background-color: #e7e7e7;
    }

    .page a {
        color: black;
        text-decoration: none;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        height: 100%;
    }

    tr {
        text-align: center;
    }

    textarea {
        margin-top: 3px;
        width: 100%;
        height: 100%;
    }

</style>
<%@include file="../include/footer.jsp" %>

