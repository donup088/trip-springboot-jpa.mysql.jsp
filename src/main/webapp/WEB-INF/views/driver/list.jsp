<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>

<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 회원정보 > 일반회원</p>
        </div>
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
            <form id="optForm" action="/member/list" method="get" style="display: inline">
                <select id="country">
                    <option value="" <c:out value="${pageDto.country == 'null' ? 'selected': ''}"/>>국적별 분류</option>
                    <option value="KOREA" <c:out value="${pageDto.country eq 'KOREA' ? 'selected': ''}"/>>KOREA</option>
                    <option value="JAPAN" <c:out value="${pageDto.country eq 'JAPAN' ? 'selected': ''}"/>>JAPAN</option>
                    <option value="CHINA" <c:out value="${pageDto.country eq 'CHINA' ? 'selected': ''}"/>>CHINA</option>
                </select>

                <select size="1" id="count">
                    <option value=5 <c:out value="${pageDto.size eq 5 ? 'selected': ''}"/>>5건 노출</option>
                    <option value=6 <c:out value="${pageDto.size eq 6 ? 'selected': ''}"/>>6건 노출</option>
                    <option value=7 <c:out value="${pageDto.size eq 7 ? 'selected': ''}"/>>7건 노출</option>
                    <option value=8 <c:out value="${pageDto.size eq 8 ? 'selected': ''}"/>>8건 노출</option>
                    <option value=9 <c:out value="${pageDto.size eq 9 ? 'selected': ''}"/>>9건 노출</option>
                    <option value=10 <c:out value="${pageDto.size eq 10 ? 'selected': ''}"/>>10건 노출</option>
                </select>

                <input type="hidden" name="page" value="${members.currentPageNum}">
                <input type="hidden" name="size" value="${members.currentPage.pageSize}">
                <input type="hidden" name="country" value="${pageDto.country}">
            </form>

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
                <c:forEach items="${members.result.content}" var="members">
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
                <nav>
                    <div class="text-center">
                        <ul class="pagination">
                            <c:if test="${members.prevPage!=null}">
                                <li class="page-item">
                                    <a href="${members.prevPage.pageNumber+1}">PREV</a>
                                </li>
                            </c:if>
                            <c:forEach items="${members.pageList}" var="p">
                                <li class="page-item ${p.pageNumber==members.currentPageNum-1?"active":''}">
                                    <a href="${p.pageNumber+1}">${p.pageNumber+1}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${members.nextPage!=null}">
                                <li class="page-item">
                                    <a href="${members.nextPage.pageNumber+1}">NEXT</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </nav>
                <select id="orderby_id" class="pull-right">
                    <option>아이디 오름차순 정렬</option>
                </select>
            </div>

            <form id="list" action="/member/list" method="get">
                <div id="button" style="margin-top: 20px" class="pull-right">
                    <button class="btn btn-group" id="delete">삭제하기</button>
                    <button class="btn btn-group" id="add">추가하기</button>
                </div>

                <input type="hidden" name="page" value="${members.currentPageNum}">
                <input type="hidden" name="size" value="${members.currentPage.pageSize}">
                <input type="hidden" name="country" value="${pageDto.country}">
            </form>
        </div>
    </div>
</div>
</div>

</div>
</body>

<script>
    $(document).ready(function () {
        var listForm = $("#list");

        $(".pagination a").on("click", function (e) {
            e.preventDefault();
            console.log($(this));
            listForm.find('[name="page"]').val($(this).attr('href'))
            listForm.submit();
        });

        var optForm = $("#optForm");

        $("#optForm #country, #optForm #count").change(function (e) {
            e.preventDefault();
            var country = $('#country').find(":selected").val();
            var size = $('#count').find(":selected").val();

            console.log(country);
            console.log(size);

            optForm.find("input[name='pageNum']").val("1");
            optForm.find("input[name='country']").val(country);

            optForm.find("input[name='size']").val(size);
            optForm.submit();
        });


        $("#add").on("click",function (e) {
            e.preventDefault();
            listForm.attr("action","/member/register");
            listForm.submit();
        });
    })
</script>


<style>
    .container-fluid {
        background-color: #e7e7e7;
    }

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

