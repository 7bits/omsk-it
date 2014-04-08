<div class="container-form-guest">
    <div class="box container-form js-container-form-guest ">
        <div class="form-close-button js-form-close-button"></div>
        <h1 class="title">
            Регистрация на <c:out value="${conference.ordinalNumber}"/>-й IT-субботник (<c:out value="${conference.humanReadableDate}"/>, <c:out value="${conference.company.name}"/>)
        </h1>
        <form class="js-guest-form form-content" action='<c:url value="/register"/>' method="POST">
            <div class="login-form-open">
                Если вы зарегистрированы, то залогиньтесь.
            </div>
            <div class="login-form-open-button login-page-open">
                Логин
            </div>
            <a href='<c:url value="/social/vkAuthorization"/>' class="inline-item">
                <img class="vk-enter" src='<c:url value="/resources/images/vk-minor-logo2.png"/>'/>
            </a>
            <div class="form-info">
                Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
            </div>
            <div class="field">
                <span class="left-label">
                    Имя<span class="attention">*</span>
                </span>
                <input type="text" name="firstName" class="js-first-name-input js-input small-input">
                <span class="field-info">
                    <span class="js-field-info">На русском языке</span>
                    <span class="js-field-response js-firstName-response attention"></span>
                </span>
            </div>
            <div class="field">
                <span class="left-label">
                    Фамилия<span class="attention">*</span>
                </span>
                <input type="text" name="secondName" class="js-second-name-input js-input small-input">
                <span class="field-info">
                    <span class="js-field-info">На русском языке</span>
                    <span class="js-field-response js-secondName-response attention"></span>
                </span>
            </div>
            <div class="field">
                <span class="left-label">
                    E-mail<span class="attention">*</span>
                </span>
                <input type="text" name="email" class="js-email-input js-input small-input">
                <span class="field-info">
                    <span class="js-field-info">Информационное письмо придет примерно за сутки до начала мероприятия</span>
                    <span class="js-field-response js-email-response attention"></span>
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
                <span class="left-label">Должность&nbsp;<span class="attention">*</span></span>
                <input class="js-job-position-input js-input small-input" type="text" name="jobPosition">
                    <span class="field-info">
                        <span class="js-field-response js-job-position-response attention"></span>
                        <span class="js-field-info"></span>
                    </span>
            </div>

            <div class="field long">
                <span class="left-label">Место работы/учебы&nbsp;<span class="attention">*</span></span>
                <br>
                <input class="js-company-input js-input small-input margin-top-8" type="text" id="company" name="company" autocomplete="false"/>
                    <span class="field-info">
                        <div class="new-company-add-open inline-item"></div>
                        <span class="js-field-info inline-item"></span>
                        <div class="js-field-response js-company-response attention inline-item"></div>
                    </span>
                <div class="new-company-add-container close">
                    <div class="new-company-add-input-container">
                        <input class="new-company-input" name="name" id="company-name" placeholder="Название"/>
                        <input class="new-company-input" name="site" placeholder="Сайт"/>
                    </div>
                    <div class="new-company-add-confirm">Добавить</div>
                    <div class="js-field-response js-new-company-response attention"></div>
                </div>
            </div>

            <div class="field">
                <span class="left-label">Фотография</span>
                <input class="js-photo-upload-input js-input small-input margin-top-8" type="file" value="Загрузить" id="image" />
                    <span class="field-info">
                        <span class="js-field-info"></span>
                        <span class="js-field-response js-photo-upload-response attention"></span>
                    </span>
            </div>

            <div class="field">
                <img id="image-view" class="photo" src=''/>
            </div>

            <div class="field center-div">
                <input class="js-guest-form-button button-submit" type="submit" value="Зарегистрироваться">
                <div class="js-guest-response"></div>
            </div>
        </form>
    </div>
</div>