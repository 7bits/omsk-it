<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="about">
            Хотите что-нибудь рассказать на одном из Омских IT-субботников? Тогда заполните специальную форму, и мы с вами свяжемся!
        </div>

        <div class="apply-form">
            <div class="title">
                Подать заявку на выступление
            </div>

            <div class="form-content">
                <form class="js-apply-form" action='<c:url value="/apply-for-report"/>' method="POST">
                    <div class="info">
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
                        <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                        <input class="js-email-input js-input small-input" type="text" name="email">
                        <span class="field-info">
                            <span class="js-field-response js-email-response attention"></span>
                            <span class="js-field-info">Информационное письмо придет примерно за сутки до начала мероприятия</span>
                        </span>
                    </div>

                    <div class="field">
                        <span class="left-label">Место работы/учебы&nbsp;<span class="attention">*</span></span>
                        <input class="js-job-input js-input small-input" type="text" name="job">
                        <span class="field-info">
                            <span class="js-field-response js-job-response attention"></span>
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

                    <div class="field">
                        <span class="top-label">Название доклада&nbsp;<span class="attention">*</span></span>
                        <span class="field-info">
                            <span class="js-field-response js-title-response attention"></span>
                            <span class="js-field-info">Если точного названия еще нет, то напишите предполагаемое</span>
                        </span>
                        <input class="js-title-input js-input wide-input" type="text" name="title">
                    </div>

                    <div class="field">
                        <span class="top-label">Анонс доклада&nbsp;<span class="attention">*</span></span>
                        <span class="field-info">
                            <span class="js-field-response js-description-response attention"></span>
                            <span class="js-field-info">Расскажите, пожалуйста, тремя-четырьмя предложениями, о чем будет ваш доклад</span>
                        </span>
                        <textarea class="js-description-input js-input big-input" type="text" name="description"></textarea>
                    </div>

                    <div class="field">
                        <span class="top-label">Перечислите ключевые технологии, о которых вы будете рассказывать&nbsp;<span class="attention">*</span></span>
                        <span class="field-info">
                            <span class="js-field-response js-key-technologies-response attention"></span>
                            <span class="js-field-info">Это очень важно. Пример: web, nosql, нагрузочное тестирование, менеджмент, стартап, mobile, ios, java, ...</span>
                        </span>
                        <input class="js-key-technologies-input js-input wide-input" type="text" name="keyTechnologies">
                    </div>

                    <div class="field">
                        <span class="top-label">Рассказывали ли вы уже этот доклад на других мероприятиях? Если да, то на каких?</span>
                        <span class="field-info">
                            <span class="js-field-response js-other-conferences-response attention"></span>
                            <span class="js-field-info"></span>
                        </span>
                        <input class="js-other-conferences-input js-input wide-input" type="text" name="otherConferences">
                    </div>

                    <div class="field">
                        <span class="top-label">Есть ли у вас опыт выступлений на каких-либо мероприятиях? Перечислите таковые.</span>
                        <span class="field-info">
                            <span class="js-field-response js-speech-experience-response attention"></span>
                            <span class="js-field-info">Нет ничего страшного в том, если у вас нет опыта. В этом случае мы поможем вам подготовить доклад.</span>
                        </span>
                        <textarea class="js-speech-experience-input js-input big-input" type="text" name="speechExperience"></textarea>
                    </div>

                    <div class="field">
                        <span class="top-label">Напишите, пожалуйста, свои - как докладчика - пожелания организаторам</span>
                        <span class="field-info">
                            <span class="js-field-response js-reporter-wishes-response attention"></span>
                            <span class="js-field-info">Постарайтесь написать все, что поможет нам организовать ваш доклад наилучшим образом.</span>
                        </span>
                        <textarea class="js-reporter-wishes-input js-input big-input" type="text" name="reporterWishes"></textarea>
                    </div>

                    <div class="field">
                        <input class="js-apply-form-button submit-button" type="submit" value="Отправить">
                        <input class="js-apply-reset reset-button" type="reset" value="Отмена">
                        <div class="js-apply-response apply-response"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
