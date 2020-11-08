<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>

<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 관광지 관리 > 관광지 코드</p>
        </div>
        <div class="col-lg-12">
            <h3 class="page-header" style="color: gray">관광지 관리</h3>
        </div>
        <br>
        <ul class="nav nav-tabs nav-justified">
            <li ><a href="/trip/list">관광지 코드</a></li>
            <li><a href="#">지역별 대표사진 등록</a></li>
        </ul>
        <br>

        <div class="container">
            <form id="optForm" action="/trip/list" method="get" style="display: inline">
                <select id="country">
                    <option value="" <c:out value="${pageDto.country == 'null' ? 'selected': ''}"/>>모든 국가</option>
                    <option value="KOREA" <c:out value="${pageDto.country eq 'KOREA' ? 'selected': ''}"/>>KOREA</option>
                    <option value="JAPAN" <c:out value="${pageDto.country eq 'JAPAN' ? 'selected': ''}"/>>JAPAN</option>
                    <option value="CHINA" <c:out value="${pageDto.country eq 'CHINA' ? 'selected': ''}"/>>CHINA</option>
                </select>

                <select size="1" id="address">
                   <option value="">모든 주</option>
                </select>

                <select size="1" id="city">
                    <option value="">모든 도시</option>
                </select>

<%--                <input type="hidden" name="page" value="${admins.currentPageNum}">--%>
<%--                <input type="hidden" name="size" value="${admins.currentPage.pageSize}">--%>
<%--                <input type="hidden" name="country" value="${pageDto.country}">--%>
            </form>

            <form class="pull-right" id="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
            </form>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>국가</th>
                    <th>주/도</th>
                    <th>시</th>
                    <th>분류</th>
                    <th>순번</th>
                    <th>관광지명</th>
                    <th>기본정보</th>
                    <th>설명</th>
                    <th>KR</th>
                    <th>EN</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${trips.result.content}" var="trips">
                    <tr>
                        <td><c:out value="${trips.country}"/></td>
                        <td><a href="#"><c:out value="${trips.region}"/></a></td>
                        <td><c:out value="${trips.city}"/></td>
                        <td><c:out value="${trips.code}"/></td>
                        <td>1</td>
                        <td><c:out value="${trips.name}"/></td>
                        <td><a href="#">O</a></td>
                        <td><a href="#">O</a></td>
                        <td><a href="#">O</a></td>
                        <td><a href="#">X</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="row">
<%--                <nav>--%>
<%--                    <div class="text-center">--%>
<%--                        <ul class="pagination">--%>
<%--                            <c:if test="${admins.prevPage!=null}">--%>
<%--                                <li class="page-item">--%>
<%--                                    <a href="${admins.prevPage.pageNumber+1}">PREV</a>--%>
<%--                                </li>--%>
<%--                            </c:if>--%>
<%--                            <c:forEach items="${admins.pageList}" var="p">--%>
<%--                                <li class="page-item ${p.pageNumber==admins.currentPageNum-1?"active":''}">--%>
<%--                                    <a href="${p.pageNumber+1}">${p.pageNumber+1}</a>--%>
<%--                                </li>--%>
<%--                            </c:forEach>--%>
<%--                            <c:if test="${admins.nextPage!=null}">--%>
<%--                                <li class="page-item">--%>
<%--                                    <a href="${admins.nextPage.pageNumber+1}">NEXT</a>--%>
<%--                                </li>--%>
<%--                            </c:if>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </nav>--%>
            </div>

            <form id="list" action="/admin/list" method="get">
                <div id="button" style="margin-top: 20px" class="pull-right">
                    <button class="btn btn-group" id="delete">삭제하기</button>
                    <button class="btn btn-group" id="add">추가하기</button>
                </div>

<%--                <input type="hidden" name="page" value="${admins.currentPageNum}">--%>
<%--                <input type="hidden" name="size" value="${admins.currentPage.pageSize}">--%>
<%--                <input type="hidden" name="country" value="${pageDto.country}">--%>
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
            listForm.find('[name="page"]').val($(this).attr('href'))
            listForm.submit();
        });

        var optForm = $("#optForm");

        $("#optForm #country, #optForm #count").change(function (e) {
            e.preventDefault();
            var country = $('#country').find(":selected").val();
            var size = $('#count').find(":selected").val();

            optForm.find("input[name='page']").val("1");
            optForm.find("input[name='country']").val(country);

            optForm.find("input[name='size']").val(size);
            optForm.submit();
        });


        $("#add").on("click",function (e) {
            e.preventDefault();
            listForm.attr("action","/admin/register");
            listForm.submit();
        });

        $("#delete").on("click", function (e) {
            var str = "";
            e.preventDefault();
            var deleteId = prompt("삭제할 admin의 번호를 입력하세요.");
            if (deleteId != null) {
                listForm.attr("action", "/admin/delete");
                listForm.attr("method", "post");
                str += "<input type='hidden' name='id'  value='" + deleteId + "'>";

                listForm.append(str);
                listForm.submit();
            }
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

