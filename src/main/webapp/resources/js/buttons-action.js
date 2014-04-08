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
        var formdata = $(".js-subscribe-form").serialize();
        doAjaxSubscriptionPost(formdata);
    });
    $(".js-subscribe-button-top").click(function(event) {
        event.preventDefault();
        var formdata = $(".js-subscribe-form-top").serialize();
        doAjaxSubscriptionPost(formdata);
    });

    $(".js-apply-form-button").click(function(event) {

        event.preventDefault();
        doAjaxApplyForReportPost();
    });

    $(".js-apply-user-registration-form").submit(function(event) {
    });

    $(".js-apply-reset").click(function() {

        $(".js-apply-response").empty();
        $(".js-input").css("background-color", "#ffffff");
        $(".js-field-info").css("display", "inline");
        $(".js-field-response").empty();
        $("#image-view").attr('src',nophotoUrl);
    });


    $(".js-theme-button").click(function() {

        window.location.href = suggestUrl;
    });

    $(".js-suggestion-form-button").click(function(event) {

        event.preventDefault();
        doAjaxSuggestPost();
    });

    $(".js-guest-register-button").click(function() {
        doAjaxGuestCheck();
    });

    $(".js-guest-form-button").click(function(event) {
        event.preventDefault();
        doAjaxGuestPost();
    });

    $(".js-form-close-button").click(function() {
        $(".guest-form-div").css("display", "none");
    });

    $(".close-login-button").click(function() {
        $(".login-container").css("display", "none");
    })

    $(".login-form-open-button").click(function() {
        onPopupLoginCancel();
        $(".login-container").css("display", "block");
    })

    $(".login-confirm-button").click(function(event) {
        event.preventDefault();
        doAjaxLoginPost();
    });
//
    $(".js-company-input").focus(doAjaxGetCompanies);

    $(".new-company-add-open").click(function() {
        $(".new-company-form-container").css("display","block");
    });

    $(".new-company-add-confirm").click(doAjaxAddNewCompany);

    $(".change-password").click(function(event) {
        event.preventDefault();
        doAjaxChangePassword();
    });

    $(".image").change(onFileUploaded);

    $(".close-new-company-form").click(onNewCompanyFormClose);

    $(".js-apply-user-registration-form-button").click(function(event) {
        event.preventDefault();
        doAjaxUserRegistration();
    });

    $(".cancel-login").click(onPopupLoginCancel);
});

function onPopupLoginCancel() {
    $(".login-input").val("");
    $(".password-input").val("");
}

function onFileUploaded(event) {
    if ( event.originalEvent.target.files[0].size > 10485760) {
        //Reload input:file's container
        document.getElementsByClassName("image")[0].parentNode.innerHTML = document.getElementsByClassName("image")[0].parentNode.innerHTML;
        $(".image").change(onFileUploaded);
        $(".js-photo-upload-response").text("Размер фотографии не должен превышать 10 мегабайт.");
        setTimeout(function() {
            $(".js-photo-upload-response").text("");
        },3000);
    } else {
        formData = new FormData();
        imageInput = document.getElementsByClassName("image")[0];
        formData.append("photo", imageInput.files[0]);
        $.ajax({
            url: fileUpload,
            type: "POST",
            data: formData,
            processData: false,  // tell jQuery not to process the data
            contentType: false,   // tell jQuery not to set contentType
            success: function(response) {
                image_container = document.getElementsByClassName("image-view")[0];
                image_container.src = temporaryImage + "/" + response.result.name;
            }
        })
    }
}

