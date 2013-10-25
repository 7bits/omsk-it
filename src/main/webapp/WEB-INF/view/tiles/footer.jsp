<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="footer">
    <div class="page">
        <div class="subscription">
            <div class="title">
                Узнайте о начале регистрации вовремя:
            </div>

            <div class="subscribe-form">
                <form action="subscribe">
                    <input class="input-email" type="email" name="email" placeholder="Электронная почта">
                    <input class="submit-button" type="submit" value="Отправить">
                </form>
            </div>
        </div>

        <div class="tracking">
            <div class="title">
                Следите за новостями:
            </div>

            <div class="social-ref">
                <a href="https://twitter.com/OmskIT"><img src='<c:url value="/resources/images/twitter-logo.png"/>'></a>
                <a href="http://vk.com/omskit"><img src='<c:url value="/resources/images/vk-logo.png"/>'></a>
            </div>
        </div>

        <div class="site-minor-logo">
            <a href='<c:url value="/"/>'><img src='<c:url value="/resources/images/site-minor-logo.png"/>'></a>
        </div>

        <div class="copyright">
            &copy; OmskIT, 2013
        </div>
    </div>
</div>