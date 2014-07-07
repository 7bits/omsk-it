'use strict';

window.formComponentData = flight.component(function() {
    this.defaultAttrs({
    });

    this.submitLoginForm = function(e) {
        e.preventDefault();
        this.trigger('submit-form');
        var submitUrl = this.$node.attr('action');
        var that = this;
        $.post(submitUrl, this.$node.serialize())
            .done(function(response){
                if (response.status == 'SUCCESS') {
                    that.trigger('submit-done', response.result);
                } else {
                    that.trigger('submit-error',response.result);
                }
            });
    };

    this.after('initialize', function() {
        this.on('submit', this.submitLoginForm)
    });
});
