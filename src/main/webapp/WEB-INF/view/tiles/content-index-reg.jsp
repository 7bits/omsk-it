<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/view/jsp/success-guest-registration.jsp" %>
<div class="content">
    <div class="page">
        <div class="guest-form-div">
            <%@ include file="/WEB-INF/view/jsp/popup-registration-form.jsp" %>
        </div>
        <div class="next-event">
            <c:out value="${conference.ordinalNumber}"/>-й IT-субботник пройдет
            <span class="event-date"><c:out value="${conference.humanReadableDate}"/></span>
            <c:if test="${conference.company != null}">
                <br>в компании
                <a href='<c:url value="${conference.company.site}"/>' target="_blank"><span class="event-location"><c:out value="${conference.company.name}"/></span></a>
            </c:if>
            <a class="js-guest-register-button" href="#">
                <div class="button-submit registration">
                    Зарегистрироваться
                </div>
            </a>
        </div>

        <div class="box">
            <h1 class="title">
                Программа <c:out value="${conference.ordinalNumber}"/>-го IT-субботника
            </h1>
            <c:forEach items="${reports}" var="report">
                <div class="report">
                    <div class="reporter inline-item">
                        <div class="name">
                            <a href='<c:url value="/reporter/${report.user.id}"/>'><c:out value="${report.user.firstName}"/>&nbsp;<c:out value="${report.user.secondName}"/></a>
                        </div>

                        <div class="position">
                            <%@ include file="/WEB-INF/view/jsp/job-position-viewing.jsp" %>
                        </div>
                        <%@ include file="/WEB-INF/view/jsp/photo-viewing.jsp" %>
                    </div>

                    <div class="description inline-item">
                        <h2 class="description-title">
                            <a href='<c:url value="/report/${report.id}"/>'>&laquo;<c:out value="${report.title}"/>&raquo;</a>
                        </h2>

                        <div class="text">
                            <c:out value="${report.description}"/>
                        </div>
                    </div>

                    <hr class="bottom-line">
                </div>
            </c:forEach>
        </div>

        <div class="events-history">
            <a href='<c:url value="/archive"/>'>Материалы предыдущих субботников</a>
        </div>

        <div class="action">
            <div class="action-text">
                Чтобы стать активным участником IT-субботников, вы можете:
            </div>

            <div class="buttons">
                <a href='<c:url value="/to-reporters#suggest"/>' class="left-button">
                    <div class="button inline-item">
                        <div class="button-img">
                            <img src='<c:url value="/resources/images/left-button.png"/>'>
                        </div>
                        <img class="img-center" src='<c:url value="/resources/images/button-shape.png"/>'>
                        <span>Предложить тему доклада</span>
                    </div>
                </a>

                <a href='<c:url value="/to-reporters"/>' class="middle-button">
                    <div class="button inline-item">
                        <div class="button-img">
                            <img src='<c:url value="/resources/images/middle-button.png"/>'>
                        </div>
                        <img class="img-center" src='<c:url value="/resources/images/button-shape.png"/>'>
                        <span>Выступить с докладом на субботнике</span>
                    </div>
                </a>

                <a href='<c:url value="/to-companies"/>' class="right-button">
                    <div class="button inline-item">
                        <div class="button-img">
                            <img src='<c:url value="/resources/images/right-button.png"/>'>
                        </div>
                        <img class="img-center" src='<c:url value="/resources/images/button-shape.png"/>'>
                        <span>Провести субботник у себя в офисе</span>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
