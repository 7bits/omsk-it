<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="popup-container login-container">
    <div class="form-opacity"></div>
    <div class="popup-form-container">
        <div class="title popup-title"> Вход на сайт</div>
        <div class="box-content">
            <div class="field">
                <span class="left-label login-form-label">Email</span>
                <input class="login-form-input input pos-input margin-top-8" type="text" name="login" />
            </div>

            <div class="field">
                <span class="left-label login-form-label">Пароль</span>
                <input class="login-form-input input pos-input margin-top-8" type="password" name="password" />
            </div>
            <div class="js-field-response login-message-error attention"></div>
            <div class="js-forgot-password link-blue forgot-password">Забыли пароль?</div>
            <div class="js-confirm-login pos-btn-big pos-btn-big-confirm-form btn-gradient btn-big btn-inline">Войти</div>
            <button class="cancel-login btn-reset">Отмена</button>
        </div>
        <button class="btn-close-popup pos-btn-close-popup js-close-login-button"></button>
    </div>
</div>
