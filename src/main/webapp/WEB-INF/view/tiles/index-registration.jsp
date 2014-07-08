<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/view/jsp/guest-registration-response.jsp" %>

<div class="content">
    <div class="page">
        <%@ include file="/WEB-INF/view/jsp/popup-registration-form.jsp" %>
        <div class="next-event">
            <p class="event-title">
                <c:out value="${nextConference.ordinalNumber}"/>-й IT-субботник пройдет
            <span class="event-date"><c:out value="${nextConference.humanReadableDate}"/></span>
            <c:if test="${nextConference.company != null}">
                <br>
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
            </c:if>
            </p>
            <div class="js-show-popup js-guest-register-button pos-btn-submit btn-gradient btn-submit btn-bordered btn-event-registration">
                Зарегистрироваться
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

        <c:if test="${reports != null}">
            <div class="box">
                <h1 class="title">
                    Программа <c:out value="${nextConference.ordinalNumber}"/>-го IT-субботника
                </h1>

                <%@ include file="/WEB-INF/view/jsp/_reports_preview.jsp"%>

            </div>
        </c:if>

        <%@ include file="/WEB-INF/view/jsp/_index-header.jsp" %>

    </div>
</div>


<script type="text/javascript" src='<c:url value="/resources/js/init/index_reg_init.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/component_ui/popup_window_component_ui.js"/>'></script>
