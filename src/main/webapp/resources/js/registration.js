var doValidate = function(response) {
    for(element in response.result) {
        if (element != null) {
            $('.js-' + element +'-response').html(response.result[element]);
            $('.js-' + element +'-input').toggleClass( 'input-error',true );
        }
    }
};

var doAjaxQuery = function(url,data,noticeField,regType) {
    var typeOfReg = regType;
    responseField = $('.js-field-response');
    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        dataType: 'json',
        beforeSend: function() {
            $('.js-input').toggleClass( 'input-error',false );
            responseField.empty();
            noticeField.html('Отправка...');
        },
        success: function(response) {
                    if(typeOfReg === 'socialReg') {
                        notificationField.html(response.result.message);
                        if (response.status == 'FAIL') {
                            doValidate(response);
                        }
                    }
                    else{
                        $('.js-input').toggleClass( 'input-error',false );
                        noticeField.html(response.result.message);
                        responseField.text('');
                        if (response.status == 'SUCCESS') {
                            $('.js-userRegistration-form')[0].reset();
                        } else {
                            doValidate(response);
                        }
                    }
        },
        error: function() {
            notificationField.empty();
            noticeField.html.html('Сервер не отвечает.');
        }
    })
};

var doSubmit = function() {
    var formdata = $('.js-form').serialize();
    var noticeField = $('.js-form-response');
    url = $('.js-form').attr('action');
    //Trick for Social Registration
    var regType = '';
    if (url === 'userSocialRegistrationUrl') {
        var regType = 'socialReg';
    }   
    doAjaxQuery([url].value, formdata, noticeField, regType);
};

var doAjaxGuestCheck = function() {
    $.ajax({
        url: guestCheckUrl,
        type: 'POST',
        data: '',
        dataType: 'json',
        success: function(response) {
            if (response.status == 'SUCCESS') {
                $('.js-success-guest-notification-container').show();
                setTimeout(function() {
                    $('.js-success-guest-notification-container').hide('slow',function() {});
                },2000);
            } else {
                $('.js-guest-form-div').css('display', 'block');
                $('.js-guest-form-div').append("<div class='overlay'></div>");
            }
        }
    })
};

$(document).ready(function() {
    $(document).on('click', '.js-form-button', function() {
            event.preventDefault();
            doSubmit();
        });
    $(document).on('click', '.js-apply-reset', function() {
        $('.js-form-response').empty();
        $('.js-input').toggleClass('input-error', false);
        $('.js-field-response').empty();
        $('#image-view').attr('src',nophotoUrl);
    });
    //Resetting the fields on the form
    $(document).on('click','.js-guest-register-button', function() {
        doAjaxGuestCheck();
    });
    //Registration
    $(document).on('click', '.js-form-close-button',function() {
        $('.js-guest-form-div').hide();
    });
    //Closing of registration popups
});