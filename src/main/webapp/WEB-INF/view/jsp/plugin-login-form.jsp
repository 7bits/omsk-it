<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form method="post" action="<c:url value='/j_spring_security_check'/>">
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
                <div class = "login-input-container">
                    <input class="login" type="text" placeholder="Email" name="j_username" id="j_username" size="30" maxlength="40"/>
                    <input class="login" type="password" placeholder="Пароль" name="j_password" id="j_password" size="30" maxlength="32"/>
                    <input class="btn-gradient btn-enter btn-bordered" type="submit" value="Вход"/>
                </div>
                <div class="href">
                    <div class="inline-item">
                        <a href="<c:url value='/user/registration'/>">
                            Зарегистрируйтесь
                        </a>
                        или
                        <a href='<c:url value="/social/vkAuthorization"/>'>
                            войдите через
                        </a>
                    </div>
                    <img class="vk-logo" src='<c:url value="/resources/images/vk-minor-logo2.png"/>'/>
                </div>
            </sec:authorize>
        </div>
    </div>
</form>