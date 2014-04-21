<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="footer">
    <div class="page">
        <div class="subscription">
            <div class="subscription-title">
                Узнайте о начале регистрации вовремя:
            </div>
            <form class="js-subscribe-form subscribe-form" action='<c:url value="/subscribe"/>' method="POST">
                <input class="input-email" type="email" name="email" placeholder="Электронная почта">
                <input class="js-subscribe-button subscribe-button" type="submit" value="Отправить">
            </form>
            <span class="js-subscribe-response response"></span>
        </div>
        <div class="site-minor-logo">
             <a href='<c:url value="/"/>'><img src='<c:url value="/resources/images/site-minor-logo.png"/>'></a>
        </div>
        <div class="tracking inline-item">
            <div class="tracking-title inline-item">
               Следите за новостями:
            </div>

            <div class="inline-item">
                <a href="https://twitter.com/OmskIT"><img src='<c:url value="/resources/images/twitter-logo.png"/>'></a>
                <a href="http://vk.com/omskit"><img src='<c:url value="/resources/images/vk-logo.png"/>'></a>
            </div>
        </div>
        <div class="copyright">
            &copy; OmskIT, 2013
        </div>
    </div>
</div>