

$(document).ready(function () {

    $('#assignForm').on('change', function () {
        if ($('#assignForm').valid()) {
            $('#confirmAssign').prop('disabled', false);
        } else {
            $('#confirmAssign').prop('disabled', 'disabled');
        }
    });


    $('#assignForm').validate({
        rules: {
            availablePractices: {
                required: true
            }
        },

        messages: {
            availablePractices: {
                required: "<p class='validation-form'>This field is required</p>"
            }
        }
    });


});
