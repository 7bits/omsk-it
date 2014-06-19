$(document).ready(function() {
    $(document).on('click', '.js-subscribe-button', function(event) {
    event.preventDefault();
    doAjaxSubscriptionPost($('.js-subscribe-form'));
    });
    //Subscription
    $(document).on('click', '.js-subscribe-button-top',function(event) {
        event.preventDefault();
    doAjaxSubscriptionPost($('.js-subscribe-form-top'));
    });
    //Subscription
});

var doAjaxSubscriptionPost = function(form) {
    responseField = form.hasClass('js-subscribe-form-top') ? $('.js-subscribe-response-top') : $('.js-subscribe-response');
    $.ajax({
        url: subscribeUrl,
        type: 'POST',
        data: form.serialize(),
        dataType: 'json',

        success: function(response) {

            if (response.status == 'SUCCESS') {
                responseField.html(response.result.message);
                form[0].reset();
                setTimeout(function() {
                    responseField.empty();
                }, 5000);
            } else {
                responseField.html(response.result.email);
            }
        },

        error: function(jqXHR, textStatus, errorThrown) {
            responseField.empty();
            responseField.html.html('Сервер не отвечает.');
        }
    });
};
