
$(document).ready( function () {

    getFaculties();

    $('#speciality_reg_submit_btn').click(function () {
        registrationSpeciality();
    });

    function registrationSpeciality(){

        $.ajax({
            type: "POST",
            contentType: "application/json; charset=UTF-8",
            url: "/registrationSpeciality",
            data: JSON.stringify(
                {
                    "facultyId": $('#existing_faculties').val(),
                    "name":$('#speciality_name').val()
                }),
            success: function (data) {

                if(data.name) {
                    $("#name-error").html(data.name);
                }
                else{
                    swal({
                        title: "Success",
                        text: "Speciality '" + $('#speciality_name').val() + "' created successfully",
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
