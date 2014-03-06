<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="next-event">
            Следующий (<c:out value="${conference.ordinalNumber}"/>-й) субботник пройдёт
            <span class="event-date"><c:out value="${conference.humanReadableDate}"/></span>
            <p class="next-event-text">
                Чтобы не пропустить начало регистрации, следите за нами в <a href="https://twitter.com/OmskIT">Твиттере</a> и <a href="http://vk.com/omskit">ВКонтакте</a>.
                <br>Или оставьте свой e-mail, мы сообщим вам сами:
            </p>
            </span>
            <form class="js-subscribe-form subscribe-form" action='<c:url value="/subscribe"/>' method="POST">
                <input class="input-email" type="email" name="email" placeholder="Электронная почта">
                <input class="js-subscribe-button subscribe-button" type="submit" value="Отправить">
            </form>
        </div>

        <div class="box">
            <h1 class="title">
                <c:out value="${pastConference.ordinalNumber}"/>-й IT-субботник
                <span class="title-text">прошел</span>
                <span class="title-date"><c:out value="${pastConference.humanReadableDate}"/></span>
                <span>в компании</span>
                <a href='<c:url value="${pastConference.company.site}"/>' target="_blank"><span class="event-location"><c:out value="${pastConference.company.name}"/></span></a>
            </h1>
            <c:forEach items="${reports}" var="report">
                <div class="report">
                    <div class="reporter inline-item">
                        <div class="name">
                            <a href='<c:url value="/user/${report.user.id}"/>'><c:out value="${report.user.firstName}"/>&nbsp;<c:out value="${report.user.secondName}"/></a>
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