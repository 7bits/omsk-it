<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Вход на сайт
            </h1>
            <form class = "js-form js-form-redirect box-content-left login-container" method="post" action="<c:url value="/user/login"/>">
                <div class="js-field-error js-base-error login-message-error attention">
                    <c:if test="${error == 'true'}">
                        Неверный email или пароль.<br />
                    </c:if>
                </div>
                <div class="field">
                    <span class="left-label">E-mail</span>
                    <input class="input pos-input" type="text" name="login" size="30" maxlength="40"/>
                    <span class="field-info">
                        <span class="js-field-error js-login-error attention"></span>
                    </span>
                </div>
                <div class="field">
                    <span class="left-label">Пароль</span>
                    <input class="input pos-input" type="password" name="password" size="30" maxlength="32"/>
                    <span class="field-info">
                        <span class="js-field-error js-password-error attention"></span>
                    </span>

                    <div class="forgot-pass-container">
                        <div class="link-blue forgot-password">Забыли пароль?</div>
                    </div>
                </div>

                <div class="field field-last">
                    <input class="pos-btn-submit btn-gradient btn-submit btn-bordered" type="submit" value="Войти">
                    <input class="btn-reset" type="reset" value="Отмена">
                </div>
            </form>
        </div>
    </div>
</div>
