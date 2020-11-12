<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../include/header.jsp" %>

<div class="col-sm-9 page">
    <div class="row">
        <div class="container-fluid">
            <p>홈 > 투어 관리 > 구매정보 관리</p>
        </div>
        <div class="col-lg-12">
            <h3 class="page-header" style="color: gray">투어 관리</h3>
        </div>
        <br>
        <ul class="nav nav-tabs nav-justified">
            <li class="active"><a href="/tour/list">구매정보관리</a></li>
            <li><a href="#">구매코드 발급</a></li>
            <li><a href="#">구매코드 조회</a></li>
        </ul>
        <br>

        <div class="container">
            <div class="col-lg-12">
                <form id="optForm" action="/tour/list" method="get" style="display: inline">
                    <div class="col-lg-12">

                        <input type="date" id="tourDate" name="tourDate" style=" margin-bottom:10px"
                               value="<c:out value="${pageDto.tourDate}"/>">

                        <select id="tourType" style="margin-left:20px; margin-top: 10px; margin-bottom: 10px">
                            <option value="" <c:out value="${pageDto.tourType eq 'null' ? 'selected': ''}"/>>모든 투어
                            </option>
                            <option value="taxi" <c:out value="${pageDto.tourType eq 'taxi' ? 'selected': ''}"/>>택시 투어
                            </option>
                            <option value="other" <c:out value="${pageDto.tourType eq 'other' ? 'selected': ''}"/>>기타 투어
                            </option>
                        </select>
                    </div>

                    <select id="country">
                        <option value="" <c:out value="${pageDto.country == 'null' ? 'selected': ''}"/>>국적별 분류</option>
                        <option value="K" <c:out value="${pageDto.country eq 'K' ? 'selected': ''}"/>>KOREA
                        </option>
                        <option value="J" <c:out value="${pageDto.country eq 'J' ? 'selected': ''}"/>>JAPAN
                        </option>
                        <option value="C" <c:out value="${pageDto.country eq 'C' ? 'selected': ''}"/>>CHINA
                        </option>
                    </select>

                    <select size="1" id="count">
                        <option value=5 <c:out value="${pageDto.size eq 5 ? 'selected': ''}"/>>5건 노출</option>
                        <option value=6 <c:out value="${pageDto.size eq 6 ? 'selected': ''}"/>>6건 노출</option>
                        <option value=7 <c:out value="${pageDto.size eq 7 ? 'selected': ''}"/>>7건 노출</option>
                        <option value=8 <c:out value="${pageDto.size eq 8 ? 'selected': ''}"/>>8건 노출</option>
                        <option value=9 <c:out value="${pageDto.size eq 9 ? 'selected': ''}"/>>9건 노출</option>
                        <option value=10 <c:out value="${pageDto.size eq 10 ? 'selected': ''}"/>>10건 노출</option>
                    </select>

                    <select size="1" id="region">
                        <option value="">모든 주/도</option>
                        <option value="강원" <c:out value="${pageDto.region eq '강원' ? 'selected': ''}"/>>강원</option>
                        <option value="경기" <c:out value="${pageDto.region eq '경기' ? 'selected': ''}"/>>경기</option>
                    </select>

                    <select size="1" id="city">
                        <option value="">모든 도시</option>
                        <option value="서울" <c:out value="${pageDto.city eq '서울' ? 'selected': ''}"/>>서울</option>
                        <option value="영월" <c:out value="${pageDto.city eq '영월' ? 'selected': ''}"/>>영월</option>
                    </select>

                    <select size="1" id="driverName">
                        <option value="">담당 기사별 분류</option>
                        <option value="기사회원1" <c:out value="${pageDto.driverName eq '기사회원1' ? 'selected': ''}"/>>기사회원1
                        </option>
                        <option value="기사회원2" <c:out value="${pageDto.driverName eq '기사회원2' ? 'selected': ''}"/>>기사회원2
                        </option>
                        <option value="기사회원3" <c:out value="${pageDto.driverName eq '기사회원3' ? 'selected': ''}"/>>기사회원3
                        </option>
                    </select>

                    <input type="hidden" name="page" value="${tour.currentPageNum}">
                    <input type="hidden" name="size" value="${tour.currentPage.pageSize}">
                    <input type="hidden" name="country" value="${pageDto.country}">
                    <input type="hidden" name="city" value="${pageDto.city}">
                    <input type="hidden" name="region" value="${pageDto.region}">
                    <input type="hidden" name="driverName" value="${pageDto.driverName}">
                    <input type="hidden" name="tourDate" value="${pageDto.tourDate}">
                    <input type="hidden" name="tourType" value="${pageDto.tourType}">
                </form>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>날짜 / 시간</th>
                    <th>고객</th>
                    <th>담당기사</th>
                    <th>지역</th>
                    <th>인원</th>
                    <th>결제금액</th>
                    <th>시간</th>
                    <th>투어일정</th>
                    <th>완료</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${tour.result.content}" var="tour">
                    <tr>
                        <td><c:out value="${tour.id}"/></td>
                        <td><c:out value="${tour.tourDate}"/></td>
                        <td><a href="#"><c:out value="${tour.customer.name}"/></a></td>
                        <td><c:out value="${tour.driver.name}"/></td>
                        <td><c:out value="${tour.address.country}"/>/
                            <c:out value="${tour.address.region}"/>/
                            <c:out value="${tour.address.city}"/></td>
                        <td><c:out value="${tour.personCount}"/></td>
                        <td><c:out value="${tour.payment}"/></td>
                        <td><c:out value="${tour.takeTime}"/>시간</td>
                        <td><c:out value="${tour.visitCount}"/>곳방문</td>
                        <td>
                            <c:choose>
                                <c:when test="${tour.finish}"><a href="#">O</a></c:when>
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
                            <c:if test="${tour.prevPage!=null}">
                                <li class="page-item">
                                    <a href="${tour.prevPage.pageNumber+1}">PREV</a>
                                </li>
                            </c:if>
                            <c:forEach items="${tour.pageList}" var="p">
                                <li class="page-item ${p.pageNumber==tour.currentPageNum-1?"active":''}">
                                    <a href="${p.pageNumber+1}">${p.pageNumber+1}</a>
                                </li>
                            </c:forEach>
                            <c:if test="${tour.nextPage!=null}">
                                <li class="page-item">
                                    <a href="${tour.nextPage.pageNumber+1}">NEXT</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </nav>
            </div>

            <form id="list" action="/tour/list" method="get">
                <div id="button" style="margin-top: 20px" class="pull-right">
                    <button class="btn btn-default btn-lg" id="add">등록</button>
                    <button class="btn btn-default btn-lg" id="delete">삭제</button>
                </div>

                <input type="hidden" name="page" value="${tour.currentPageNum}">
                <input type="hidden" name="size" value="${tour.currentPage.pageSize}">
                <input type="hidden" name="country" value="${pageDto.country}">
                <input type="hidden" name="city" value="${pageDto.city}">
                <input type="hidden" name="region" value="${pageDto.region}">
                <input type="hidden" name="tourType" value="${pageDto.tourType}">
                <input type="hidden" name="tourDate" value="${pageDto.tourDate}">
            </form>
        </div>
    </div>
