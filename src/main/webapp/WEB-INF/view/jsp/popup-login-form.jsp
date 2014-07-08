<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="js-popup-window js-form-reload-page popup-container login-container" data-button-selector=".js-open-login-form">
    <div class="form-opacity"></div>
    <form class="js-form popup-form-container" method="POST" action='<c:url value="/user/login"/>'>
        <div class="title popup-title"> Вход на сайт</div>
        <div class="box-content-left">
            <div class="js-field-error js-base-error error-message attention"></div>

            <div class="field">
                <div class="js-field-error js-login-error attention"></div>
                <label>
                    <span class="left-label login-form-label">Email</span>
                    <input class="input pos-input  " type="text" name="login"/>
                </label>
            </div>

            <div class="field">
                <div class="js-field-error js-password-error attention"></div>
                <span class="left-label login-form-label">Пароль</span>
                <input class="input pos-input  " type="password" name="password"/>
            </div>

            <div class="js-open-reset-password link-blue forgot-password">Забыли пароль?</div>
            <input class="pos-btn-big pos-btn-big-confirm-form btn-gradient btn-big btn-inline" type="submit" value="Войти"/>
            <input class="btn-reset" type="reset" value="Отмена"/>
        </div>
        <div class="js-close-popup btn-close-popup pos-btn-close-popup"></div>
    </form>
</div>
