

$(document).ready(function () {

    $('#specialityRegistrationForm input').on('keyup', function () {
        if ($('#specialityRegistrationForm').valid()) {
            $('#speciality_reg_submit_btn').prop('disabled', false);
        } else {
            $('#speciality_reg_submit_btn').prop('disabled', 'disabled');
        }
    });

    $('#specialityRegistrationForm').validate({
        rules: {
            speciality_name: {
                required: true,
                minlength: 2,
                maxlength: 50
            }
        },

        messages: {
            speciality_name: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Name must consist of at least 2 characters</p>",
                maxlength: "<p class='validation-form'>Name needs to be less than 50 characters</p>"
            }
        }
    });
});
