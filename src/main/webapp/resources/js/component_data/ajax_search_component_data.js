'use strict';

window.ajaxSearchComponentData = flight.component(function() {
    this.searchData = function(e) {
        e.preventDefault();
        var submitUrl = this.$node.data('source-url');
        var that = this;
        $.post(submitUrl, this.$node.val())
            .done(function(response){
                if (response.status == 'SUCCESS') {
                    that.trigger('search-done', [response.result]);
                } else {
                    that.trigger('search-error',response.result);
                }
            });
    };

    this.after('initialize', function() {
        this.on('focus', this.searchData)
    });
});
