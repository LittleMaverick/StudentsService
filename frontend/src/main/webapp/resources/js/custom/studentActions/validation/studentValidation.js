
$(document).ready(function () {

    $('#registrationStudentForm input').on('keyup', function () {
        if ($('#registrationStudentForm').valid()) {
            $('#student_reg_submit_btn').prop('disabled', false);
        } else {
            $('#student_reg_submit_btn').prop('disabled', 'disabled');
        }
    });

    $('#registrationStudentForm').validate({
        rules: {
            student_username: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
            student_password: {
                required: true,
                minlength: 4,
                maxlength: 50
            },
            password_repeat: {
                required: true,
                minlength: 4,
                maxlength: 50,
                equalTo: "#student_password"
            },
            student_firstName: {
                required: true,
                minlength: 2,
                maxlength: 50
            },
            student_lastName: {
                required: true,
                minlength: 2,
                maxlength: 50
            },
            student_email: {
                required: true,
                emailValidator: true
            },
            student_groupNumber: {
                required: true,
                minlength: 2,
                maxlength: 10,
                digits: true
            }
        },

        messages: {
            student_username: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Username must consist of at least 3 characters</p>",
                maxlength: "<p class='validation-form'>Username needs to be less than 50 characters</p>"
            },
            student_password: {
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
            student_firstName: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>First name must consist of at least 2 characters</p>",
                maxlength: "<p class='validation-form'>First name needs to be less than 50 characters</p>"
            },
            student_lastName: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Last name must consist of at least 2 characters</p>",
                maxlength: "<p class='validation-form'>Last name needs to be less than 50 characters</p>"
            },
            student_email: {
                required: "<p class='validation-form'>This field is required</p>",
                email: "<p class='validation-form'>Invalid email address</p>"
            },
            student_groupNumber: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Group must consist of at least 2 characters</p>",
                maxlength: "<p class='validation-form'>Group needs to be less than 10 characters</p>",
                digits: "<p class='validation-form'>Only numbers are allowed</p>"
            }
        }
    });

    jQuery.validator.addMethod("emailValidator", function (value, element) {
        return this.optional(element) || /^[0-9a-zA-Z-.]+@[0-9a-zA-Z-]{2,}\.[a-z]{2,}$/.test(value);
    }, "<p class='validation-form'>Please, enter a valid e-mail address</p> <p class='validation-form'>testMail@gmail.com (for example)</p>");

});