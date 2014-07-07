'use strict';

window.formComponentUI = flight.component(
    function() {
        this.defaultAttrs({
            errorFieldSelector: '.js-field-error'
        });

        this.showErrors = function(formErrors) {
            var that = this;
            for (var name in formErrors) {
                that.$node.find('.js-' + name + '-error').html(formErrors[name]);
            }
        };

        this.hideErrors = function() {
            this.select('errorFieldSelector').empty();
        };

        this.after('initialize', function() {
            this.on('submit-done', this.hideErrors);
            this.on('submit-form', this.hideErrors);
            this.on('submit-error', function(e, v){
                this.showErrors(v);
            });
        });
    });
