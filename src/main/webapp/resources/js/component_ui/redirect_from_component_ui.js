'use strict';

window.redirectFormComponentUI = flight.component(
    function() {
        this.hideErrors = function() {
            window.location.replace("/");
        };

        this.after('initialize', function() {
            this.on('submit-done', this.hideErrors);
        });
    });
