<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                <c:out value="${user.firstName}"/>&nbsp;<c:out value="${user.secondName}"/>
            </h1>
            <div class="box-content">
                <div class="reporter-about">
                    <c:choose>
                        <c:when test="${user.photo == null}">
                            <img class="photo" src='<c:url value="/resources/images/photos/nophoto.png" />' />
                        </c:when>
                        <c:otherwise>
                            <img class="photo" src='<c:url value="/resources/images/photos/${user.photo}" />' />
                        </c:otherwise>
                    </c:choose>
                    <div class="short-description">
                        <span class="position">
                            <c:choose>
                                <c:when test="${user.jobPosition == null}">
                                    <a href='<c:url value="${user.company.site}"/>' target="_blank"><c:out value="${user.company.name}"/></a>
                                </c:when>
                                <c:otherwise>
                                    <c:out value="${user.jobPosition}"/>, <a href='<c:url value="${user.company.site}"/>' target="_blank"><c:out value="${user.company.name}"/></a>
                                </c:otherwise>
                            </c:choose>
                        </span>
                        <br>
                        <c:out value="${user.selfDescription}"/>
                        <c:if test="${user.selfDescription == null}">
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
                            <div class="reporter-reports-title">
                                Выступил с докладами:
                            </div>

                            <c:forEach items="${reports}" var="report">
                                <div class="report">
                                    <div class="presentation  inline-item">
                                        <c:if test="${report.presentation != null}">
                                            <iframe src='<c:out value="${report.presentation}"/>' width="291" height="216" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" allowfullscreen></iframe>
                                        </c:if>
                                        <c:if test="${report.presentation == null}">
                                            <p class="resource-not-found">Ссылка на презентацию не предоставлена.</p>
                                        </c:if>
                                    </div>

                                    <div class="description inline-item">
                                        <div class="description-title">
                                            <a href='<c:url value="/report/${report.id}"/>'>&laquo;<c:out value="${report.title}"/>&raquo;</a>
                                        </div>

                                        <div class="text">
                                            <c:out value="${report.description}"/>
                                        </div>
                                        <p>"${report.conference.humanReadableDate}"</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:if>
            </div>        
        </div>
    </div>
</div>
