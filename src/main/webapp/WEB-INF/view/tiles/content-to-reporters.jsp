<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <div class="text-content-up">
            Быть докладчиком на IT-субботнике очень круто!<br>
            Поделитесь своим бесценным опытом с омским IT-сообществом. Приходите выступать на субботниках. Если нужно, мы поможем с составлением доклада и презентации.<br>
            <br>
            Хотите что-нибудь рассказать на одном из Омских IT-субботников? Тогда заполните специальную форму, и мы с вами свяжемся!

            <a href='<c:url value="/apply-for-report"/>'>
                <div class="center-div">
                    <span class="button-submit">
                    Подать заявку на выступление
                    </span>
                </div>
            </a>
        </div>

        <div class="box">
            <h1 class="title">
                Рекомендации докладчикам
            </h1>

            <div class="list">
                <ol>
                    <li><span class="list-num">1</span> <b>Презентация с котиками</b></li>
                    <li><span class="list-num">2</span> Не использовать корпоративную символику</li>
                    <li><span class="list-num">3</span> Никакой рекламы</li>
                    <li><span class="list-num">4</span> ...</li>
                    <li><span class="list-num">5</span> PROFIT!</li>
                </ol>
            </div>
        </div>
        <a name="suggest"></a>
        <div class="request">
            <div class="text-content-down">
                Если вы хотите услышать доклад по определенной теме, но не знаете, кто мог бы об этом
                рассказать, предложите тему. Мы не обещаем, что удовлетворим абсолютно все заявки, но это
                позволит нам понять, чего хочет аудитория, и учесть это.
            </div>

            <div class="center-div">
                <a href='<c:url value="/suggest"/>'>
                    <span class="button-submit">
                        Предложить тему
                    </span>
                </a>
            </div>
        </div>

        <div class="questions blue-ref">
            Возникли вопросы? Читайте <a href='<c:url value="/rules"/>'>правила</a> или пишите организаторам на <a href="mailto:admin@omskit.org">admin@omskit.org</a>
        </div>
    </div>
</div>
