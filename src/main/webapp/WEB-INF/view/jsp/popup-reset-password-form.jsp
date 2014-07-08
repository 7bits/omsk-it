<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="js-popup-window popup-container" data-button-selector=".js-open-reset-password">
    <div class = "form-opacity"></div>
    <form class = "js-form js-show-message popup-form-container" action="<c:url value="/user/reset-password" />">
        <div class = "title popup-title">Сбросить пароль</div>
        <div class = "box-content">
            <div class = "popup-form-text">
                Если вы забыли свой пароль, мы отправим на ваш e-mail подтверждение смены пароля
            </div>
            <div class = "js-field-error js-base-error attention"></div>
            <div class = "field">
                <span class = "left-label login-form-label">Email</span>
                <input class = "input pos-input" type="text" name="email" />
                <div class="js-field-error js-email-error attention"></div>
            </div>
            <div class = "popup-btn-container" >
                <input class = "btn-gradient btn-big btn-inline" type="submit" value="Сброс"/>
                <input class = "js-close-popup btn-reset" type="reset" value="Отмена"/>
            </div>
        </div>
    </form>
</div>
