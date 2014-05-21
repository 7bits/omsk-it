$(document).ready(function() {

    var buttons = [
    ".js-applyForReport-form-button",
    ".js-suggest-form-button",
    ".js-guest-form-button",
    ".js-userRegistration-form-button",
    ".js-userSocialRegistration-form-button"
    ];

    function doAction(element, index, ar){
        $(document).on('click', element, function() {
            event.preventDefault();
            doSubmit(element);
        });
    }
    buttons.forEach(doAction);

    

    $(".js-apply-reset").click(function() {
        $(".js-apply-response").empty();
        $(".js-input").toggleClass( 'input-error',false );
        $(".js-field-response").empty();
        $("#image-view").attr('src',nophotoUrl);
    });
    //Resetting the fields on the form

    $(".js-guest-register-button").click(function() {
        doAjaxGuestCheck();
    });
    //Registration

    $(".js-userRegistration-form").submit(function(event) {
    });
    //magic....

    $(".js-form-close-button").click(function() {
        $(".guest-form-div").hide()
    });
    //Closure of registration popups


});


function doValidate(response) {

    for(element in response.result){
        if (element != null){
            $('.js-' + element +'-response').html(response.result[element]);
            $('.js-' + element +'-input').toggleClass( 'input-error',true );
        }
    }
}

function doAjaxQuery(url,data,noticeField,regType){
    var typeOfReg = regType;
    responseField = $(".js-field-response");
    $.ajax({
        url: url,
        type: "POST",
        data: data,
        dataType: "json",
        beforeSend: function() {
            $(".js-input").toggleClass( 'input-error',false );
            responseField.empty();
            noticeField.html("Отправка...");
        },
        success: function(response){
                    if(typeOfReg === 'socialReg') {
                        notificationField.html(response.result.message);
                        if (response.status == "FAIL") {
                            doValidate(response);
                        }
                    }
                    else{
                        $(".js-input").toggleClass( 'input-error',false );
                        noticeField.html(response.result.message);
                        responseField.text("");
                        if (response.status == "SUCCESS") {
                            $(".js-userRegistration-form")[0].reset();
                        } else {
                            doValidate(response);
                        }
                    }
        },
        error: function(){
            notificationField.empty();
            noticeField.html.html("Сервер не отвечает.");
        }
    })
}


function doSubmit(buttonTitle){
    var title = buttonTitle;
    title = title.replace('-button','');
    var formdata = $(title).serialize();
    title = title.replace('-form','');
    var noticeField = $(title + '-response');
    var url = title.replace('.js-','');
    url += 'Url';
    //Trick for Social Registration
    var successType = '';
    if (url === 'userSocialRegistration') {
        var successType = socialReg;
    }

    doAjaxQuery([url].value, formdata, noticeField, successType);
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