'use strict';

window.imagePreviewComponentUI = flight.component(
    function() {
        this.defaultAttrs({
            previewImageSelector: '.js-img-preview'
        });

        this.showPreviewImage = function(name) {
            var newImage = "/resources/temporary/photos/" + name;
            this.select('previewImageSelector').attr('src', newImage);
        };

        this.showErrors = function(errors) {
            var that = this;
            for (var name in errors) {
                that.$node.find('.js-' + name + '-error').html(errors[name]);
            }
        };

        this.after('initialize', function() {
            this.on('upload-file-done', function(e, v) {
                this.showPreviewImage(v.name);
            });
            this.on('upload-file-error', function(e, v) {
                this.showErrors(v);
            });
        });
    });
