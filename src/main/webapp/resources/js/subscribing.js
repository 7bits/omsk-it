$(document).ready(function() {

    $(".js-subscribe-button").click(function(event) {
    event.preventDefault();
    doAjaxSubscriptionPost($(".js-subscribe-form"));
    });    //Subscription

    $(".js-subscribe-button-top").click(function(event) {
        event.preventDefault();
        doAjaxSubscriptionPost($(".js-subscribe-form-top"));
    });    //Subscription
});
function doAjaxSubscriptionPost(form) {
    responseField = form.hasClass("js-subscribe-form-top") ? $(".js-subscribe-response-top") : $(".js-subscribe-response");
    $.ajax({
        url: subscribeUrl,
        type: "POST",
        data: form.serialize(),
        dataType: "json",

        success: function(response) {

            if (response.status == "SUCCESS") {
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

            console.log(jqXHR);
            console.log(jqXHR.responseText);
            $(".js-subscribe-response").html(textStatus + ": " + errorThrown + "; see console logs");
        }
    });
}
