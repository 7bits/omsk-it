<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Регистрация на сайте
            </h1>
            <form class="js-apply-user-registration-form form-content" action='<c:url value="/registration"/>' method="POST">
                <div class="form-info">
                    Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
                </div>

                <div class="field">
                    <span class="left-label">Имя&nbsp;<span class="attention">*</span></span>
                    <input class="js-first-name-input js-input small-input" type="text" name="firstName">
                    <span class="field-info">
                        <span class="js-field-response js-first-name-response attention"></span>
                        <span class="js-field-info">На русском языке</span>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">Фамилия&nbsp;<span class="attention">*</span></span>
                    <input class="js-second-name-input js-input small-input" type="text" name="secondName">
                    <span class="field-info">
                        <span class="js-field-response js-second-name-response attention"></span>
                        <span class="js-field-info">На русском языке</span>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">Пароль&nbsp;<span class="attention">*</span></span>
                    <input class="js-password-input js-input small-input" type="password" name="password">
                    <span class="field-info">
                        <span class="js-field-response js-password-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                    <input class="js-email-input js-input small-input" type="text" name="email">
                    <span class="field-info">
                        <span class="js-field-response js-email-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                </div>

                <!--div class="field long">
                    <span class="left-label">Место работы/учебы&nbsp;<span class="attention">*</span></span>
                    <br>
                    <input class="js-job-input js-input small-input" type="text" name="job">
                    <span class="field-info">
                        <span class="js-field-response js-job-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                </div-->

                <div class="field">
                    <span class="left-label">Должность&nbsp;<span class="attention">*</span></span>
                    <input class="js-job-position-input js-input small-input" type="text" name="jobPosition">
                    <span class="field-info">
                        <span class="js-field-response js-job-position-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
                </div>

                <div class="field">
                    <input class="js-apply-user-registration-form-button button-submit" type="submit" value="Отправить">
                    <input class="js-apply-reset reset-button" type="reset" value="Отмена">
                    <div class="js-apply-response apply-response"></div>
                </div>
            </form>
        </div>
    </div>
</div>
