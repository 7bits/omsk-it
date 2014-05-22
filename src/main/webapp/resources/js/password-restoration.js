var onResetPasswordFormOpen = function() {
    $('.js-reset-password-form-container').show();
};

var onResetPasswordFormCancel = function() {
    clearResetPasswordFields();
};

var onResetPasswordFormClose = function() {
    $('.js-reset-password-form-container').hide();
    clearResetPasswordFields();
};

var clearResetPasswordFields = function() {
    $('.js-reset-password-notification').empty();
    $('.js-reset-password-response').empty();
    $('.js-reset-password-email-form-input').val('');
};

var resetPasswordAjax = function() {
    changePasswordEmail = $('.js-reset-password-email-form-input').serialize();
    notificationField = $('.js-reset-password-notification');
    errorField = $('.js-reset-password-response');
    $.ajax({
        url: resetPassword,
        type: 'POST',
        data: changePasswordEmail,
        dataType: 'json',
        beforeSend: function() {
            errorField.empty();
            notificationField .text('Сброс...');
        },
        success: function(response) {
            clearResetPasswordFields()
            if (response.status == 'SUCCESS') {
                notificationField.text(response.result.message);
            } else {
                errorField.text(response.result.message);
            }
        },
        error: function() {
            $('.js-reset-password-notification').empty();
            errorField.text('Сервер не отвечает.');
        }
    })
};

$(document).ready(function() {
    $(document).on('click', '.js-forgot-password', onResetPasswordFormOpen);
    $(document).on('click', '.js-cancel-reset-password', onResetPasswordFormCancel);
    $(document).on('click', '.js-close-reset-password-button', onResetPasswordFormClose);
    $(document).on('click', '.js-confirm-reset-password', function(event){
        event.preventDefault();
        resetPasswordAjax();
    });
});
