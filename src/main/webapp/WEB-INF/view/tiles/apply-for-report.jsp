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
            <form class="js-form js-show-message box-content-left" action='<c:url value="/apply-for-report"/>' method="POST">
                <sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR">
                    <div class="left-label login-form-open-label">
                        Если вы зарегистрированы, то залогиньтесь.
                    </div>
                    <div class="btn-gradient btn-small btn-bordered btn-inline js-open-login-form">
                        Логин
                    </div>
                    <a href='<c:url value="/social/vkAuthorization"/>' class="inline-item link-clear">
                        <img class="vk-logo vk-enter" src='<c:url value="/resources/images/vk-minor-logo2.png"/>'/>
                    </a>
                </sec:authorize>
                <div class="form-info">
                    Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
                </div>
                <sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR">
                    <div class = "js-upload-image-container photo-upload-container">
                        <div class="field">
                            <img class="js-img-preview photo image-view" src='<c:url value="/resources/images/photos/nophoto.png" />'/>
                            <span class="left-label photo-upload-label">Фотография</span>
                            <span class="photo-upload-info photo-upload-text">Рекомендуемый размер 200x200 px</span>
                            <span class="js-field-error js-message-error attention photo-upload-text"></span>
                            <input class="js-upload-image" type="file" accept="image/*" value="Загрузить" data-source-url="<c:url value="/user/upload/photo" />"/>
                        </div>
                    </div>

                    <div class="field">
                        <span class="left-label">Имя&nbsp;<span class="attention">*</span></span>
                        <input class="input pos-input" type="text" name="firstName"/>
                    <span class="field-info">
                        <span class="">На русском языке</span>
                    </span>
                        <div class="js-field-error js-firstName-error attention-info attention"></div>
                    </div>

                    <div class="field">
                        <span class="left-label">Фамилия&nbsp;<span class="attention">*</span></span>
                        <input class="input pos-input" type="text" name="secondName"/>
                    <span class="field-info">
                        <span class="">На русском языке</span>
                    </span>
                        <div class="js-field-error js-secondName-error attention-info attention"></div>
                    </div>

                    <div class="field">
                        <span class="left-label">Пароль&nbsp;<span class="attention">*</span></span>
                        <input class="input pos-input" type="password" name="password"/>
                    <span class="field-info">
                        <span class=""></span>
                    </span>
                        <div class="js-field-error js-password-error attention-info attention"></div>
                    </div>

                    <div class="field">
                        <span class="left-label">E-mail&nbsp;<span class="attention">*</span></span>
                        <input class="input pos-input" type="text" name="email"/>
                    <span class="field-info">
                        <span class=""></span>
                    </span>
                        <div class="js-field-error js-email-error attention-info attention"></div>
                    </div>

                    <div class="field">
                        <span class="left-label">Должность&nbsp;<span class="attention">*</span></span>
                        <input class="input pos-input" type="text" name="jobPosition"/>
                    <span class="field-info">
                        <span class=""></span>
                    </span>
                        <div class="js-field-error js-jobPosition-error attention-info attention"></div>
                    </div>

                    <div class="field long">
                        <span class="top-label left-label">Место работы/учебы&nbsp;<span class="attention">*</span></span>
                        <br/>
                        <input class="js-autocomplete-filed input pos-input" type="text" id="company" autocomplete="false" name="company" data-source-url="<c:url value="/company/getCompanies"/>"/>
                        <div class="js-new-company-form-open btn-gradient btn-add-company inline-item">Добавить</div>
                        <span class="field-info">
                            <span class=" inline-item"></span>
                        </span>
                        <div class="js-field-error js-company-error attention-info attention inline-item attention-company"></div>
                    </div>

                </sec:authorize>
                <div class="field">
                    <span class="left-label top-label">Название доклада&nbsp;<span class="attention">*</span></span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Если точного названия еще нет, то напишите предполагаемое</span>
                    </span>
                    <input class="js-title-input js-input input pos-input input-wide pos-input" type="text" name="title">
                    <div class="js-field-error js-title-error attention attention-info attention-long"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Анонс доклада&nbsp;<span class="attention">*</span></span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Расскажите, пожалуйста, тремя-четырьмя предложениями, о чем будет ваш доклад</span>
                    </span>
                    <textarea class="js-description-input js-input input pos-input input-wide pos-input input-big pos-input" type="text" name="description"></textarea>
                    <div class="js-field-error js-description-error attention attention-info attention-long"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Перечислите ключевые технологии, о которых вы будете рассказывать&nbsp;<span class="attention">*</span></span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Это очень важно. Пример: web, nosql, нагрузочное тестирование, менеджмент, стартап, mobile, ios, java, ...</span>
                    </span>
                    <input class="js-keyTechnologies-input js-input input pos-input input-wide pos-input" type="text" name="keyTechnologies">
                    <div class="js-field-error js-keyTechnologies-error attention attention-info attention-long"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Рассказывали ли вы уже этот доклад на других мероприятиях? Если да, то на каких?</span>
                    <span class="field-info long-info">
                        <span class="js-field-info"></span>
                    </span>
                    <input class="js-otherConferences-input js-input input pos-input input-wide pos-input" type="text" name="otherConferences">
                    <div class="js-field-error js-otherConferences-error attention attention-info"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Есть ли у вас опыт выступлений на каких-либо мероприятиях? Перечислите таковые.</span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Нет ничего страшного в том, если у вас нет опыта. В этом случае мы поможем вам подготовить доклад.</span>
                    </span>
                    <textarea class="js-speechExperience-input js-input input pos-input input-wide pos-input input-big pos-input" type="text" name="speechExperience"></textarea>
                    <div class="js-field-error js-speechExperience-error attention attention-info"></div>
                </div>
                <div class="field">
                    <span class="left-label top-label">Напишите, пожалуйста, свои - как докладчика - пожелания организаторам</span>
                    <span class="field-info long-info">
                        <span class="js-field-info">Постарайтесь написать все, что поможет нам организовать ваш доклад наилучшим образом.</span>
                    </span>
                    <textarea class="js-reporterWishes-input js-input input pos-input input-wide pos-input input-big pos-input" type="text" name="reporterWishes"></textarea>
                    <div class="js-field-error js-reporterWishes-error attention attention-info"></div>
                </div>
                <div class="field field-last">
                    <input class="js-form-button pos-btn-submit btn-gradient btn-submit btn-bordered" type="submit" value="Отправить">
                    <input class="js-apply-reset btn-reset" type="reset" value="Отмена">
                    <div class="js-form-error apply-error"></div>
                </div>
            </form>
        </div>
    </div>
</div>
