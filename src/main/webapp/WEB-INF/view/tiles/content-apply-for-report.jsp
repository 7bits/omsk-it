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
                        <input class="js-first-name-input small-input" type="text" name="firstName">
                        <span class="js-first-name-response field-info">На русском языке</span>
                    </div>

                    <div class="field">
                        <span class="left-label">Фамилия&nbsp;<span class="attention">*</span></span>
                        <input class="js-second-name-input small-input" type="text" name="secondName">
                        <span class="js-second-name-response field-info">На русском языке</span>
                    </div>

                    <div class="field">
                        <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                        <input class="js-email-input small-input" type="text" name="email">
                        <span class="js-email-response field-info">Информационное письмо придет примерно за сутки до начала мероприятия</span>
                    </div>

                    <div class="field">
                        <span class="left-label">Место работы/учебы&nbsp;<span class="attention">*</span></span>
                        <input class="js-job-input small-input" type="text" name="job">
                        <span class="js-job-response field-info"></span>
                    </div>

                    <div class="field">
                        <span class="left-label">Должность&nbsp;<span class="attention">*</span></span>
                        <input class="js-job-position-input small-input" type="text" name="jobPosition">
                        <span class="js-job-position-response field-info"></span>
                    </div>

                    <div class="field">
                        <span class="top-label">Название доклада&nbsp;<span class="attention">*</span></span>
                        <span class="js-title-response field-info">Если точного названия еще нет, то напишите предполагаемое</span>
                        <input class="js-title-input wide-input" type="text" name="title">
                    </div>

                    <div class="field">
                        <span class="top-label">Анонс доклада&nbsp;<span class="attention">*</span></span>
                        <span class="js-description-response field-info">Расскажите, пожалуйста, тремя-четырьмя предложениями, о чем будет Ваш доклад</span>
                        <textarea class="js-description-input big-input" type="text" name="description"></textarea>
                    </div>

                    <div class="field">
                        <span class="top-label">Перечислите ключевые технологии, о которых Вы будете рассказывать&nbsp;<span class="attention">*</span></span>
                        <span class="js-key-technologies-response field-info">Это очень важно. Пример: web, nosql, нагрузочное тестирование, менеджмент, стартап, mobile, ios, java, ...</span>
                        <input class="js-key-technologies-input wide-input" type="text" name="keyTechnologies">
                    </div>

                    <div class="field">
                        <span class="top-label">Рассказывали ли Вы уже этот доклад на других мероприятиях? Если да, то на каких?</span>
                        <span class="js-other-conferences-response field-info"></span>
                        <input class="js-other-conferences-input wide-input" type="text" name="otherConferences">
                    </div>

                    <div class="field">
                        <span class="top-label">Есть ли у Вас опыт выступлений на каких-либо мероприятиях? Перечислите таковые.</span>
                        <span class="js-speech-experience-response field-info">Нет ничего страшного в том, если у Вас нет опыта. В этом случае мы поможем Вам подготовить доклад.</span>
                        <textarea class="js-speech-experience-input big-input" type="text" name="speechExperience"></textarea>
                    </div>

                    <div class="field">
                        <span class="top-label">Напишите, пожалуйста, свои - как докладчика - пожелания организаторам</span>
                        <span class="js-reporter-wishes-response field-info">Постарайтесь написать все, что поможет нам организовать Ваш доклад наилучшим образом.</span>
                        <textarea class="js-reporter-wishes-input big-input" type="text" name="reporterWishes"></textarea>
                    </div>

                    <div class="field">
                        <input class="js-apply-button submit-button" type="submit" value="Отправить">
                        <input class="reset-button" type="reset" value="Отмена">
                        <div class="js-apply-response apply-response"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
