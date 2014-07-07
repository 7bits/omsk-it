'use strict';

window.relaodPageFormComponentUI = flight.component(
    function() {
        this.hideErrors = function() {
            window.location.reload();
        };

        this.after('initialize', function() {
            this.on('submit-done', this.hideErrors);
        });
    });
