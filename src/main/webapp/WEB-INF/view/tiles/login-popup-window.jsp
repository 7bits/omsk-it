<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="login-container">
    <div class="login-form-opacity"></div>
    <div class="login-form-container">
        <div class="login-container-text"> Войти</div>
        <form class="login-form" method="POST">
            <table class="login-inputs">
                <tbody>
                <tr>
                    <td>Логин:</td>
                    <td><input type="login" class="login-input"/></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" class="password-input"/></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" class="login-confirm-button" value="Войти" />
        </form>
        <button class="close-login-button"></button>

    </div>
</div>
