<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src='<c:url value="/resources/js/image-center.js"/>'></script>
<div class="content">
    <div class="page">
        <c:forEach items="${conferences}" var="conference">
            <div class="box">
                <h1 class="title">
                    <c:out value="${conference.ordinalNumber}"/>-й IT-субботник
                    <span class="title-text">прошел</span>
                    <span class="title-date"><c:out value="${conference.humanReadableDate}"/></span>
                    <span>в компании</span>
                    <a href='<c:url value="${conference.company.site}"/>' target="_blank"><span class="event-location"><c:out value="${conference.company.name}"/></span></a>
                </h1>
                <div class="box-content">
                    <c:forEach items="${reports}" var="report">
                        <c:if test="${report.conference.id == conference.id}">
                            <div class="report center-item">
                                <div class="reporter inline-item">
                                    <div class="reporter-title">
                                        <h3 class="name">
                                            <a href='<c:url value="/user/${report.user.id}"/>'><c:out value="${report.user.firstName}"/>&nbsp;<c:out value="${report.user.secondName}"/></a>
                                        </h3>

                                        <div class="position">
                                            <%@ include file="/WEB-INF/view/jsp/job-position-viewing.jsp" %>
                                        </div>
                                    </div>
                                    <%@ include file="/WEB-INF/view/jsp/photo-viewing.jsp" %>
                                </div>
                                <div class="description">
                                    <h2 class="description-title">
                                        <a href='<c:url value="/report/${report.id}"/>'>&laquo;<c:out value="${report.title}"/>&raquo;</a>
                                    </h2>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
