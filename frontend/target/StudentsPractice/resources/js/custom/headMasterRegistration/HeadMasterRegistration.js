
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
                    alert(data.username);
                }
                else{
                    alert("Headmaster '" + $('#headMaster_username').val() + "' registered successfully");
                    window.location.href = "/adminPage"
                }
            }
        });
    }
});