</div>
</div>

</div>
</body>

<script>
    var optForm = $("#optForm");

    $(document).ready(function () {
        var listForm = $("#list");
        optForm.find("input[name='userid']").val("");

        $(".pagination a").on("click", function (e) {
            e.preventDefault();
            listForm.find('[name="page"]').val($(this).attr('href'));
            listForm.submit();
        });

        $("#optForm #tourDate").change(function () {
            var tourDate = $("#tourDate").val();
            optForm.find("input[name='tourDate']").val(tourDate);

            optForm.submit();
        });

        $("#optForm #country, #optForm #count, #optForm #city, #optForm #region , #optForm #driverName,  #optForm #tourType").change(function (e) {
            e.preventDefault();
            var country = $('#country').find(":selected").val();
            var size = $('#count').find(":selected").val();
            var city = $("#city").find(":selected").val();
            var region = $("#region").find(":selected").val();
            var driverName = $('#driverName').find(":selected").val();
            var tourType = $("#tourType").find(":selected").val();

            optForm.find("input[name='page']").val("1");
            optForm.find("input[name='country']").val(country);
            optForm.find("input[name='size']").val(size);
            optForm.find("input[name='city']").val(city);
            optForm.find("input[name='region']").val(region);
            optForm.find("input[name='driverName']").val(driverName);
            optForm.find("input[name='tourType']").val(tourType);

            optForm.submit();
        });


        $("#add").on("click", function (e) {
            e.preventDefault();
            listForm.attr("action", "/tour/register");
            listForm.submit();
        });

        $("#delete").on("click", function (e) {
            var str = "";
            e.preventDefault();
            var deleteId = prompt("삭제할 tour의 번호를 입력하세요.");
            if (deleteId != null) {
                listForm.attr("action", "/tour/delete");
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

