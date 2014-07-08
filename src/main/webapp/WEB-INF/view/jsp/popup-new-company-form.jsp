<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="js-popup-window popup-container" data-button-selector=".js-new-company-form-open">
    <div class="form-opacity"></div>
    <div class="popup-form-container popup-form-new-company-container">
        <div class="title popup-title"> Добавить организацию</div>
        <form class="js-form box-content" type="post" action='<c:url value="/company/new"/>'>
            <div class="js-field-error js-base-error attention attention-info attention-new-company"></div>
            <div class="field">
                <span class="left-label new-company-label">Название&nbsp;<span class="attention">*</span></span>
                <input class="new-company-input input pos-input" name="name" id="company-name" placeholder="Название"/>
                <div class="js-field-error js-name-error attention attention-info attention-new-company"></div>
            </div>

            <div class="field">
                <span class="left-label new-company-label">Сайт организации</span>
                <input class="new-company-input input pos-input" name="site" id="company-site" placeholder="Сайт"/>
                <div class="js-field-error js-site-error attention attention-info attention-new-company"></div>
            </div>
            <div class="popup-btn-container">
                <input class="btn-gradient btn-big btn-inline" type="submit" value="Добавить"/>
                <input class="js-close-popup btn-reset" type="reset" value="Отмена"/>
            </div>
        </form>
    </div>
</div>
