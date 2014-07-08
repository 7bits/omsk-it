'use strict';

window.messageInsteadFormComponentUI = flight.component(
    function() {
        this.showMessage = function(message) {
            this.$node.html(message);
        };

        this.after('initialize', function() {
            this.on('submit-done', function(e, v) {
                this.showMessage(v.message);
            });
        });
    });
