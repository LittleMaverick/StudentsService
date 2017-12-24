
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
                    alert("Speciality '" + $('#speciality_name').val() + "' create successfully");
                    window.location.href = "/adminPage"
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
