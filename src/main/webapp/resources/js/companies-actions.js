$(document).ready(function() {
    
    $(".js-company-input").focus(doAjaxGetCompanies);
    //List of available companies 

    $(".js-new-company-form-open").click(function() {
        $(".js-new-company-form-container").show();
    });
    //Opening popups to add a new company

    $(".js-confirm-new-company").click(doAjaxAddNewCompany);
    //Submitting to add a new company

    $(".close-new-company-form").click(onNewCompanyFormClose);
    //Closing popups 
});
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
                $(".js-new-company-form-container").hide();
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
    $(".js-new-company-form-container").hide();
}
