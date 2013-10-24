<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="next-event-registration">
            <div class="title">
                <span class="line">
                    <c:out value="${conference.ordinalNumber}"/> IT-субботник пройдет
                    <span class="event-date"><c:out value="${conference.humanReadableDate}"/></span>
                    <br>в компании
                    <span class="event-location"><a href='<c:out value="${conference.company.site}"/>'><c:out value="${conference.company.name}"/></a></span>
                </span>
            </div>

            <div class="join-button">
                <button>Зарегистрироваться</button>
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
                                <a href='reporter/<c:out value="${report.reporter.id}"/>'><c:out value="${report.reporter.firstName}"/>&nbsp;<c:out value="${report.reporter.secondName}"/></a>
                            </div>

                            <div class="position">
                                <c:out value="${report.reporter.jobPosition}"/>, <a href='<c:out value="${report.reporter.company.site}"/>'><c:out value="${report.reporter.company.name}"/></a>
                            </div>

                            <div class="photo">
                                <img src='<c:out value="${report.reporter.photo}"/>'>
                            </div>
                        </div>

                        <div class="description">
                            <div class="title">
                                <a href='report/<c:out value="${report.id}"/>'>&laquo;<c:out value="${report.title}"/>&raquo;</a>
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
            <a href="archive">Материалы предыдущих субботников</a>
        </div>

        <div class="action">
            <div class="title">
                Чтобы стать активным участником IT-субботников, вы можете:
            </div>

            <div class="buttons">
                <button class="left-button">
                    <div class="button-img"><img src="resources/images/left-button.png"></div>
                    <img src="resources/images/button-shape.png">
                    <span>Предложить тему доклада</span>
                </button>

                <button class="middle-button">
                    <div class="button-img"><img src="resources/images/middle-button.png"></div>
                    <img src="resources/images/button-shape.png">
                    <span>Выступить с докладом на субботнике</span>
                </button>

                <button class="right-button">
                    <div class="button-img"><img src="resources/images/right-button.png"></div>
                    <img src="resources/images/button-shape.png">
                    <span>Провести субботник у себя в офисе</span>
                </button>
            </div>
        </div>
    </div>
</div>
