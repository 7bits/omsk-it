<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="next-event">
            <c:if test="${nextConference != null}">
                <p class="event-title">
                Следующий (<c:out value="${nextConference.ordinalNumber}"/>-й) субботник пройдёт
                <span class="event-date"><c:out value="${nextConference.humanReadableDate}"/></span>
                </p>
            </c:if>
            <p class="next-event-text">
                Чтобы не пропустить начало регистрации, следите за нами в <a class ="link-light link-bold" href="https://twitter.com/OmskIT">Твиттере</a> и <a class ="link-light link-bold" href="http://vk.com/omskit">ВКонтакте</a>.
                <br>Или оставьте свой e-mail, мы сообщим вам сами:
            </p>
            </span>
            <div class="subscribe-center">

                <%@ include file="/WEB-INF/view/jsp/_subscription_form.jsp" %>

            </div>
        </div>

        <%@ include file="/WEB-INF/view/jsp/_like-button.jsp" %>

        <div class="box">
            <h1 class="title">
                <c:out value="${conference.ordinalNumber}"/>-й IT-субботник
                <span class="title-text">прошел</span>
                <span class="title-date"><c:out value="${conference.humanReadableDate}"/></span>
                <span>,</span>
                <c:choose>
                    <c:when test="${conference.company.isHaveLink()}">
                        <a class="link-clear" href='<c:url value="${conference.company.site}"/>' target="_blank">
                            <span class="event-location">
                                <c:out value="${conference.company.name}"/>
                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <span>
                            <c:out value="${conference.company.name}"/>
                        </span>
                    </c:otherwise>
                </c:choose>
            </h1>

            <%--<jsp:include page="/WEB-INF/view/jsp/_reports_preview.jsp">--%>
                <%--<jsp:param name="reports" value="#{conference.reports}"/>--%>
            <%--</jsp:include>--%>
            <%@ include file="/WEB-INF/view/jsp/_reports_preview.jsp" %>

        </div>

        <%@ include file="/WEB-INF/view/jsp/_index-header.jsp" %>

    </div>
</div>
