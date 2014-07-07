'use strict';

window.popupWindowComponentUI = flight.component(
    function() {
        this.defaultAttrs({
            closeButtonSelector: ".js-close-popup"
        });

        this.showPopup = function() {
            this.$node.show()
        };

        this.hidePopup = function() {
            this.$node.hide();
        };

        this.after('initialize', function() {
            var buttonShowSelector = $(this.$node.data('button-selector'));
            this.on(buttonShowSelector, 'click', this.showPopup);
            this.on(this.select('closeButtonSelector'), 'click', this.hidePopup);
        });
    });
