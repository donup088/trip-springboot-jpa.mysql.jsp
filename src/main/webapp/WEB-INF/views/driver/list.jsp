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
            <li class="active"><a href="/member/list">일반회원</a></li>
            <li><a href="/member/driver">기사회원</a></li>
            <li><a href="/member/admin">관리자</a></li>
        </ul>
        <br>

        <div class="container">
            <select id="country">
                <option>국적별 분류</option>
                <option>KOREA</option>
                <option>JAPAN</option>
                <option>CHINA</option>
            </select>

            <select size="1" id="count">
                <option>5건 노출</option>
                <option>6건 노출</option>
                <option>7건 노출</option>
                <option>8건 노출</option>
                <option>9건 노출</option>
                <option>10건 노출</option>
            </select>

            <form class="pull-right" id="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
            </form>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>id</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                    <th>국적</th>
                    <th>구매내역</th>
                    <th>문의사항</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${members}" var="members">
                    <tr>
                        <td><c:out value="${members.id}"/></td>
                        <td><a href="#"><c:out value="${members.userid}"/></a></td>
                        <td><c:out value="${members.name}"/></td>
                        <td><c:out value="${members.phone}"/></td>
                        <td><c:out value="${members.email}"/></td>
                        <td><c:out value="${members.country}"/></td>
                        <td><a href="#">2건</a></td>
                        <td><a href="#">2건</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="row">
                <div class="text-center">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                    <select id="orderby_id" class="pull-right">
                        <option>아이디 오름차순 정렬</option>
                    </select>
                </div>

                <div id="button" style="margin-top: 20px" class="pull-right">
                    <button class="btn btn-group" id="delete">삭제하기</button>
                    <button class="btn btn-group" id="add">
                        <a href="/member/register">
                            추가하기
                        </a>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

</div>
</body>
<style>
    .row {
        margin-left: 10px;
    }

    .page a {
        color: black;
        text-decoration: none;
    }

    .page button a {
        color: black;
        text-decoration: none;
    }

    select {
        width: 200px;
        padding: 5px 5px;
    }

    #count {
        margin-left: 10px;
        margin-bottom: 10px;
    }

    tr {
        border: 1px solid gray;
    }

</style>
<%@include file="../include/footer.jsp" %>

