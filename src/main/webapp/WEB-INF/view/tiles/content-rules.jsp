<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">
    <div class="page">
        <div class="about">
            <span class="project-name">IT-субботники</span> - это мини-конференции, состоящие из 3-4 докладов и свободного времени,
            в течении которого посетители могут общаться между собой.<br>
            <br>
            Также планируется вызывать выдающихся представителей IT-сферы из других городов
            для проведения мастер-классов.
        </div>

        <div class="recomendations">
            <div class="title">
                Правила IT-субботников
            </div>

            <div class="text">
                <ol>
                    <li><span class="list-num">1</span> <b>Это бесплатно!</b></li>
                    <li><span class="list-num">2</span>
                        <span class="long-line">
                            Субботники проходят <b>в омских IT-фирмах</b> (
                                <c:set var="totalCompanies" value="${fn:length(companies)}"/>

                                <c:forEach items="${companies}" var="company" varStatus="companyCounter">
                                    <a href='<c:url value="${company.site}"/>'><c:out value="${company.name}"/></a><c:if test="${companyCounter.count < totalCompanies}">,&nbsp;</c:if>
                                </c:forEach>
                            ).
                        </span>
                    </li>
                    <li><span class="list-num">3</span> Если вам нужна помощь с докладом (прослушать, поревьювить) - мы поможем!</li>
                    <li><span class="list-num">4</span> Регистрация на каждое мероприятие <b>обязательна</b>.</li>
                    <li><span class="list-num">5</span> Тот, кто регистрируется, но не приходит, попадает в черный список.</li>
                    <li><span class="list-num">6</span> Проводится <b>в первую субботу месяца, с 11:00 до 15:00</b>, невзирая на лишения и ураганы.</li>
                    <li><span class="list-num">7</span>
                        <span class="blue-ref">
                            Вы всегда можете помочь в организации, написав организаторам на
                            <a href="mailto:admin@omskit.org">admin@omskit.org</a>
                        </span>
                    </li>
                </ol>
            </div>
        </div>

        <div class="events-archive">
            Если вы еще не поняли, что здесь происходит, смотрите <a href='<c:url value="/archive"/>'>материалы предыдущих субботников.</a>
        </div>

        <div class="action">
            <div class="title">
                Чтобы стать активным участником IT-субботников, вы можете:
            </div>

            <div class="buttons">
                <button class="left-button">
                    <div class="button-img"><img src='<c:url value="/resources/images/left-button.png"/>'></div>
                    <img src='<c:url value="/resources/images/button-shape.png"/>'>
                    <span>Предложить тему доклада</span>
                </button>

                <button class="middle-button">
                    <div class="button-img"><img src='<c:url value="/resources/images/middle-button.png"/>'></div>
                    <img src='<c:url value="/resources/images/button-shape.png"/>'>
                    <span>Выступить с докладом на субботнике</span>
                </button>

                <button class="right-button">
                    <div class="button-img"><img src='<c:url value="/resources/images/right-button.png"/>'></div>
                    <img src='<c:url value="/resources/images/button-shape.png"/>'>
                    <span>Провести субботник у себя в офисе</span>
                </button>
            </div>
        </div>
    </div>
</div>