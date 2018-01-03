

$(document).ready(function () {

    $('#practiceRequestCreation').validate({
        rules: {
            company_name: {
                required: true,
                minlength: 2,
                maxlength: 50
            },
            request_totalQuantity: {
                required: true,
                minlength: 1,
                maxlength: 100,
                digits: true
            },
            request_start_date: {
                required: true,
                date: true
            },
            request_finish_date: {
                date: true,
                required: true,
                greaterThan: "#request_start_date"
            },
            student_faculty: {
                required: true
            },
            student_speciality: {
                required: true
            },
            request_headMaster: {
                required: true
            }
        },

        messages: {
            company_name: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Company name must consist of at least 2 characters</p>",
                maxlength: "<p class='validation-form'>Company name needs to be less than 50 characters</p>"
            },
            request_totalQuantity: {
                required: "<p class='validation-form'>This field is required</p>",
                minlength: "<p class='validation-form'>Total quantity must consist of at least 1 character</p>",
                maxlength: "<p class='validation-form'>Total quantity needs to be less than 100 characters</p>",
                digits: "<p class='validation-form'>Only numbers are allowed</p>"
            },
            request_start_date: {
                required: "<p class='validation-form'>This field is required</p>"
            },
            request_finish_date: {
                required: "<p class='validation-form'>This field is required</p>"
            },
            student_faculty: {
                required: "<p class='validation-form'>This field is required</p>"
            },
            student_speciality: {
                required: "<p class='validation-form'>This field is required</p>"
            },
            request_headMaster: {
                required: "<p class='validation-form'>This field is required</p>"
            }
        }
    });

    $('#student_faculty').on('change', function () {
        $('#request_submit_btn').prop('disabled', 'disabled');
        setTimeout(function () {
            validateForm();
        },500);
    });

    $('#student_speciality').on('change', function () {
        setTimeout(function () {
            validateForm();
        },500);
    });


    $('#practiceRequestCreation input').on('keyup', function () {
        validateForm();
    });

    function validateForm() {

            if ($('#practiceRequestCreation').valid()) {
                $('#request_submit_btn').prop('disabled', false);
            } else {
                $('#request_submit_btn').prop('disabled', 'disabled');
            }
    }

    jQuery.validator.addMethod("greaterThan",
        function(value, element, params) {

            if (!/Invalid|NaN/.test(new Date(value))) {
                return new Date(value) > new Date($(params).val());
            }

            return isNaN(value) && isNaN($(params).val())
                || (Number(value) > Number($(params).val()));
        },
        "<p class='validation-form'>Finish date should be greater than start date of practice</p>");
});
