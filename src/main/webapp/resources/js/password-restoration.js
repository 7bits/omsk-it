$(document).ready(function() {
    $(".js-forgot-password").click(onResetPasswordFormOpen);
    $(".js-cancel-reset-password").click(onResetPasswordFormCancel);
    $(".js-close-reset-password-button").click(onResetPasswordFormClose)
    $(".js-confirm-reset-password").click(function(event){
        event.preventDefault();
        resetPasswordAjax();
    });
});

function onResetPasswordFormOpen() {
    $(".reset-password-form-container").show();
}

function onResetPasswordFormCancel() {
    clearResetPasswordFields()
}

function onResetPasswordFormClose() {
    $(".reset-password-form-container").hide();
    clearResetPasswordFields()
}

function clearResetPasswordFields() {
    $(".reset-password-notification").empty(); //класс отсутствует в коде
    $(".reset-password-response").empty();
    $(".reset-password-email-form-input").val("");
}

function resetPasswordAjax() {
    changePasswordEmail = $(".reset-password-email-form-input").serialize();
    notificationField = $(".reset-password-notification");
    errorField = $(".reset-password-response");
    $.ajax({
        url: resetPassword,
        type: "POST",
        data: changePasswordEmail,
        dataType: "json",
        beforeSend: function() {
            errorField.empty();
            notificationField .text("Сброс...");
        },
        success: function(response) {
            clearResetPasswordFields()
            if (response.status == "SUCCESS") {
                notificationField.text(response.result.message);
            } else {
                errorField.text(response.result.message);
            }
        },
        error: function() {
            $(".reset-password-notification").empty();
            errorField.text("Сервер не отвечает.");
        }
    })
}
