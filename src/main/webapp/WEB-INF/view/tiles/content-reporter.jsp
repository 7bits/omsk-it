<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">
    <div class="page">
        <div class="reporter-review">
            <div class="review-header">
                <c:out value="${reporter.firstName}"/>&nbsp;<c:out value="${reporter.secondName}"/>
            </div>

            <div class="review-content">
                <div class="title">
                    <div class="photo">
                        <img src='<c:url value="${reporter.photo}"/>'>
                    </div>

                    <div class="short-description">
                        <div class="position">
                            <c:out value="${reporter.jobPosition}"/>, <a href='<c:url value="${reporter.company.site}"/>'><c:out value="${reporter.company.name}"/></a>
                        </div>

                        <c:out value="${reporter.selfDescription}"/>
                        <c:if test="${reporter.selfDescription == null}">
                            Докладчик ничего о себе не написал.
                        </c:if>
                    </div>
                </div>

                <c:set var="totalReports" value="${fn:length(reports)}"/>
                <c:if test="${totalReports == 0}">
                    С докладами не выступал.
                </c:if>
                <c:if test="${totalReports > 0}">
                    <div class="reports-history">
                        <div class="title">
                            Выступил с докладами:
                        </div>

                        <c:forEach items="${reports}" var="report">
                            <div class="report">
                                <div class="presentation">
                                    <c:if test="${report.presentation != null}">
                                        <iframe src='<c:url value="${report.presentation}"/>' width="291" height="216" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" allowfullscreen></iframe>
                                    </c:if>
                                    <c:if test="${report.presentation == null}">
                                        <p class="resource-not-found">Ссылка на презентацию не предоставлена.</p>
                                    </c:if>
                                </div>

                                <div class="description">
                                    <div class="title">
                                        <a href='<c:url value="/report/${report.id}"/>'>&laquo;<c:out value="${report.title}"/>&raquo;</a>
                                    </div>

                                    <div class="text">
                                        <c:out value="${report.description}"/>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
