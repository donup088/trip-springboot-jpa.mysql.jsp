<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/header.jsp" %>

<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 회원정보 > 일반회원</p>
        </div>
    </div>

    <div class="col-lg-12">
        <h3 class="page-header" style="color: gray">회원정보 연동 및 관리</h3>
    </div>
    <br>
    <ul class="nav nav-tabs nav-justified">
        <li class="active"><a href="/member/list">일반회원</a></li>
        <li><a href="/driver/list">기사회원</a></li>
        <li><a href="/admin/list">관리자</a></li>
    </ul>

    <div class="container">
        <div class="row" style="margin-top: 50px">
            <button class="btn btn-default-lg pull-right" style="width: 200px">닫기</button>
            <button id="registerBtn" class="btn btn-default-lg pull-right" style="width: 200px;margin-right: 100px">등록</button>
        </div>
        <form id="f1" action="/test" method="post">
            <div class="row">
                <table border="1" width="500px" height="700px" style="margin-top: 50px">
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="userid"></td>
                    </tr>
                    <tr>
                        <td>비밀번호</td>
                        <td><input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>생년월일</td>
                        <td><input type="text" name="birth"></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><input type="text" name="phone"></td>
                    </tr>
                    <tr>
                        <td>별명</td>
                        <td><input type="text" name="alias"></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><input type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td><input type="text" name="address"></td>
                    </tr>
                    <tr>
                        <td>국적</td>
                        <td><input type="text" name="country"></td>
                    </tr>
                    <tr>
                        <td>누적 투어 수</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>외향/내향</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>여행태그</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>이메일 수신</td>
                        <td>
                            <input type="radio" name="emailPost" value="true">수신
                            <input type="radio" name="emailPost" value="false">미수신
                        </td>
                    </tr>
                    <tr>
                        <td>문자 수신</td>
                        <td>
                            <input type="radio" name="messagePost" value="true">수신
                            <input type="radio" name="messagePost" value="false">미수신
                        </td>
                    </tr>
                    <tr>
                        <td>앱 PUSH</td>
                        <td>
                            <input type="radio" name="push">수신
                            <input type="radio" name="push">미수신
                        </td>
                    </tr>
                    <tr>
                        <td>기타</td>
                        <td><textarea rows="5" name="etc"></textarea></td>
                    </tr>
                </table>
            </div>
        </form>
    </div>

</div>
</div>

</body>
<%@include file="include/footer.jsp" %>
<script>
    $(document).ready(function () {
        var form=$("#f1");
        $("#registerBtn").on("click",function (e) {

            form.submit();
        })
    })
</script>
<style>
    input[type="text"], input[type="password"] {
        width: 100%;
        height: 100%;
    }

    input[type="radio"] {

    }

    tr {
        text-align: center;
    }

    textarea {
        margin-top: 3px;
        width: 100%;
        height: 100%;
    }

    .container-fluid {
        background-color: #e7e7e7;

    }

</style>

