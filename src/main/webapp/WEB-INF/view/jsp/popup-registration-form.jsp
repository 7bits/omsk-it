<div class="container-form-guest">
    <div class="box container-form js-container-form-guest ">
        <div class="pos-btn-close-form btn-close-form js-form-close-button"></div>
        <h1 class="title">
            Регистрация на <c:out value="${nextConference.ordinalNumber}"/>-й IT-субботник (<c:out value="${nextConference.humanReadableDate}"/>, <c:out value="${nextConference.company.name}"/>)
        </h1>
        <form class="js-form box-content-left" action='guestUrl' method="POST">
            <div class="left-label login-form-open-label">
                Если вы зарегистрированы, то залогиньтесь.
            </div>
            <div class="btn-gradient btn-small btn-inline btn-bordered js-login-form-open">
                Логин
            </div>
            <a href='<c:url value="/social/vkAuthorization"/>' class="inline-item link-clear">
                <img class="vk-logo vk-enter" src='<c:url value="/resources/images/vk-minor-logo2.png"/>'/>
            </a>
            <div class="form-info">
                Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
            </div>
            <div class = "photo-upload-container">
                <div class="field">
                    <span class="left-label photo-upload-label">Фотография</span>
                    <span class="photo-upload-info photo-upload-text">Рекомендуемый размер 200x200 px</span>
                    <span class="js-field-response js-photo-upload-response attention photo-upload-text"></span>
                    <input class="js-photo-upload-input js-input image" type="file" value="Загрузить" />
                </div>

                <div class="field">
                    <img class="photo image-view" src='<c:url value="/resources/images/photos/nophoto.png" />'/>
                </div>
            </div>

            <div class="field">
                <span class="left-label">Имя&nbsp;<span class="attention">*</span></span>
                <input class="js-firstName-input js-input input pos-input" type="text" name="firstName">
                        <span class="field-info">
                            <span class="js-field-info">На русском языке</span>
                        </span>
                <div class="js-field-response js-firstName-response attention attention-info"></div>
            </div>

            <div class="field">
                <span class="left-label">Фамилия&nbsp;<span class="attention">*</span></span>
                <input class="js-secondName-input js-input input pos-input" type="text" name="secondName">
                        <span class="field-info">
                            <span class="js-field-info">На русском языке</span>
                        </span>
                <div class="js-field-response js-secondName-response attention attention-info"></div>
            </div>

            <div class="field">
                <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                <input class="js-email-input js-input input pos-input" type="text" name="email">
                        <span class="field-info">
                        </span>
                <div class="js-field-response js-email-response attention attention-info"></div>
            </div>

            <div class="field">
                <span class="left-label">Пароль&nbsp;<span class="attention">*</span></span>
                <input class="js-password-input js-input input pos-input" type="password" name="password">
                        <span class="field-info">
                        </span>
                <div class="js-field-response js-password-response attention attention-info"></div>
            </div>

            <div class="field">
                <span class="left-label">Должность&nbsp;<span class="attention">*</span></span>
                <input class="js-jobPosition-input js-input input pos-input" type="text" name="jobPosition">
                        <span class="field-info">
                            <span class="js-field-info"></span>
                        </span>
                <div class="js-field-response js-jobPosition-response attention attention-info"></div>
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


            <div class="field field-last center-div">
                <input class="js-form-button pos-btn-submit btn-gradient btn-submit btn-bordered btn-popup-event-registration" type="submit" value="Зарегистрироваться">
                <div class="js-form-response"></div>
            </div>
        </form>
    </div>
</div>
