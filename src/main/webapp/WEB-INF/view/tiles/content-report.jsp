<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                &laquo;<c:out value="${report.title}"/>&raquo;
            </h1>

            <div class="report-content">
                <div class="reporter inline-item">
                    <c:choose>
                        <c:when test="${report.reporter.photo == '' }">
                            <img class="photo" src='/resources/images/photos/nophoto.png'>
                        </c:when>
                        <c:when test="${report.reporter.photo == null }">
                            <img class="photo" src='/resources/images/photos/nophoto.png'>
                        </c:when>
                        <c:otherwise>
                            <img class="photo" src='/resources/images/photos/<c:url value="${report.reporter.photo}"/>'>
                        </c:otherwise>
                    </c:choose>
                    <div class="personal">
                        <h3 class="name">
                            <a href='<c:url value="/reporter/${report.reporter.id}"/>'><c:out value="${report.reporter.firstName}"/>&nbsp;<c:out value="${report.reporter.secondName}"/></a>
                        </h3>
                        <div class="position">
                            <c:out value="${report.reporter.jobPosition}"/>, <a href='<c:url value="${report.reporter.company.site}"/>' target="_blank"><c:out value="${report.reporter.company.name}"/></a>
                        </div>
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
                        <div class="reporter-reports-title">
                            Другие доклады автора:
                        </div>

                        <div class="reporter-reports-refs">
                            <c:forEach items="${otherReports}" var="otherReport">
                                <c:if test="${otherReport.id != report.id}">
                                    <p><a href='<c:url value="/report/${otherReport.id}"/>'>&laquo;<c:out value="${otherReport.title}"/>&raquo;</a> - "${otherReport.conference.humanReadableDate}"</p>
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
