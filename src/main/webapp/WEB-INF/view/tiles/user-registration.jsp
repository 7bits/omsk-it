<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Регистрация на сайте
            </h1>
            <form:form class="js-apply-user-registration-form form-content" commandName="userRegistrationForm" enctype="multipart/form-data" action='registration' method="POST">
                <div class="form-info">
                    Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
                </div>

                <div class = "photo-upload-container">
                    <div class="field">
                        <span class="left-label photo-upload-label">Фотография</span>
                        <span class="js-field-info photo-upload-info">Рекомендуемый размер 200x200 px</span>
                        <span class="js-field-response js-photo-upload-response attention photo-upload-attention"></span>
                        <input class="js-photo-upload-input js-input margin-top-8" type="file" value="Загрузить" id="image" />
                    </div>

                    <div class="field">
                        <img id="image-view" class="photo" src='<c:url value="/resources/images/photos/nophoto.png" />'/>
                    </div>
                </div>

                <div class="field">
                    <span class="left-label">Имя&nbsp;<span class="attention">*</span></span>
                    <form:input class="js-first-name-input js-input small-input margin-top-8" type="text" path="firstName"/>
                    <span class="field-info">
                        <span class="js-field-info">На русском языке</span>
                        <div class="js-field-response js-first-name-response attention"><form:errors path="firstName" /></div>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">Фамилия&nbsp;<span class="attention">*</span></span>
                    <form:input class="js-second-name-input js-input small-input margin-top-8" type="text" path="secondName"/>
                    <span class="field-info">
                        <span class="js-field-info">На русском языке</span>
                        <div class="js-field-response js-second-name-response attention"> <form:errors path="secondName" /></div>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">Пароль&nbsp;<span class="attention">*</span></span>
                    <form:input class="js-password-input js-input small-input margin-top-8" type="password" path="password"/>
                    <span class="field-info">
                        <span class="js-field-info"></span>
                        <div class="js-field-response js-password-response attention"><form:errors path="password" /></div>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                    <form:input class="js-email-input js-input small-input margin-top-8" type="text" path="email"/>
                    <span class="field-info">
                        <span class="js-field-info"></span>
                        <div class="js-field-response js-email-response attention"><form:errors path="email" /></div>
                    </span>
                </div>

                <div class="field">
                    <span class="left-label">Должность&nbsp;<span class="attention">*</span></span>
                    <form:input class="js-job-position-input js-input small-input margin-top-8" type="text" path="jobPosition"/>
                    <span class="field-info">
                        <span class="js-field-info"></span>
                        <div class="js-field-response js-job-position-response attention"><form:errors path="jobPosition" /></div>
                    </span>
                </div>

                <div class="field long">
                    <span class="left-label">Место работы/учебы&nbsp;<span class="attention">*</span></span>
                    <br/>
                    <form:input class="js-company-input js-input small-input margin-top-8" path="company" type="text" id="company" autocomplete="false"/>
                    <span class="field-info">
                        <div class="new-company-add-open inline-item">Добавить</div>
                        <span class="js-field-info inline-item"></span>
                        <div class="js-field-response js-company-response attention inline-item"><form:errors path="company" /></div>
                    </span>
                </div>

                <div class="field">
                    <input class="js-apply-user-registration-form-button button-submit" type="submit" value="Отправить" />
                    <input class="js-apply-reset reset-button" type="reset" value="Отмена">
                    <div class="js-apply-response apply-response"></div>
                </div>
            </form:form>
        </div>
    </div>
</div>
