<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>
<div class="col-sm-9 page">
    <div class="row">
        <div class="col-lg-12">
            <h3 class="page-header" style="color: gray">회원정보 연동 및 관리</h3>
        </div>
        <br>
        <ul class="nav nav-tabs nav-justified">
            <li><a href="/member/list">일반회원</a></li>
            <li><a href="/member/driver">기사회원</a></li>
            <li><a href="/member/admin">관리자</a></li>
        </ul>

        <form class="form-horizontal" action="/member/register" method="post" style="margin-top: 50px">
            <div id="btn" class="pull-right">
                <button id="close" class="btn btn-default btn-lg pull-right ">닫기</button>
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
                <label for="country" class="col-sm-4 control-label">국적</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="country" name="country">
                </div>
            </div>

            <div class="form-group">
                <label for="phone" class="col-sm-4 control-label">전화번호</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="phone" name="phone">
                </div>
            </div>


            <div class="form-group">
                <label for="alias" class="col-sm-4 control-label">별명</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="alias" name="alias">
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="col-sm-4 control-label">이메일</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="email" name="email">
                </div>
            </div>

            <div class="form-group">
                <label for="address" class="col-sm-4 control-label">주소</label>
                <div class="col-sm-6">
                    <input type="text" class="form-control" id="address" name="address">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-4 control-label">이메일 수신</label>
                <div class="col-sm-6">
                    <input type="radio" name="emailPost" value="true" checked/> 수신
                    <input type="radio" name="emailPost" value="false"/> 미수신
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-4 control-label">문자 수신</label>
                <div class="col-sm-6">
                    <input type="radio" name="messagePost" value="true" checked/> 수신
                    <input type="radio" name="messagePost" value="false"/> 미수신
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
</body>
<script>
    $(document).ready(function () {
        $("#close").on("click", function (e) {
            e.preventDefault();
            self.location = "/member/list";
        })

    })
</script>

<style>
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

