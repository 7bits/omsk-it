<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<p>
    <c:if test="${error == true}">
        <b class="error">Invalid login or password.</b>
    </c:if>
</p>
<form method="post" action="<c:url value='/j_spring_security_check'/>">
    <table>
        <tbody>
            <sec:authorize  ifAnyGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR" >
                <tr>
                    <td>Логин:</td>
                    <td><sec:authentication property="principal.username"/></td>
                </tr>
                <tr>
                    <td><a href="<c:url value="/j_spring_security_logout" />" >Выйти</a></td>
                </tr>
            </sec:authorize>
            <sec:authorize ifNotGranted="ROLE_ADMIN, ROLE_USER, ROLE_MODERATOR">
                <tr>
                    <td>Логин:</td>
                    <td><input type="text" name="j_username" id="j_username" size="30" maxlength="40"/></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" name="j_password" id="j_password" size="30" maxlength="32"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </sec:authorize>
        </tbody>
    </table>
</form>