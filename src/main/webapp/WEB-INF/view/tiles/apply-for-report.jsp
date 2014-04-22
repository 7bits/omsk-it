<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="content">
    <div class="page">
        <div class="text-content-up">
            Хотите что-нибудь рассказать на одном из Омских IT-субботников? Тогда заполните специальную форму, и мы с вами свяжемся!
        </div>

        <div class="box">
            <h1 class="title">
                Подать заявку на выступление
            </h1>
            <form class="js-apply-form form-content" action='<c:url value="/apply-for-report"/>' method="POST">
                <sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR">
                    <div class="login-form-open">
                        Если вы зарегистрированы, то залогиньтесь.
                    </div>
                    <div class="btn-gradient btn-small btn-bordered btn-inline js-login-form-open">
                        Логин
                    </div>
                    <a href='<c:url value="/social/vkAuthorization"/>' class="inline-item">
                        <img class="vk-enter" src='<c:url value="/resources/images/vk-minor-logo2.png"/>'/>
                    </a>
                </sec:authorize>
                <div class="form-info">
                    Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
                </div>
                <sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR">
                    <div class = "photo-upload-container">
                        <div class="field">
                            <span class="left-label photo-upload-label">Фотография</span>
                            <span class="photo-upload-info">Рекомендуемый размер 200x200 px</span>
                            <span class="js-field-response js-photo-upload-response attention photo-upload-attention"></span>
                            <input class="js-photo-upload-input js-input margin-top-8 image" type="file" value="Загрузить" />
                        </div>

                        <div class="field">
                            <img class="photo image-view" src='<c:url value="/resources/images/photos/nophoto.png" />'/>
                        </div>
                    </div>
                    <div class="field">
                        <span class="left-label">Имя&nbsp;<span class="attention">*</span></span>
                        <input class="js-first-name-input js-input small-input" type="text" name="firstName">
                        <span class="field-info">
                            <span class="js-field-info">На русском языке</span>
                        </span>
                        <div class="js-field-response js-first-name-response attention attention-info"></div>
                    </div>
                    <div class="field">
                        <span class="left-label">Фамилия&nbsp;<span class="attention">*</span></span>
                        <input class="js-second-name-input js-input small-input" type="text" name="secondName">
                        <span class="field-info">
                            <span class="js-field-info">На русском языке</span>
                        </span>
                        <div class="js-field-response js-second-name-response attention attention-info"></div>
                    </div>
                    <div class="field">
                        <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                        <input class="js-email-input js-input small-input" type="text" name="email">
                        <span class="field-info">
                        </span>
                        <div class="js-field-response js-email-response attention attention-info"></div>
                    </div>
                    <div class="field">
                        <span class="left-label">Пароль&nbsp;<span class="attention">*</span></span>
                            <input class="js-password-input js-input small-input" type="password" name="password">
                        <span class="field-info">
                        </span>
                        <div class="js-field-response js-password-response attention attention-info"></div>
                    </div>
                    <div class="field">
                        <span class="left-label">Должность&nbsp;<span class="attention">*</span></span>
                        <input class="js-job-position-input js-input small-input" type="text" name="jobPosition">
                        <span class="field-info">
                            <span class="js-field-info"></span>
                        </span>
                        <div class="js-field-response js-job-position-response attention attention-info"></div>
                    </div>
                    <div class="field long">
                        <span class="left-label">Место работы/учебы&nbsp;<span class="attention">*</span></span>
                        <br/>
                        <input class="js-company-input js-input small-input margin-top-8" type="text" id="company" autocomplete="false" name="company"/>
                        <span class="field-info">
                            <div class="js-new-company-form-open pos-btn-add-company btn-gradient btn-add-company inline-item">Добавить</div>
                            <span class="js-field-info inline-item"></span>
                        </span>
                        <div class="js-field-response js-company-response attention-info attention inline-item attention-company"></div>
                    </div>
                </sec:authorize>
                <div class="field">
                    <span class="left-label top-label">Название доклада&nbsp;<span class="attention">*</span></span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Если точного названия еще нет, то напишите предполагаемое</span>
                    </span>
                    <input class="js-title-input js-input small-input wide-input" type="text" name="title">
                    <div class="js-field-response js-title-response attention attention-info attention-long"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Анонс доклада&nbsp;<span class="attention">*</span></span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Расскажите, пожалуйста, тремя-четырьмя предложениями, о чем будет ваш доклад</span>
                    </span>
                    <textarea class="js-description-input js-input small-input wide-input big-input" type="text" name="description"></textarea>
                    <div class="js-field-response js-description-response attention attention-info attention-long"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Перечислите ключевые технологии, о которых вы будете рассказывать&nbsp;<span class="attention">*</span></span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Это очень важно. Пример: web, nosql, нагрузочное тестирование, менеджмент, стартап, mobile, ios, java, ...</span>
                    </span>
                    <input class="js-key-technologies-input js-input small-input wide-input" type="text" name="keyTechnologies">
                    <div class="js-field-response js-key-technologies-response attention attention-info attention-long"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Рассказывали ли вы уже этот доклад на других мероприятиях? Если да, то на каких?</span>
                    <span class="field-info long-info">
                        <span class="js-field-info"></span>
                    </span>
                    <input class="js-other-conferences-input js-input small-input wide-input" type="text" name="otherConferences">
                    <div class="js-field-response js-other-conferences-response attention attention-info"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Есть ли у вас опыт выступлений на каких-либо мероприятиях? Перечислите таковые.</span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Нет ничего страшного в том, если у вас нет опыта. В этом случае мы поможем вам подготовить доклад.</span>
                    </span>
                    <textarea class="js-speech-experience-input js-input small-input wide-input big-input" type="text" name="speechExperience"></textarea>
                    <div class="js-field-response js-speech-experience-response attention attention-info"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Напишите, пожалуйста, свои - как докладчика - пожелания организаторам</span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Постарайтесь написать все, что поможет нам организовать ваш доклад наилучшим образом.</span>
                    </span>
                    <textarea class="js-reporter-wishes-input js-input small-input wide-input big-input" type="text" name="reporterWishes"></textarea>
                    <div class="js-field-response js-reporter-wishes-response attention attention-info"></div>
                </div>
                <div class="field">
                    <input class="js-apply-form-button pos-btn-submit btn-gradient btn-submit btn-bordered" type="submit" value="Отправить">
                    <input class="js-apply-reset btn-reset" type="reset" value="Отмена">
                    <div class="js-apply-response apply-response"></div>
                </div>
            </form>
        </div>
    </div>
</div>
