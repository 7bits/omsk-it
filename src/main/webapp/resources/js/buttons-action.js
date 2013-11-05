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

    $(".js-apply-button").click(function() {

        window.location.href = applyForReportUrl;
    });

    $(".js-subscribe-button").click(function(event) {

        event.preventDefault();
        doAjaxSubscriptionPost();
    });

    $(".js-apply-form-button").click(function(event) {

        event.preventDefault();
        doAjaxApplyForReportPost();
    });

    $(".js-apply-reset").click(function() {

        window.location.href = toReportersUrl;
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
                $(".js-subscribe-response").html(response.result.message);
                $(".js-subscribe-form")[0].reset();
                setTimeout(function() {
                    $(".js-subscribe-response").empty();
                }, 5000);
            } else {
                $(".js-subscribe-response").html(response.result.email);
            }
        },

        error: function(jqXHR, textStatus, errorThrown) {

            console.log(jqXHR);
            console.log(jqXHR.responseText);
            $(".js-subscribe-response").html(textStatus + ": " + errorThrown + "; see console logs");
        }
    });
}

function doAjaxApplyForReportPost() {

    var formdata = $(".js-apply-form").serialize();

    $.ajax({

        url: applyForReportUrl,
        type: "POST",
        data: formdata,
        dataType: "json",

        success: function(response) {

            $(".js-apply-response").html(response.result.message);
            $(".js-input").css("background-color", "#ffffff");
            $(".js-field-info").empty().css("color", "#f06009");

            if (response.status == "SUCCESS") {
                $(".js-apply-form")[0].reset();
            } else {
                if (response.result.firstName != null) {
                    $(".js-first-name-response").html(response.result.firstName);
                    $(".js-first-name-input").css("background-color", "#fff5e5");
                }

                if (response.result.secondName != null) {
                    $(".js-second-name-response").empty().css("color", "#f06009").html(response.result.secondName);
                    $(".js-second-name-input").css("background-color", "#fff5e5");
                }

                if (response.result.email != null) {
                    $(".js-email-response").empty().css("color", "#f06009").html(response.result.email);
                    $(".js-email-input").css("background-color", "#fff5e5");
                }

                if (response.result.job != null) {
                    $(".js-job-response").empty().css("color", "#f06009").html(response.result.job);
                    $(".js-job-input").css("background-color", "#fff5e5");
                }

                if (response.result.jobPosition != null) {
                    $(".js-job-position-response").empty().css("color", "#f06009").html(response.result.jobPosition);
                    $(".js-job-position-input").css("background-color", "#fff5e5");
                }

                if (response.result.title != null) {
                    $(".js-title-response").empty().css("color", "#f06009").html(response.result.title);
                    $(".js-title-input").css("background-color", "#fff5e5");
                }

                if (response.result.description != null) {
                    $(".js-description-response").empty().css("color", "#f06009").html(response.result.description);
                    $(".js-description-input").css("background-color", "#fff5e5");
                }

                if (response.result.keyTechnologies != null) {
                    $(".js-key-technologies-response").empty().css("color", "#f06009").html(response.result.keyTechnologies);
                    $(".js-key-technologies-input").css("background-color", "#fff5e5");
                }

                if (response.result.otherConferences != null) {
                    $(".js-other-conferences-response").empty().css("color", "#f06009").html(response.result.otherConferences);
                    $(".js-other-conferences-input").css("background-color", "#fff5e5");
                }

                if (response.result.speechExperience != null) {
                    $(".js-speech-experience-response").empty().css("color", "#f06009").html(response.result.speechExperience);
                    $(".js-speech-experience-input").css("background-color", "#fff5e5");
                }

                if (response.result.reporterWishes != null) {
                    $(".js-reporter-wishes-response").empty().css("color", "#f06009").html(response.result.reporterWishes);
                    $(".js-reporter-wishes-input").css("background-color", "#fff5e5");
                }
            }
        },

        error: function(jqXHR, textStatus, errorThrown) {

            console.log(jqXHR);
            console.log(jqXHR.responseText);
            $(".js-apply-response").html(textStatus + ": " + errorThrown + "; see console logs");
        }
    });
}
