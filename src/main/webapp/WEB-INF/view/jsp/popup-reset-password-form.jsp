<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="reset-password-form-container popup-container">
    <div class = "form-opacity"></div>
    <div class = "popup-form-container">
        <div class = "title popup-title">Сбросить пароль</div>
        <div class = "box-content">
            <div class = "popup-form-text">
                Если вы забыли свой пароль, мы отправим на ваш e-mail подтверждение смены пароля
            </div>
            <div class = "field">
                <span class = "left-label login-form-label">Email</span>
                <input class = "reset-password-email-form-input input pos-input  " type="text" name="email" />
            </div>
            <div class = "reset-password-label"></div>
            <div class = "reset-password-response attention attention-reset-password"></div>
            <div class = "popup-btn-container" >
                <div class = "js-confirm-reset-password btn-gradient btn-big btn-inline">Сброс</div>
                <button class = "js-cancel-reset-password btn-reset">Отмена</button>
            </div>
        </div>
        <button class = "js-close-reset-password-button btn-close-popup pos-btn-close-popup"></button>
    </div>
</div>
