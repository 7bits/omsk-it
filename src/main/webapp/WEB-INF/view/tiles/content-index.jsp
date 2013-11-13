<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="guest-form-div">
            <%@ include file="/WEB-INF/view/jsp/register.jsp" %>
        </div>
        <div class="next-event-registration">
            <div class="title">
                <span class="line">
                    <c:out value="${conference.ordinalNumber}"/>-й IT-субботник пройдет
                    <span class="event-date"><c:out value="${conference.humanReadableDate}"/></span>
                    <br>в компании
                    <span class="event-location"><a href='<c:url value="${conference.company.site}"/>'><c:out value="${conference.company.name}"/></a></span>
                </span>
            </div>

            <div class="join-button">
                <button class="js-register-button">Зарегистрироваться</button>
            </div>
        </div>

        <div class="next-event-program">
            <div class="program-header">
                Программа <c:out value="${conference.ordinalNumber}"/>-го IT-субботника
            </div>

            <div class="program-content">
                <c:forEach items="${reports}" var="report">
                    <div class="report">
                        <div class="reporter">
                            <div class="name">
                                <a href='<c:url value="/reporter/${report.reporter.id}"/>'><c:out value="${report.reporter.firstName}"/>&nbsp;<c:out value="${report.reporter.secondName}"/></a>
                            </div>

                            <div class="position">
                                <c:out value="${report.reporter.jobPosition}"/>, <a href='<c:url value="${report.reporter.company.site}"/>'><c:out value="${report.reporter.company.name}"/></a>
                            </div>

                            <div class="photo">
                                <img src='<c:url value="${report.reporter.photo}"/>'>
                            </div>
                        </div>

                        <div class="description">
                            <div class="title">
                                <a href='<c:url value="/report/${report.id}"/>'>&laquo;<c:out value="${report.title}"/>&raquo;</a>
                            </div>

                            <div class="text">
                                <c:out value="${report.description}"/>
                            </div>
                        </div>

                        <hr class="bottom-line">
                    </div>
                </c:forEach>
            </div>
        </div>

        <div class="events-history">
            <a href='<c:url value="/archive"/>'>Материалы предыдущих субботников</a>
        </div>

        <div class="action">
            <div class="title">
                Чтобы стать активным участником IT-субботников, вы можете:
            </div>

            <div class="buttons">
                <button class="js-guests-button left-button">
                    <div class="button-img"><img src='<c:url value="/resources/images/left-button.png"/>'></div>
                    <img src='<c:url value="/resources/images/button-shape.png"/>'>
                    <span>Предложить тему доклада</span>
                </button>

                <button class="js-reporters-button middle-button">
                    <div class="button-img"><img src='<c:url value="/resources/images/middle-button.png"/>'></div>
                    <img src='<c:url value="/resources/images/button-shape.png"/>'>
                    <span>Выступить с докладом на субботнике</span>
                </button>

                <button class="js-companies-button right-button">
                    <div class="button-img"><img src='<c:url value="/resources/images/right-button.png"/>'></div>
                    <img src='<c:url value="/resources/images/button-shape.png"/>'>
                    <span>Провести субботник у себя в офисе</span>
                </button>
            </div>
        </div>
    </div>
</div>
