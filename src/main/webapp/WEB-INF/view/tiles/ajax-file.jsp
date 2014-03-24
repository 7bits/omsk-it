<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Пытаемся подгрузить фэйлик.
            </h1>
            <form class="js-apply-user-registration-form form-content" enctype="multipart/form-data" action='registration' method="POST">
                <div class="field">
                    <span class="left-label">Фотография</span>
                    <input class="js-photo-upload-input js-input small-input margin-top-8" path="photo" type="file" value="Загрузить" id="image" />
                    <span class="field-info">
                        <span class="js-field-info"></span>
                        <span class="js-field-response js-photo-upload-response attention"></span>
                    </span>
                </div>
                <div class="field">
                    <img id="image-view" class="photo" src=''/>
                </div>
            </form>
        </div>
    </div>
</div>
