$(document).ready(function() {

    $('.image').change(onImageUploaded);
    //Uploading pictures
});
function onImageUploaded(event) {
    contentType = document.getElementsByClassName('image')[0].files[0].name.split('.').pop().toLowerCase();
    isContentImage = true;
    if($.inArray(contentType, ['bmp','png','jpg','jpeg']) == -1) {
        isContentImage = false;
    }
    isSizeValid = event.originalEvent.target.files[0].size < 10485760;
    if ( !isSizeValid) {
        imageUploadError('Размер фотографии не должен превышать 10 мегабайт.');
    } else if (!isContentImage) {
        imageUploadError('Неверный формат файла.');
    } else {
        formData = new FormData();
        imageInput = document.getElementsByClassName('image')[0];
        formData.append('photo', imageInput.files[0]);
        $.ajax({
            url: fileUpload,
            type: 'POST',
            data: formData,
            processData: false,  // tell jQuery not to process the data
            contentType: false,   // tell jQuery not to set contentType
            success: function(response) {
                image_container = document.getElementsByClassName('image-view')[0];
                image_container.src = temporaryImage + '/' + response.result.name;
            }
        })
    }
};

function imageUploadError(message) {
    //Reload input:file's container
    document.getElementsByClassName('image')[0].parentNode.innerHTML = document.getElementsByClassName('image')[0].parentNode.innerHTML;
    $('.image').change(onImageUploaded);
    $('.js-photo-upload-response').text(message);
    setTimeout(function() {
        $('.js-photo-upload-response').text('');
    },3000);
};