function doAjaxSubscriptionPost(formdata) {

//    var formdata = $(".js-subscribe-form").serialize();

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

function doAjaxUserRegistration() {
    var userRegistrationFormData = $(".js-apply-user-registration-form").serialize();
    $.ajax({
        url: userRegistrationUrl,
        type: "POST",
        data: userRegistrationFormData,
        dataType: "json",
        success: function(response) {
            if (response.status == "SUCCESS") {
                $(".js-apply-form")[0].reset();
                $(".js-field-info").css("display", "inline");
            } else {
                if (response.result.firstName != null) {
                    $(".js-first-name-response").html(response.result.firstName);
                    $(".js-first-name-input").css("background-color", "#fff5e5");
                }

                if (response.result.secondName != null) {
                    $(".js-second-name-response").html(response.result.secondName);
                    $(".js-second-name-input").css("background-color", "#fff5e5");
                }

                if (response.result.email != null) {
                    $(".js-email-response").html(response.result.email);
                    $(".js-email-input").css("background-color", "#fff5e5");
                }

                if (response.result.password != null) {
                    $(".js-password-response").html(response.result.password);
                    $(".js-password-input").css("background-color", "#fff5e5");
                }

                if (response.result.company != null) {
                    $(".js-company-response").html(response.result.company);
                    $(".js-company-input").css("background-color", "#fff5e5");
                }

                if (response.result.jobPosition != null) {
                    $(".js-job-position-response").html(response.result.jobPosition);
                    $(".js-job-position-input").css("background-color", "#fff5e5");
                }
            }
        },
        error: function(response) {
            var t =10;
        }
    })
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
            $(".js-field-info").css("display", "none");
            $(".js-field-response").empty();

            if (response.status == "SUCCESS") {
                $(".js-apply-form")[0].reset();
                $(".js-field-info").css("display", "inline");
            } else {
                if (response.result.firstName != null) {
                    $(".js-first-name-response").html(response.result.firstName);
                    $(".js-first-name-input").css("background-color", "#fff5e5");
                }

                if (response.result.secondName != null) {
                    $(".js-second-name-response").html(response.result.secondName);
                    $(".js-second-name-input").css("background-color", "#fff5e5");
                }

                if (response.result.email != null) {
                    $(".js-email-response").html(response.result.email);
                    $(".js-email-input").css("background-color", "#fff5e5");
                }

                if (response.result.password != null) {
                    $(".js-password-response").html(response.result.password);
                    $(".js-password-input").css("background-color", "#fff5e5");
                }

                if (response.result.company != null) {
                    $(".js-company-response").html(response.result.company);
                    $(".js-company-input").css("background-color", "#fff5e5");
                }

                if (response.result.jobPosition != null) {
                    $(".js-job-position-response").html(response.result.jobPosition);
                    $(".js-job-position-input").css("background-color", "#fff5e5");
                }

                if (response.result.title != null) {
                    $(".js-title-response").html(response.result.title);
                    $(".js-title-input").css("background-color", "#fff5e5");
                }

                if (response.result.description != null) {
                    $(".js-description-response").html(response.result.description);
                    $(".js-description-input").css("background-color", "#fff5e5");
                }

                if (response.result.keyTechnologies != null) {
                    $(".js-key-technologies-response").html(response.result.keyTechnologies);
                    $(".js-key-technologies-input").css("background-color", "#fff5e5");
                }

                if (response.result.otherConferences != null) {
                    $(".js-other-conferences-response").html(response.result.otherConferences);
                    $(".js-other-conferences-input").css("background-color", "#fff5e5");
                }

                if (response.result.speechExperience != null) {
                    $(".js-speech-experience-response").html(response.result.speechExperience);
                    $(".js-speech-experience-input").css("background-color", "#fff5e5");
                }

                if (response.result.reporterWishes != null) {
                    $(".js-reporter-wishes-response").html(response.result.reporterWishes);
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

function doAjaxSuggestPost() {

    var formdata = $(".js-suggestion-form").serialize();

    $.ajax({

        url: suggestUrl,
        type: "POST",
        data: formdata,
        dataType: "json",

        success: function(response) {

            $(".js-suggest-response").html(response.result.message);
            $(".js-input").css("background-color", "#ffffff");
            $(".js-field-info").css("display", "none");
            $(".js-field-response").empty();

            if (response.status == "SUCCESS") {
                $(".js-suggestion-form")[0].reset();
                $(".js-field-info").css("display", "inline");
            } else {
                if (response.result.senderSpecialization != null) {
                    $(".js-senderSpecialization-response").html(response.result.senderSpecialization);
                }
                if (response.result.senderSpecializationOther != null) {
                    $(".js-senderSpecializationOther-response").html(response.result.senderSpecializationOther);
                    $(".js-sender-specialization-other-input").css("background-color", "#fff5e5");
                }
                if (response.result.favoriteTheme != null) {
                    $(".js-favoriteTheme-response").html(response.result.favoriteTheme);
                }
                if (response.result.favoriteThemeOther != null) {
                    $(".js-favoriteThemeOther-response").html(response.result.favoriteThemeOther);
                    $(".js-sender-favorite-theme-input").css("background-color", "#fff5e5");
                }
                if (response.result.themeRequest != null) {
                    $(".js-themeRequest-response").html(response.result.themeRequest);
                }
            }
        },

        error: function(jqXHR, textStatus, errorThrown) {

            console.log(jqXHR);
            console.log(jqXHR.responseText);
            $(".js-suggest-response").html(textStatus + ": " + errorThrown + "; see console logs");
        }
    });
}

function doAjaxGuestPost() {

    var formdata = $(".js-guest-form").serialize();

    $.ajax({

        url: guestUrl,
        type: "POST",
        data: formdata,
        dataType: "json",

        success: function(response) {

            $(".js-guest-response").html(response.result.message);
            $(".js-input").css("background-color", "#ffffff");
            $(".js-field-info").css("display", "none");
            $(".js-field-response").empty();

            if (response.status == "SUCCESS") {
                $(".js-guest-form")[0].reset();
                $(".js-field-info").css("display", "inline");
            } else {
                if (response.result.firstName != null) {
                    $(".js-firstName-response").html(response.result.firstName);
                    $(".js-first-name-input").css("background-color", "#fff5e5");
                }
                if (response.result.secondName != null) {
                    $(".js-secondName-response").html(response.result.secondName);
                    $(".js-second-name-input").css("background-color", "#fff5e5");
                }
                if (response.result.email != null) {
                    $(".js-email-response").html(response.result.email);
                    $(".js-email-input").css("background-color", "#fff5e5");
                }
                if (response.result.company != null) {
                    $(".js-company-response").html(response.result.company);
                    $(".js-company-input").css("background-color", "#fff5e5");
                }
                if (response.result.jobPosition != null) {
                    $(".js-jobPosition-response").html(response.result.jobPosition);
                }
                if (response.result.jobPositionOther != null) {
                    $(".js-jobPosition-response").html(response.result.jobPositionOther);
                    $(".js-job-position-other-input").css("background-color", "#fff5e5");
                }
                if (response.result.password != null) {
                    $(".js-password-response").html(response.result.password);
                    $(".js-password-input").css("background-color", "#fff5e5");
                }
            }
        },

        error: function(jqXHR, textStatus, errorThrown) {

            console.log(jqXHR);
            console.log(jqXHR.responseText);
            $(".js-suggest-response").html(textStatus + ": " + errorThrown + "; see console logs");
        }
    });
}

function doAjaxGuestCheck() {
    $.ajax({
        url: guestCheckUrl,
        type: "POST",
        data: "",
        dataType: "json",
        success: function(response) {
            if (response.status == "SUCCESS") {
                $(".success-guest-notification-container").show();
                setTimeout(function() {
                    $(".success-guest-notification-container").hide('slow',function(){});
                },2000);
            } else {
                $(".guest-form-div").css("display", "block");
                $(".guest-form-div").append("<div class='overlay'></div>");
            }
        }
    })
}

function doAjaxLoginPost() {
    var formData = $(".popup-login-form").serialize();
    $.ajax({
        url: loginUrl,
        type: "POST",
        data: formData,
        dataType: "json",
        success: function(response) {
            if (response.status == "SUCCESS") {
                $(".login-container").css("display", "none");
                window.location.reload();
            } else {
                $(".login-message-error").html(response.result.message);
            }
        }
    })
}

function doAjaxGetCompanies() {
    $.ajax({
        url: companiesUrl,
        type: "POST",
        data: null,
        dataType: "json",
        success: function(response) {
            if (response.status == "SUCCESS") {
                companies = [].concat(response.result);
                $( ".js-company-input" ).autocomplete({
                    source: companies
                });
            }
        },
        error: function() {
        }
    });
}

function doAjaxAddNewCompany() {
    newCompanyData = $(".new-company-input").serialize();
    $.ajax({
        url: companyAddUrl,
        type: "POST",
        data: newCompanyData,
        dataType: "json",
        success: function(response) {
            if (response.status == "SUCCESS") {
                nameOfAddedCompany = $("#company-name").val();
                $( ".js-company-input" ).val(nameOfAddedCompany);
                $(".new-company-form-container").hide();
            } else {
                if(response.result.name != null) {
                    $(".js-new-company-response").text(response.result.name);
                }
            }
        },
        error: function() {
        }
    });
}

function onNewCompanyFormClose() {
    $("#company-name").val("");
    $("#company-site").val("");
    $(".js-new-company-response").text("");
    $(".new-company-form-container").hide();
}

function doAjaxChangePassword() {
    changePasswordFormData = $(".change-password-form").serialize();
    $.ajax({
        url: changePasswordUrl,
        type: "POST",
        data: changePasswordFormData,
        dataType: "json",
        success: function(response) {
            if (response.status == "SUCCESS") {
                $(".js-field-response").empty();
                $(".js-password-input").empty();
                $(".js-apply-response").text(response.result.message);
            } else {
                $(".js-field-response").empty();
                $(".js-password-input").empty();
                if (response.result.email != null) {
                    $(".js-email-response").text(response.result.email);
                }
                if (response.result.oldPassword != null) {
                    $(".js-old-password-response").text(response.result.oldPassword);
                }
                if (response.result.newPassword != null) {
                    $(".js-new-password-response").text(response.result.newPassword);
                }
            }
        },
        error: function() {
            k=10;
        }
    })
}

