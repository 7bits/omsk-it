$(document).ready(function() {

    $(".js-guests-button").click(function() {

        window.location.href = toGuestsUrl;
    });

    $(".js-reporters-button").click(function() {

        window.location.href = toReportersUrl;
    });

    $(".js-companies-button").click(function() {

        window.location.href = toCompaniesUrl;
    });

    $(".js-subscribe-button").click(function() {

        event.preventDefault();
        doAjaxSubscriptionPost();
    });
});

function doAjaxSubscriptionPost() {

    var formdata = $(".js-subscribe-form").serialize();

    $.ajax({

        url: subscribeUrl,
        type: "POST",
        data: formdata,
        dataType: "json",

        success: function(response) {

            if (response.status == "SUCCESS") {
                $(".response").html(response.result.message);
                $(".js-subscribe-form")[0].reset();
            } else {
                $(".response").html(response.result.email);
            }
        },

        error: function(jqXHR, textStatus, errorThrown) {

            console.log(jqXHR);
            console.log(jqXHR.responseText);
            $(".response").html(textStatus + ": " + errorThrown + "; see console logs");
        }
    });
}
