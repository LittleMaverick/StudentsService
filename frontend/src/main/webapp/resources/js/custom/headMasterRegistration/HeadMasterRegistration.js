
$(document).ready(function () {

    $('#headMaster_reg_submit_btn').click(function(){
        headMasterRegistration()
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
            success: function (data) {
                if(data.username){
                    $("#name-error").html(data.username);
                }
                else{
                    swal({
                        title: "Success",
                        text: "Headmaster '" + $('#headMaster_name').val() + "' registered successfully",
                        type: "success",
                        confirmButtonText: "Ok",
                        onClose: function() {
                            window.location.href = "/admin"
                        }
                    });
                }
            }
        });
    }
});

function removeError() {
    $("#name-error").html("");
}

