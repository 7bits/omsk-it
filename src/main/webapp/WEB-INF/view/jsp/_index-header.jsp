<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="events-history">
    <a class="link-light" href='<c:url value="/archive"/>'>Материалы предыдущих субботников</a>
</div>

<div class="action">
    <div class="action-text">
        Чтобы стать активным участником IT-субботников, вы можете:
    </div>

    <div class="buttons">
        <a href='<c:url value="/to-reporters#suggest"/>' class="left-button">
            <div class="button inline-item">
                <div class="button-img">
                    <img src='<c:url value="/resources/images/left-button.png"/>'>
                </div>
                <img class="img-center" src='<c:url value="/resources/images/button-shape.png"/>'>
                <span>Предложить тему доклада</span>
            </div>
        </a>
        <a href='<c:url value="/to-reporters"/>' class="middle-button">
            <div class="button inline-item">
                <div class="button-img">
                    <img src='<c:url value="/resources/images/middle-button.png"/>'>
                </div>
                <img class="img-center" src='<c:url value="/resources/images/button-shape.png"/>'>
                <span>Выступить с докладом на субботнике</span>
            </div>
        </a>
        <a href='<c:url value="/to-companies"/>' class="right-button">
            <div class="button inline-item">
                <div class="button-img">
                    <img src='<c:url value="/resources/images/right-button.png"/>'>
                </div>
                <img class="img-center" src='<c:url value="/resources/images/button-shape.png"/>'>
                <span>Провести субботник у себя в офисе</span>
            </div>
        </a>
    </div>
</div>