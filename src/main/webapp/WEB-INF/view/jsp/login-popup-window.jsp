<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="login-container">
    <div class="login-form-opacity"></div>
    <div class="login-form-container">
        <div class="login-container-text"> Войти</div>
        <form class="popup-login-form" method="POST">
            <table class="login-inputs">
                <tbody>
                <tr>
                    <td>Логин:</td>
                    <td><input type="text" name="login" class="login-input" autocomplete="on"/></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" name="password" class="password-input"/></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" class="login-confirm-button" value="Войти" />
            <div class = "login-message-error"></div>
        </form>
        <button class="close-login-button"></button>

    </div>
</div>
