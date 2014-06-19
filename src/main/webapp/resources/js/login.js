var onPopupLoginCancel = function() {
    $('.js-login-form-input').val('');
    $('.js-login-message-error').text('');
};

var doAjaxLoginPost = function() {
    var loginFormData = $('.js-login-form-input').serialize();
    $.ajax({
        url: loginUrl,
        type: 'POST',
        data: loginFormData,
        dataType: 'json',
        success: function(response) {
            if (response.status == 'SUCCESS') {
                $('.js-login-container').css('display', 'none');
                window.location.reload();
            } else {
                $('.js-login-message-error').html(response.result.message);
            }
        }
    })
};

$(document).ready(function() {
    $(document).on('click', '.js-close-login-button', function() {
        onPopupLoginCancel();
        $('.js-login-container').hide();
    });
    //Closing the login popups

    $(document).on('click', '.js-login-form-open', function() {
        onPopupLoginCancel();
        $('.js-login-container').show();
    });
    //Opening the login popups

    $(document).on('click', '.js-confirm-login', function(event) {
        event.preventDefault();
        doAjaxLoginPost();
    });
    //Submitting to the login popups

    $(document).on('click', '.js-cancel-login', onPopupLoginCancel);
    //Cancel to the login popups
});