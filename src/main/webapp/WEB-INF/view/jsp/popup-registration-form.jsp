<div class="js-popup-window js-guest-form-div guest-form-div" data-button-selector=".js-show-popup">
    <div class="container-form-guest">
        <div class="box container-form js-container-form-guest ">
            <button class="js-close-popup btn-close-popup pos-btn-close-popup js-form-close-button"></button>
            <h1 class="title">
                Регистрация на <c:out value="${nextConference.ordinalNumber}"/>-й IT-субботник (<c:out value="${nextConference.humanReadableDate}"/>, <c:out value="${nextConference.company.name}"/>)
            </h1>

            <div class="box-content-left">
                <div class="left-label login-form-open-label">
                    Если вы зарегистрированы, то залогиньтесь.
                </div>
                <div class="btn-gradient btn-small btn-inline btn-bordered js-login-form-open">
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
