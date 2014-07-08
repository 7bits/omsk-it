'use strict';

window.autocompliteComponentUI = flight.component(
    function() {
        this.showAutocomplete = function(value) {
            var data = [].concat(value);
            this.$node.autocomplete({
                source: data
            });
        };

        this.after('initialize', function() {
            this.on('search-done', function(e, v) {
                this.showAutocomplete(v);
            });
        });
    });
