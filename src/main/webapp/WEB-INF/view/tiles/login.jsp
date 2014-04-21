<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Вход на сайт
            </h1>
            <form class = "login-main-form" method="post" action="<c:url value='/j_spring_security_check'/>">
                <div class="field">
                    <span class="left-label">E-mail</span>
                    <input class="js-login-input js-input small-input" type="text" name="j_username" id="j_username" size="30" maxlength="40"/>
                    <span class="field-info">
                        <span class="js-field-response js-email-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                </div>
                <div class="field">
                    <span class="left-label">Пароль</span>
                    <input class="js-password-input js-input small-input" type="password" name="j_password" id="j_password" size="30" maxlength="32"/>
                    <span class="field-info">
                        <span class="js-field-response js-password-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                    <div class="forgot-password">Забыли пароль?</div>
                </div>
                <p>
                    <c:if test="${error == 'true'}">
                        <div class="attention login-error">
                            Неверный email или пароль.<br />
                        </div>
                    </c:if>
                </p>
                <div class="field">
                    <input class="button-submit" type="submit" value="Войти">
                    <div class="js-apply-response apply-response"></div>
                </div>
            </form>
        </div>
    </div>
</div>
