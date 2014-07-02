<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="box">
            <h1 class="title">
                Подтверждение регистрации
            </h1>
            <div class="registration-confirm-container">
                <div class="registration-confirm-text">
                    Поздравляем, вы успешно зарегистрировались на сайте!
                    <c:if test="${!empty additionalRegistrationInfo}">
                            <c:out value="${additionalRegistrationInfo}"/>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
