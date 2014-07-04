'use strict';

window.loginFormComponent = flight.component(function() {
    this.defaultAttrs({
    });

    this.submitLoginForm = function(e) {
        e.preventDefault();
        var that = this;
        $.post(loginUrl, this.$node.serialize())
            .done(function(response){
                if (response.status == 'SUCCESS') {
                    that.trigger('login-done');
                } else {
                    that.trigger('login-error',response.result);
                }
            });
    };

    this.after('initialize', function() {
        this.on('submit', this.submitLoginForm)
    });
});
