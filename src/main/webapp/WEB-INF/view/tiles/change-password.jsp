<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Изменение пароля
            </h1>

            <form class="js-form js-show-message box-content-left" method="post" action="<c:url value='/user/change-password'/>">
                <div class="form-info">
                    Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
                </div>

                <div class="js-field-error js-message-error attention"></div>

                <div class="field">
                    <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                    <input class="input pos-input" value="<c:out value = '${email}'/>" type="text" name="email"
                           size="30" maxlength="40"/>
                    <span class="js-field-error js-email-error attention-info attention"></span>
                </div>

                <div class="field long">
                    <span class="top-label left-label">Старый пароль&nbsp;<span class="attention">*</span></span>
                    <br>
                    <input class="input pos-input" type="password" name="oldPassword" size="30" maxlength="32"/>
                    <span class="js-field-error js-oldPassword-error attention-info attention"></span>
                </div>

                <div class="field long">
                    <span class="top-label left-label">Новый пароль&nbsp;<span class="attention">*</span></span>
                    <br>
                    <input class="input pos-input" type="password" name="newPassword" size="30" maxlength="32"/>
                    <span class="js-field-error js-newPassword-error attention-info attention"></span>
                </div>

                <div class="field field-last">
                    <input class="pos-btn-submit btn-gradient btn-submit btn-bordered" type="submit" value="Изменить">
                </div>
            </form>
        </div>
    </div>
</div>
