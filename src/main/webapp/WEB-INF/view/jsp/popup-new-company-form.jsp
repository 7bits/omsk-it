<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="js-new-company-form-container popup-container">
    <div class="form-opacity"></div>
    <div class="popup-form-container popup-form-new-company-container">
        <div class="title popup-title"> Добавить организацию</div>
        <div class="box-content">
            <div class="field">
                <span class="left-label new-company-label">Название&nbsp;<span class="attention">*</span></span>
                <input class="new-company-input js-input input pos-input  " name="name" id="company-name" placeholder="Название"/>
                <div class="js-field-response js-new-company-response attention attention-info attention-new-company"></div>
            </div>

            <div class="field">
                <span class="left-label new-company-label">Сайт организации</span>
                <input class="new-company-input js-input input pos-input  " name="site" id="company-site"placeholder="Сайт"/>
            </div>
            <div class="popup-btn-container">
                <div class="js-confirm-new-company btn-gradient btn-big btn-inline">Добавить</div>
                <button class="btn-reset js-close-new-company-form">Отмена</button>
            </div>
        </div>
    </div>
</div>