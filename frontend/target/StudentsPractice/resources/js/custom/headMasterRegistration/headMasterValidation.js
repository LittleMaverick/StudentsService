

$(document).ready(function () {

    $('#headMasterRegistrationForm input').on('keyup', function () {
        if ($('#headMasterRegistrationForm').valid()) {
            $('#headMaster_reg_submit_btn').prop('disabled', false);
        } else {
            $('#headMaster_reg_submit_btn').prop('disabled', 'disabled');
        }
    });

    $('#headMasterRegistrationForm').validate({
        rules: {
            headMaster_username: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
            headMaster_password: {
                required: true,
                minlength: 4,
                maxlength: 50
            },
            password_repeat: {
                required: true,
                minlength: 4,
                maxlength: 50,
                equalTo: "#headMaster_password"
            },
            headMaster_name: {
                required: true,
                minlength: 2,
                maxlength: 50
            }
        },

        messages: {
            headMaster_username: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Username must consist of at least 3 characters</p>",
                maxlength: "<p class='validation-form'>Username needs to be less than 50 characters</p>"
            },
            headMaster_password: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Password must consist of at least 4 characters</p>",
                maxlength: "<p class='validation-form'>Password needs to be less than 50 characters</p>"
            },
            password_repeat: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Password must consist of at least 4 characters</p>",
                maxlength: "<p class='validation-form'>Password needs to be less than 50 characters</p>",
                equalTo: "<p class='validation-form'>Please enter the same password as above</p>"
            },
            headMaster_name: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Name must consist of at least 2 characters</p>",
                maxlength: "<p class='validation-form'>Name needs to be less than 50 characters</p>"
            }
        }
    });
});