<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Изменение пароля
            </h1>
            <form class = "js-change-password-form box-content" method="post" action="<c:url value='/user/change-password'/>">
                <div class="field">
                    <span class="left-label">E-mail</span>
                    <input class="js-login-input js-input input pos-input" value="<c:out value = '${email}'/>" type="text" name="email" size="30" maxlength="40"/>
                </div>
                <div class="field long">
                    <span class="left-label">Старый пароль</span>
                    <br>
                    <input class="js-password-input js-input input pos-input" type="password" name="oldPassword" size="30" maxlength="32"/>
                </div>
                <div class="field long">
                    <span class="left-label">Новый пароль</span>
                    <br>
                    <input class="js-password-input js-input input pos-input" type="password" name="newPassword"  size="30" maxlength="32"/>
                </div>
                <div class = "js-change-password-response attention"></div>
                <div class="field field-last">
                    <input class="js-change-password pos-btn-submit btn-gradient btn-submit btn-bordered" type="submit" value="Изменить">
                    <div class="js-change-password-notification"></div>
                </div>
            </form>
        </div>
    </div>
</div>
