<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="login-container">
    <div class="form-opacity"></div>
    <div class="login-form-container">
        <div class="login-container-text"> Войти</div>
        <form class="popup-login-form" method="POST">
            <table class="login-inputs">
                <tbody>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" name="login" class="login-input" autocomplete="on" placeholder="Email"/></td>
                </tr>
                <tr>
                    <td>Пароль:</td>
                    <td><input type="password" name="password" class="password-input" placeholder="Пароль"/></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" class="login-confirm-button" value="Войти" />
            <div class = "login-message-error"></div>
        </form>
        <button class="close-login-button"></button>

    </div>
</div>
