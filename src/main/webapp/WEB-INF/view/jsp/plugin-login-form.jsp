<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form class="js-form js-form-reload-page" method="post" action="<c:url value='/j_spring_security_check'/>">
    <div class="float-container">
        <div class="login-form-plugin-container">
            <sec:authorize  ifAnyGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR" >
                <a href="<c:url value="/j_spring_security_logout" />" >
                    <div class="inline-item btn-logout btn-gradient btn-bordered">
                        Выйти
                    </div>
                </a>
                <div class="inline-item logged-name">
                    <sec:authentication property="principal.username"/>
                </div>
            </sec:authorize>
            <sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR">
                <div class="href">
                    <div class="inline-item">
                        <a class="link-underline" href="<c:url value='/user/registration'/>">
                            Зарегистрируйтесь
                        </a>
                        или
                        <div class="js-open-login-form btn-gradient btn-middle btn-inline btn-bordered">
                            войдите
                        </div>
                        <a class="link-clear" href='<c:url value="/social/vkAuthorization"/>'>
                            <img class="vk-logo" src='<c:url value="/resources/images/vk-minor-logo2.png"/>'/>
                        </a>
                    </div>
                </div>
            </sec:authorize>
        </div>
    </div>
</form>
