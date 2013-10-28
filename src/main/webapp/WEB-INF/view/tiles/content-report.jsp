<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">
    <div class="page">
        <div class="detail-report">
            <div class="report-header">
                &laquo;<c:out value="${report.title}"/>&raquo;
            </div>

            <div class="report-content">
                <div class="reporter">
                    <div class="photo">
                        <img src='<c:url value="${report.reporter.photo}"/>'>
                    </div>

                    <div class="name">
                        <a href='<c:url value="/reporter/${report.reporter.id}"/>'><c:out value="${report.reporter.firstName}"/>&nbsp;<c:out value="${report.reporter.secondName}"/></a>
                    </div>

                    <div class="position">
                        <c:out value="${report.reporter.jobPosition}"/>, <a href='<c:url value="${report.reporter.company.site}"/>'><c:out value="${report.reporter.company.name}"/></a>
                    </div>
                </div>

                <div class="description">
                    <c:out value="${report.description}"/>
                </div>

                <c:if test="${report.presentation != null}">
                    <div class="presentation">
                        <iframe src='<c:url value="${report.presentation}"/>' width="635" height="514" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" allowfullscreen></iframe>
                    </div>
                </c:if>

                <c:if test="${report.presentation == null}">
                    <br>
                    <p class="resource-not-found">Ссылка на презентацию не предоставлена.</p>
                </c:if>

                <c:if test="${report.video != null}">
                    <div class="video">
                        <iframe src='<c:url value="${report.video}"/>' width="635" height="355" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
                    </div>
                </c:if>

                <c:if test="${report.video == null}">
                    <p class="resource-not-found">Ссылка на видео не предоставлена.</p>
                </c:if>

                <c:set var="totalReports" value="${fn:length(otherReports)}"/>
                <c:if test="${totalReports > 1}">
                    <div class="reporter-other-reports">
                        <div class="title">
                            Другие доклады автора:
                        </div>

                        <div class="refs">
                            <c:forEach items="${otherReports}" var="otherReport">
                                <c:if test="${otherReport.id != report.id}">
                                    <p><a href='<c:url value="/report/${otherReport.id}"/>'>&laquo;<c:out value="${otherReport.title}"/>&raquo;</a></p>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </c:if>
                <c:if test="${totalReports <= 1}">
                    <p class="resource-not-found">Других докладов данного автора не найдено.</p>
                </c:if>
            </div>
        </div>
    </div>
</div>
