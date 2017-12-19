

$(document).ready(function () {

    $('#facultyRegistrationForm input').on('keyup', function () {
        if ($('#facultyRegistrationForm').valid()) {
            $('#faculty_reg_submit_btn').prop('disabled', false);
        } else {
            $('#faculty_reg_submit_btn').prop('disabled', 'disabled');
        }
    });

    $('#facultyRegistrationForm').validate({
        rules: {
            faculty_name: {
                required: true,
                minlength: 2,
                maxlength: 50
            }
        },

        messages: {
            faculty_name: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Name must consist of at least 2 characters</p>",
                maxlength: "<p class='validation-form'>Name needs to be less than 50 characters</p>"
            }
        }
    });
});