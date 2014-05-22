var doAjaxChangePassword = function() {
    changePasswordFormData = $(".js-change-password-form").serialize();
    notificationField = $(".js-change-password-notification");
    errorField = $(".js-change-password-response");
    $.ajax({
        url: changePasswordUrl,
        type: "POST",
        data: changePasswordFormData,
        dataType: "json",
        beforeSend: function() {
            errorField.empty();
            notificationField.text("Изменение...");
        },
        success: function(response) {
            notificationField.empty();
            if (response.status == "SUCCESS") {
                $(".js-input").val("");
                notificationField.text(response.result.message);
            } else {
                errorField.text(response.result.message);
            }
        },
        error: function() {
            notificationField.empty();
            errorField.text("Сервер не отвечает.");
        }
    })
};

$(document).ready(function() {
    $(document).on('click', '.js-change-password', function(event) {
        event.preventDefault();
        doAjaxChangePassword();
    });
    //Submitting form to change the password
});
