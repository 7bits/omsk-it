<div class="container-form-guest">
    <div class="box container-form js-container-form-guest ">
        <div class="form-close-button js-form-close-button"></div>
        <h1 class="title">
            Регистрация на <c:out value="${conference.ordinalNumber}"/>-й IT-субботник (<c:out value="${conference.humanReadableDate}"/>, <c:out value="${conference.company.name}"/>)
        </h1>
        <form class="js-guest-form form-content" action='<c:url value="/reg"/>' method="POST">
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
            <div class="field long">
                <span class="left-label">
                    Место работы/учебы<span class="attention">*</span>
                </span>
                <br>
                <input type="text" name="job" class="js-job-input js-input small-input">
                <span class="field-info">
                    <span class="js-field-response js-job-response attention"></span>
                </span>
            </div>
            <div class="field">
                <span class="top-label left-label label-field-jobPosition">
                    Ваша роль в компании/команде<span class="attention">*</span>
                </span>
                <br>
                <input type="radio" name="jobPosition" value="Руководитель компании">Руководитель компании<br>
                <input type="radio" name="jobPosition" value="Менеджер проекта">Менеджер проекта<br>
                <input type="radio" name="jobPosition" value="Тимлид команды">Тимлид команды<br>
                <input type="radio" name="jobPosition" value="Разработчик">Разработчик<br>
                <input type="radio" name="jobPosition" value="Дизайнер">Дизайнер<br>
                <input type="radio" name="jobPosition" value="Тестировщик">Тестировщик<br>
                <input type="radio" name="jobPosition" value="Аналитик">Аналитик<br>
                <input type="radio" name="jobPosition" value="Системный администритор">Системный администритор<br>
                <input type="radio" name="jobPosition" value="other">Другое:
                <input type="text" name="jobPositionOther" class="js-job-position-other-input js-input small-input small-input-other">
                <span class="field-info">
                    <span class="js-field-response js-jobPosition-response attention"></span>
                </span>
            </div>
            <div class="field center-div">
                <input class="js-guest-form-button button-submit" type="submit" value="Зарегистрироваться">
                <div class="js-guest-response"></div>
            </div>
        </form>
    </div>
</div>