
var elements = {};


$(document).ready(function () {

    elements = {
        headMasterRegSubmitBtn : $('#headMaster_reg_submit_btn')
    };


    elements.headMasterRegSubmitBtn.click(function(){
        headMasterRegistration()
    });
});

function headMasterRegistration() {
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url: "/headMasterRegistration",
        data: JSON.stringify(
            {
                "role": "ROLE_HEADMASTER",
                "username": $('#headMaster_username').val(),
                "password": ($('#headMaster_password').val()),

                "name": $('#headMaster_name').val()
            }),

                success: function () {
                    alert("Headmaster '" + $('#headMaster_username').val() + "' registered successfully");
                    window.location.href = "/adminPage"
                }

    });
}

