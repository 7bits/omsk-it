$(document).ready(function() {
    
    $(".js-close-login-button").click(function() {
        onPopupLoginCancel();
        $(".login-container").hide();
    })
    //Closing the login popups

        $(".js-login-form-open").click(function() {
        $(".login-container").show();
    })
    //Opening the login popups

    $(".js-confirm-login").click(function(event) {
        event.preventDefault();
        doAjaxLoginPost();
    });
    //Submitting to the login popups

    $(".cancel-login").click(onPopupLoginCancel);
    //Cancel to the login popups
});

function onPopupLoginCancel() {
    $(".login-form-input").val("");
    $(".login-message-error ").text("");
}

function doAjaxLoginPost() {
    var loginFormData = $(".login-form-input").serialize();
    $.ajax({
        url: loginUrl,
        type: "POST",
        data: loginFormData,
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
