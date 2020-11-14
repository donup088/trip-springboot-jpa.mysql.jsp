<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/header.jsp" %>

<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 공지사항 > 공지사항 관리</p>
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
        <br>

        <div class="container">
            <form id="optForm" action="/notice/list" method="get" style="display: inline">
                <select size="1" id="count">
                    <option value=5 <c:out value="${pageDto.size eq 5 ? 'selected': ''}"/>>5건 노출</option>
                    <option value=6 <c:out value="${pageDto.size eq 6 ? 'selected': ''}"/>>6건 노출</option>
                    <option value=7 <c:out value="${pageDto.size eq 7 ? 'selected': ''}"/>>7건 노출</option>
                    <option value=8 <c:out value="${pageDto.size eq 8 ? 'selected': ''}"/>>8건 노출</option>
                    <option value=9 <c:out value="${pageDto.size eq 9 ? 'selected': ''}"/>>9건 노출</option>
                    <option value=10 <c:out value="${pageDto.size eq 10 ? 'selected': ''}"/>>10건 노출</option>
                </select>

                <input type="hidden" name="page" value="${notice.currentPageNum}">
                <input type="hidden" name="size" value="${notice.currentPage.pageSize}">

            </form>

            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>관리자 id</th>
                    <th>날짜</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>상단노출</th>
                    <th>숨김여부</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${notice.result.content}" var="notice">
                    <tr>
                        <td><c:out value="${notice.id}"/></td>
                        <td><a href="#"><c:out value="${notice.admin.userid}"/></a></td>
                        <td><c:out value="${notice.createdDate}"/></td>
                        <td><a href="/notice/get?id=<c:out value="${notice.id}"/>"><c:out value="${notice.title}"/></a></td>
                        <td><c:out value="${notice.count}"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${notice.top}"><a href="#">O</a></c:when>
                                <c:otherwise><a href="#">X</a></c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${notice.secret}"><a href="#">O</a></c:when>
                                <c:otherwise><a href="#">X</a></c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="row">
                <nav>
                    <div class="text-center">
                        <ul class="pagination">
                            <c:if test="${notice.prevPage!=null}">
                                <li class="page-item">
                                    <a href="${notice.prevPage.pageNumber+1}">PREV</a>
                                </li>
                            </c:if>
                            <c:forEach items="${notice.pageList}" var="p">
                                <li class="page-item ${p.pageNumber==notice.currentPageNum-1?"active":''}">
                                    <a href="${p.pageNumber+1}">${p.pageNumber+1}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${notice.nextPage!=null}">
                                <li class="page-item">
                                    <a href="${notice.nextPage.pageNumber+1}">NEXT</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </nav>
                <select id="orderby_id" class="pull-right">
                    <option>최신순 정렬</option>
                </select>
            </div>

            <form id="list" action="/notice/list" method="get">
                <div id="button" style="margin-top: 20px" class="pull-right">
                    <button class="btn btn-group" id="delete">삭제하기</button>
                    <button class="btn btn-group" id="add">추가하기</button>
                </div>
                <input type="hidden" name="page" value="${notice.currentPageNum}">
                <input type="hidden" name="size" value="${notice.currentPage.pageSize}">
            </form>
        </div>
    </div>
</div>
</div>

</div>
</body>

<script>
    var optForm = $("#optForm");

    function goSearch(e) {
        var userid = $("#search").val();
        var country = $('#country').find(":selected").val();
        var size = $('#count').find(":selected").val();
        optForm.find("input[name='page']").val("1");
        optForm.find("input[name='country']").val(country);
        optForm.find("input[name='size']").val(size);
        optForm.find("input[name='userid']").val(userid);

        optForm.submit();
    };

    $(document).ready(function () {
        var listForm = $("#list");
        optForm.find("input[name='userid']").val("");
        $("#title").on("click", function (e) {
            var str = "";
            listForm.attr("method", "get")
            listForm.attr("action", "/notice/get")
            listForm.append(str);
            listForm.submit();
        })

        $(".pagination a").on("click", function (e) {
            e.preventDefault();
            listForm.find('[name="page"]').val($(this).attr('href'))
            listForm.submit();
        });

        $("#optForm #country, #optForm #count").change(function (e) {
            e.preventDefault();
            var country = $('#country').find(":selected").val();
            var size = $('#count').find(":selected").val();
            optForm.find("input[name='page']").val("1");
            optForm.find("input[name='country']").val(country);
            optForm.find("input[name='size']").val(size);

            optForm.submit();
        });


        $("#add").on("click", function (e) {
            e.preventDefault();
            listForm.attr("action", "/notice/register");
            listForm.submit();
        });

        $("#delete").on("click", function (e) {
            var str = "";
            e.preventDefault();
            var deleteId = prompt("삭제할 공지사항의 번호를 입력하세요.");
            if (deleteId != null) {
                listForm.attr("action", "/notice/delete");
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

