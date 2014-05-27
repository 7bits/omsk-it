<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="js-login-container popup-container login-container">
    <div class="form-opacity"></div>
    <div class="popup-form-container">
        <div class="title popup-title"> Вход на сайт</div>
        <div class="box-content">
            <div class="field">
                <span class="left-label login-form-label">Email</span>
                <input class="js-login-form-input input pos-input  " type="text" name="login" />
            </div>

            <div class="field">
                <span class="left-label login-form-label">Пароль</span>
                <input class="js-login-form-input input pos-input  " type="password" name="password" />
                <div class="js-login-message-error js-field-response login-message-error attention"></div>
            </div>            
            <div class="js-forgot-password link-blue forgot-password">Забыли пароль?</div>
            <div class="js-confirm-login pos-btn-big pos-btn-big-confirm-form btn-gradient btn-big btn-inline">Войти</div>
            <button class="js-cancel-login btn-reset">Отмена</button>
        </div>
        <button class="btn-close-popup pos-btn-close-popup js-close-login-button"></button>
    </div>
</div>
