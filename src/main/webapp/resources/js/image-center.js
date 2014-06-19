$(document).ready(function() {

    var maxHeight = 0;
    $('.js-reporter-title').each(function() {
        if ($(this).height() > maxHeight) {
            maxHeight = $(this).height();
        }
    });
    $('.js-reporter-title').height(maxHeight);
});

