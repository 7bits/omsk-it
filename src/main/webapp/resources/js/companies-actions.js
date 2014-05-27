var doAjaxGetCompanies = function() {
    $.ajax({
        url: companiesUrl,
        type: 'POST',
        data: null,
        dataType: 'json',
        success: function(response) {
            if (response.status == 'SUCCESS') {
                companies = [].concat(response.result);
                $( '.js-company-input' ).autocomplete({
                    source: companies
                });
            }
        },
        error: function() {
        }
    });
};

var doAjaxAddNewCompany = function() {
    newCompanyData = $('.new-company-input').serialize();
    $.ajax({
        url: companyAddUrl,
        type: 'POST',
        data: newCompanyData,
        dataType: 'json',
        success: function(response) {
            if (response.status == 'SUCCESS') {
                nameOfAddedCompany = $('#company-name').val();
                $( '.js-company-input' ).val(nameOfAddedCompany);
                $('.js-new-company-form-container').hide();
            } else {
                if(response.result.name != null) {
                    $('.js-new-company-response').text(response.result.name);
                }
            }
        },
        error: function() {
        }
    });
};

var onNewCompanyFormClose = function() {
    $('#company-name').val('');
    $('#company-site').val('');
    $('.js-new-company-response').text('');
    $('.js-new-company-form-container').hide();
};

$(document).ready(function() {
    $(document).on('focus', '.js-company-input', doAjaxGetCompanies);
    //Showing a list of companies

    $(document).on('click', '.js-new-company-form-open', function() {
        $('.js-new-company-form-container').show();
    });
    //Opening popups to add a new company

    $(document).on('click', '.js-confirm-new-company', doAjaxAddNewCompany);
    //Submitting to add a new company

    $(document).on('click', '.js-close-new-company-form', onNewCompanyFormClose);
    //Closing popups 
});