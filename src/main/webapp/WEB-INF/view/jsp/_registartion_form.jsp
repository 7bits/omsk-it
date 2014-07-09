<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form class="js-form js-show-message box-content-left" action='<c:url value="/user/registration"/>' method="POST">
    <div class="form-info">
        Обязательные для заполнения поля отмечены звездочкой (<span class="attention">*</span>)
    </div>

    <div class="js-field-error js-message-error attention-info attention inline-item attention-company"></div>
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

    <div class="field field-last">
        <input class="pos-btn-submit btn-gradient btn-submit btn-bordered" type="submit" value="Отправить" />
        <input class=" btn-reset" type="reset" value="Отмена">
    </div>
</form>


<script type="text/javascript" src='<c:url value="/resources/js/component_data/ajax_search_component_data.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/component_data/upload_file_component_data.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/component_ui/autocomplete_component_ui.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/component_ui/image_preview_component_ui.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/init/reg_init.js"/>'></script>
