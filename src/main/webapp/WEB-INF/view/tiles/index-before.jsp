<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="next-event">
            <p class="event-title">
            (<c:out value="${nextConference.ordinalNumber}"/>-й) субботник пройдёт
            <span class="event-date"><c:out value="${nextConference.humanReadableDate}"/></span>
            </p>
            <p class="next-event-text">
                Регистрация еще не открылась, но уже совсем скоро.
                <br>Чтобы не пропустить начало регистрации, следите за нами в <a class ="link-light link-bold" href="https://twitter.com/OmskIT">Твиттере</a> и <a class ="link-light link-bold" href="http://vk.com/omskit">ВКонтакте</a>.
                <br>Или оставьте свой e-mail, мы сообщим вам сами:
            </p>
            </span>
            <div class="subscribe-center">
                <form class="js-subscribe-form-top subscribe-form" action='<c:url value="/subscribe"/>' method="POST">
                    <input class="input pos-email" type="email" name="email" placeholder="Электронная почта">
                    <input class="js-subscribe-button-top pos-btn-subscribe btn-gradient btn-subscribe" type="submit" value="Отправить">
                </form>
                <div class="js-subscribe-response-top subscribe-response-top response"></div>
            </div>
        </div>
        <div class="main-like-button">
            <div class="tweet-like">
                <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://saturdays.omskit.org/" data-text="Омские IT-субботники (OmskIT)" data-lang="ru" data-count="none">Твитнуть</a>
            </div>
            <div class="vk-like">
                <script type="text/javascript"><!--
                document.write(VK.Share.button({url: "http://saturdays.omskit.org/", title: "Омские IT-субботники (OmskIT)", image: "http://saturdays.omskit.org/", description: "IT-субботники - это мини-конференции, состоящие из 3-4 докладов и свободного времени, в течении которого посетители могут общаться между собой"},{type: "round_nocount", text: "Мне нравится", eng: 1}));
                --></script>
            </div>
        </div>
        <div class="box">
            <h1 class="title">
                <c:out value="${nextConference.ordinalNumber}"/>-й IT-субботник
                <span class="title-text">пройдет</span>
                <span class="title-date"><c:out value="${nextConference.humanReadableDate}"/></span>
                <span>,</span>
                <c:choose>
                    <c:when test="${nextConference.company.isHaveLink()}">
                        <a class="link-clear" href='<c:url value="${nextConference.company.site}"/>' target="_blank">
                            <span class="event-location">
                                <c:out value="${nextConference.company.name}"/>
                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                        <span>
                            <c:out value="${nextConference.company.name}"/>
                        </span>
                    </c:otherwise>
                </c:choose>
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

        <%@ include file="/WEB-INF/view/jsp/_index-header.jsp" %>

    </div>
</div>
