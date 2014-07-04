'use strict';

window.loginFormComponentUI = flight.component(
    function() {
        this.defaultAttrs({
            errorFieldSelector: '.js-login-message-error'
        });

        this.showError = function(message) {
            this.select('errorFieldSelector').html(message);
        };

        this.reloadPAge = function() {
            window.location.reload();
        };

        this.after('initialize', function() {
            this.on('login-done', this.reloadPAge);
            this.on('login-error', function(e, v){
                this.showError(v.message);
            });
        });
    });
