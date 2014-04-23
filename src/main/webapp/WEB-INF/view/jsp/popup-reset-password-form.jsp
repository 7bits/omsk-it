<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="reset-password-form-container">
    <div class = "form-opacity"></div>
    <div class = "login-form-container">
        <div class = "new-company-title">Сбросить пароль</div>
        <div class = "popup-form-text">
            Если вы забыли свой пароль, мы отправим на ваш e-mail подтверждение смены пароля
        </div>
        <div class = "field">
            <span class = "left-label login-form-label">Email</span>
            <input class = "reset-password-email-form-input input pos-input margin-top-8" type="text" name="email" />
        </div>
        <div class = "notification-field reset-password-notification"></div>
        <div class = "reset-password-response attention"></div>
        <div class = "js-confirm-reset-password pos-btn-big pos-btn-big-confirm-form btn-gradient btn-big btn-inline">Сброс</div>
        <button class = "js-cancel-reset-password pos-btn-reset-form btn-reset">Отмена</button>
        <button class = "js-close-reset-password-button btn-close-popup pos-btn-close-popup pos-btn-reset-form "></button>
    </div>
</div>
