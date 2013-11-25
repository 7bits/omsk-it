$(document).ready(function() {

    var maxHeight = 0;

    $(".reporter-title").each(function(){
        if ($(this).height() > maxHeight) {
            maxHeight = $(this).height();
        }
    });

    $(".reporter-title").height(maxHeight);
});

