<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Регистрация на сайте
            </h1>
            <form class="js-form box-content" action='userSocialRegistrationUrl' method="POST">
                <div class="form-info">
                    Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
                </div>

                <div class = "photo-upload-container">
                    <div class="field">
                        <span class="left-label photo-upload-label">Фотография</span>
                        <span class="js-field-info photo-upload-info photo-upload-text">Рекомендуемый размер 200x200 px</span>
                        <span class="js-field-response js-photo-upload-response attention photo-upload-text"></span>
                        <input class="js-photo-upload-input js-input image" type="file" value="Загрузить" />
                    </div>

                    <div class="field">
                        <img class="photo image-view" src='/resources/temporary/photos/<c:out value="${userVkontaktePhotoName}"/>'/>
                    </div>
                </div>

                <div class="field">
                    <span class="left-label">Имя&nbsp;<span class="attention">*</span></span>
                    <input class="js-firstName-input js-input input pos-input  " type="text" name="firstName" value='<c:out value="${userVkontakteFirstName}"/>'/>
                    <span class="field-info">
                        <span class="js-field-info">На русском языке</span>
                    </span>
                    <div class="js-field-response js-firstName-response attention-info attention"></div>
                </div>

                <div class="field">
                    <span class="left-label">Фамилия&nbsp;<span class="attention">*</span></span>
                    <input class="js-secondName-input js-input input pos-input  " type="text" name="secondName" value='<c:out value="${userVkontakteSecondName}"/>'/>
                    <span class="field-info">
                        <span class="js-field-info">На русском языке</span>
                    </span>
                    <div class="js-field-response js-secondName-response attention-info attention"></div>
                </div>

                <div class="field">
                    <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                    <input class="js-email-input js-input input pos-input  " type="text" name="email"/>
                    <span class="field-info">
                        <span class="js-field-info"></span>
                    </span>
                    <div class="js-field-response js-email-response attention-info attention"></div>
                </div>

                <div class="field">
                    <span class="left-label">Должность&nbsp;<span class="attention">*</span></span>
                    <input class="js-jobPosition-input js-input input pos-input  " type="text" name="jobPosition"/>
                    <span class="field-info">
                        <span class="js-field-info"></span>
                    </span>
                    <div class="js-field-response js-jobPosition-response attention-info attention"></div>
                </div>

                <div class="field long">
                    <span class="top-label left-label">Место работы/учебы&nbsp;<span class="attention">*</span></span>
                    <br/>
                    <input class="js-company-input js-input input pos-input" type="text" id="company" autocomplete="false" name="company"/>
                    <div class="js-new-company-form-open btn-gradient btn-add-company inline-item">Добавить</div>
                    <span class="field-info">                        
                        <span class="js-field-info inline-item"></span>
                    </span>
                    <div class="js-field-response js-company-response attention-info attention inline-item attention-company"></div>
                </div>

                <div class="field field-last">
                    <input class="js-form-button pos-btn-submit btn-gradient btn-submit btn-bordered" type="submit" value="Отправить" />
                    <input class="js-apply-reset btn-reset" type="reset" value="Отмена">
                    <div class="js-form-response apply-response"></div>
                </div>
            </form>
        </div>
    </div>
</div>
