<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<p>
    <c:if test="${error == true}">
        <b class="error">Invalid login or password.</b>
    </c:if>
</p>
<form method="post" action="<c:url value='/j_spring_security_check'/>">
    <div class="float-container">
        <div class="login-form-plugin-container">
            <sec:authorize  ifAnyGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR" >
                <div>
                    <sec:authentication property="principal.username"/>
                </div>
                <div class="href">
                    <a href="<c:url value="/j_spring_security_logout" />" >
                        Выйти
                    </a>
                </div>
            </sec:authorize>
            <sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR">
                <div>
                    <input class="inline-item login" type="text" placeholder="Email" name="j_username" id="j_username" size="30" maxlength="40"/>
                    <input class="inline-item login" type="password" placeholder="Пароль" name="j_password" id="j_password" size="30" maxlength="32"/>
                    <input class="inline-item enter login-form-button" type="submit" value="Вход"/>
                </div>
                <div class="href">
                    <a href="<c:url value='/user/registration'/>">
                        Регистрация на сайте
                    </a>
                </div>
            </sec:authorize>
        </div>
    </div>
</form>