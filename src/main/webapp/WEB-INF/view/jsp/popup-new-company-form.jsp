<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="new-company-form-container">
    <div class="form-opacity"></div>
    <div class="new-company-input-container">
        <div class="new-company-title"> Добавить организацию</div>
        <div class="field">
            <span class="left-label new-company-name-title">Название&nbsp;<span class="attention">*</span></span>
            <input class="new-company-input js-input input pos-input margin-top-8" name="name" id="company-name" placeholder="Название"/>
            <div class="js-field-response js-new-company-response attention attention-info"></div>
        </div>

        <div class="field">
            <span class="left-label new-company-site-title">Сайт организации</span>
            <input class="new-company-input js-input input pos-input margin-top-8" name="site" id="company-site"placeholder="Сайт"/>
        </div>
        <div class="js-confirm-new-company pos-btn-big btn-gradient btn-big btn-inline">Добавить</div>
        <button class="close-new-company-form">Отмена</button>
    </div>
</div>