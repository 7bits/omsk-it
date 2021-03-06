<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div class="header">
    <div class="page">
        <div class="login-form">
            <%@ include file="/WEB-INF/view/jsp/plugin-login-form.jsp" %>
        </div>
        <div class="inline-item site-logo-container">
            <a href='<c:url value="/"/>'>
                <img class="logo-img" src='<c:url value="/resources/images/site-logo.png"/>'>
                <span class="logo-title logo-title-top">СУББОТНИКИ</span>
                <span class="logo-title logo-title-bottom">Мини-конференции. Омск</span>
            </a>
        </div>
        <div class="site-nav  inline-item">
            <ul>
                <a href='<c:url value="/rules"/>'><li class="inline-item menu-item">Правила</li></a>
                <a href='<c:url value="/archive"/>'><li class="inline-item menu-item">Архив</li></a>
                <a href='<c:url value="/to-reporters"/>'><li class="inline-item menu-item">Докладчикам</li></a>
                <a href='<c:url value="/to-companies"/>'><li class="inline-item menu-item">Компаниям</li></a>
            </ul>
        </div>
        <div class="social-ref  inline-item">
            <a class="link-clear twitter inline-item social-icon" href="https://twitter.com/OmskIT" target="_blank"></a>
            <a class="link-clear vkontakte inline-item social-icon" href="http://vk.com/omskit" target="_blank"></a>
        </div>
        <%@ include file="/WEB-INF/view/jsp/popup-login-form.jsp" %>
        <%@ include file="/WEB-INF/view/jsp/popup-new-company-form.jsp" %>
        <%@ include file="/WEB-INF/view/jsp/popup-reset-password-form.jsp" %>
    </div>
</div>