<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="content">
    <div class="page">
        <div class="text-content-up">
            <span class="project-name">IT-субботники</span> - это мини-конференции, состоящие из 3-4 докладов и свободного времени,
            в течении которого посетители могут общаться между собой.<br>
            <br>
            Также планируется вызывать выдающихся представителей IT-сферы из других городов
            для проведения мастер-классов.
        </div>

        <div class="box">
            <h1 class="title">
                Правила IT-субботников
            </h1>
            <div class="list">
                <ol>
                    <li><span class="list-num">1</span> <b>Это бесплатно!</b></li>
                    <li><span class="list-num">2</span>
                        <span class="long-line">
                            Субботники проходят <b>в омских IT-фирмах</b> (
                            <c:set var="totalCompanies" value="${fn:length(companies)}"/>
                            <c:forEach items="${companies}" var="company" varStatus="companyCounter">
                                <a class="link-blue" href='<c:url value="${company.site}"/>' target="_blank"><c:out value="${company.name}"/></a><c:if test="${companyCounter.count < totalCompanies}">,&nbsp;</c:if>
                            </c:forEach>
                        ).
                        </span>
                    </li>
                    <li><span class="list-num">3</span> Если вам нужна помощь с докладом (прослушать, поревьювить) - мы поможем!</li>
                    <li><span class="list-num">4</span> Регистрация на каждое мероприятие <b>обязательна</b>.</li>
                    <li><span class="list-num">5</span> Тот, кто регистрируется, но не приходит, попадает в черный список.</li>
                    <li><span class="list-num">6</span> Проводится <b>в первую субботу месяца, с 11:00 до 15:00</b>, невзирая на лишения и ураганы.</li>
                    <li><span class="list-num">7</span>
                        <span class="long-line">
                        Вы всегда можете помочь в организации, написав организаторам на
                            <a class="link-blue" href="mailto:admin@omskit.org">admin@omskit.org</a>
                        </span>
                    </li>
                </ol>
            </div>
        </div>
        <div class="events-history">
            Если вы еще не поняли, что здесь происходит, смотрите <a class="link-light" href='<c:url value="/archive"/>'>материалы предыдущих субботников.</a>
        </div>

        <%@ include file="/WEB-INF/view/jsp/_action_button.jsp" %>

    </div>
</div>
