
$(document).ready(function () {

    getFaculties();

    $('#student_faculty').change(function(){
        getSpecialitiesByFacultyId()
    });

    $('#student_reg_submit_btn').click(function(){
        registrationStudent()
    });

    function registrationStudent() {
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=UTF-8",
            url:"/registrationStudent",
            data:JSON.stringify(
                {
                    "role":"ROLE_STUDENT",
                    "username":$('#student_username').val(),
                    "password":($('#student_password').val()),

                    "firstName":$('#student_firstName').val(),
                    "lastName":$('#student_lastName').val(),
                    "email":$('#student_email').val(),

                    "faculty":$('#student_faculty').val(),
                    "speciality":$('#student_speciality').val(),

                    "groupNumber":$('#student_groupNumber').val()
                }),

            success: function (data) {
                if(data.username){
                    $("#name-error").html(data.username);
                }
                else if(data.email){
                    $("#email-name-error").html(data.email);
                }
                else{
                    swal({
                        title: "Success",
                        text: "Student '" + $('#student_firstName').val() + " " + $('#student_lastName').val() + "' registered successfully",
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
                    $('#student_faculty').append($("<option></option>").attr("value", data[i].id).text(data[i].name));
                }
                getSpecialitiesByFacultyId();
            }
        });
    }

    function getSpecialitiesByFacultyId() {
        $.ajax({
            url: 'faculty/'+$('#student_faculty').val()+'/specialities',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                $('#student_speciality').empty();
                for(var i = 0; i < Object.keys(data).length; i++){
                    $('#student_speciality').append($("<option></option>").attr("value", data[i].id).text(data[i].name));
                }
            }
        });
    }

});

function removeError() {
    $("#name-error").html("");
    $("#email-name-error").html("");
}