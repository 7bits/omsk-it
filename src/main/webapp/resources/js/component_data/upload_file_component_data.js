'use strict';

window.uploadFileComponentData = flight.component(function() {
    this.imageUpload = function(e) {
        var submitUrl = this.$node.data('source-url');
        var that = this;
        var formData = new FormData();
        formData.append('photo', this.$node[0].files[0])
        $.ajax({
            url: submitUrl,
            type: 'POST',
            data: formData,
            processData: false,
            contentType: false,
            success: function (response) {
                if (response.status == 'SUCCESS') {
                    that.trigger('upload-file-done', [response.result]);
                } else {
                    that.trigger('upload-file-error', response.result);
                }
            }
        })
     };

    this.after('initialize', function() {
        this.on('change', this.imageUpload)
    });
});
