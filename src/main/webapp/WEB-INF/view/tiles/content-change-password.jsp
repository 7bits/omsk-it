<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Изменение пароля
            </h1>
            <form class = "change-password-form" method="post" action="<c:url value='/user/change-password'/>">
                <div class="field">
                    <span class="left-label">E-mail</span>
                    <input class="js-login-input js-input small-input" type="text" name="j_username" id="j_username" size="30" maxlength="40"/>
                    <span class="field-info">
                        <span class="js-field-response js-email-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">Старый пароль</span>
                    <input class="js-password-input js-input small-input" type="password" name="oldPassword" size="30" maxlength="32"/>
                    <span class="field-info">
                        <span class="js-field-response js-old-password-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">Новый пароль</span>
                    <input class="js-password-input js-input small-input" type="password" name="newPassword"  size="30" maxlength="32"/>
                    <span class="field-info">
                        <span class="js-field-response js-new-password-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                </div>

                <div class="field">
                    <input class="button-submit" type="submit" value="Изменить">
                    <div class="js-apply-response apply-response"></div>
                </div>
            </form>
        </div>
    </div>
</div>