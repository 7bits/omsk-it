<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="header">
    <div class="page">
        <div class="site-logo">
            <a href='<c:url value="/"/>'>
                <img src='<c:url value="/resources/images/site-logo.png"/>'>
                <span class="title">СУББОТНИКИ</span>
                <span class="minor-title">Мини-конференции. Омск</span>
            </a>
        </div>

        <div class="site-nav">
            <ul>
                <li><a href='<c:url value="/rules"/>'>Правила</a></li>
                <li><a href='<c:url value="/archive"/>'>Архив</a></li>
                <li><a href='<c:url value="/to-reporters"/>'>Докладчикам</a></li>
                <li><a href='<c:url value="/to-companies"/>'>Компаниям</a></li>
            </ul>
        </div>

        <div class="social-ref">
            <a class="twitter" href="https://twitter.com/OmskIT"></a>
            <a class="vkontakte" href="http://vk.com/omskit"></a>
        </div>
    </div>
</div>