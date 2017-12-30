
$(document).ready( function () {
    getFaculties();

    $('#faculty_reg_submit_btn').click(function () {
        registrationFaculty();
    });

    function registrationFaculty(){

        $.ajax({
            type: "POST",
            contentType: "application/json; charset=UTF-8",
            url: "/facultyRegistration",
            data: JSON.stringify(
                {
                    "name":$('#faculty_name').val()
                }),
            success: function (data) {
                if(data.name){
                    $("#name-error").html(data.name);
                }
                else{
                    swal({
                        title: "Success",
                        text: "Faculty '" + $('#faculty_name').val() + "' created successfully",
                        type: "success",
                        confirmButtonText: "Ok",
                        onClose: function() {
                            window.location.href = "/adminPage"
                        }
                    });
                }
            }
        });
    }

    function getFaculties() {
        $.ajax({
            url: '/getFaculties',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            data: '',
            success: function (data) {
                for(var i = 0; i < Object.keys(data).length; i++){
                    $('#existing_faculties').append($("<option></option>").attr("value", data[i].id).text(data[i].name));
                }
            }
        });
    }
});

function removeError() {
    $("#name-error").html("");
}


