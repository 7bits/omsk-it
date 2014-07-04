'use strict';

window.sameHeightComponent = flight.component(
    function() {
        this.defaultAttrs({
            sameHeightSelector: ".js-same-height"
        });

        this.doSameHeight = function() {
            var maxHeight = 0;
            this.select('sameHeightSelector').each(function() {
                var currentHeight = $(this).height();
                if (maxHeight < currentHeight) {
                    maxHeight = currentHeight;
                }
            });
            this.select('sameHeightSelector').height(maxHeight);
        };

        this.after('initialize', function() {
            this.doSameHeight();
        });
    });
