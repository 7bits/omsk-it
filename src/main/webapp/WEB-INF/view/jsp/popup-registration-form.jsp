<div class="js-popup-window guest-form-div" data-button-selector=".js-show-popup">
    <div class="container-form-guest">
        <div class="box container-form">
            <div class="js-close-popup btn-close-popup pos-btn-close-popup"></div>
            <h1 class="title">
                Регистрация на <c:out value="${nextConference.ordinalNumber}"/>-й IT-субботник (<c:out value="${nextConference.humanReadableDate}"/>, <c:out value="${nextConference.company.name}"/>)
            </h1>

            <div class="box-content-left">
                <div class="left-label login-form-open-label">
                    Если вы зарегистрированы, то залогиньтесь.
                </div>
                <div class="js-open-login-form btn-gradient btn-small btn-inline btn-bordered">
                    Логин
                </div>
                <a href='<c:url value="/social/vkAuthorization"/>' class="inline-item link-clear">
                    <img class="vk-logo vk-enter" src='<c:url value="/resources/images/vk-minor-logo2.png"/>'/>
                </a>
            </div>
            
            <%@ include file="/WEB-INF/view/jsp/_registartion_form.jsp" %>

        </div>
    </div>
</div>
