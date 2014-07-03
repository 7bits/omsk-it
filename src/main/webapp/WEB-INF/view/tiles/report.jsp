<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                &laquo;<c:out value="${report.title}"/>&raquo;
            </h1>

            <div class="report-content">
                <div class="like-button">
                    <div class="tweet-like">
                        <a href="https://twitter.com/share" class="twitter-share-button" data-lang="ru" data-text="<c:out value="${report.description}"/>">Tweet</a>
                    </div>
                    <div class="vk-like">
                        <script type="text/javascript">
                            document.write(VK.Share.button({
                                title: "<c:out value="${report.title}"/>",
                                description: "<c:out value="${report.description}"/>"},{type: "round", text: "Мне нравится", eng: 1}));
                        </script>
                    </div>
                </div>
                <div class="reporter inline-item">
                    <%@ include file="/WEB-INF/view/jsp/photo-viewing.jsp" %>
                    <div class="personal">
                        <h3 class="name">
                            <a href='<c:url value="/user/${report.user.id}"/>'><c:out value="${report.user.firstName}"/>&nbsp;<c:out value="${report.user.secondName}"/></a>
                        </h3>
                        <div class="position">
                            <%@ include file="/WEB-INF/view/jsp/job-position-viewing.jsp" %>
                        </div>
                    </div>
                </div>
                <div class="description">
                    <c:out value="${report.description}"/>
                </div>
                <c:if test="${report.presentation != null}">
                    <div class="presentation">
                        <iframe src='<c:out value="${report.presentation}"/>' width="635" height="514" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" allowfullscreen></iframe>
                    </div>
                </c:if>
                <c:if test="${report.presentation == null}">
                    <br>
                    <p class="resource-not-found">Ссылка на презентацию не предоставлена.</p>
                </c:if>
                <c:if test="${report.video != null}">
                    <div class="video">
                        <iframe src='<c:out value="${report.video}"/>' width="635" height="355" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe>
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
                                    <p><a class ="link-bold" href='<c:url value="/report/${otherReport.id}"/>'>&laquo;<c:out value="${otherReport.title}"/>&raquo;</a> - "${otherReport.conference.humanReadableDate}"</p>
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
