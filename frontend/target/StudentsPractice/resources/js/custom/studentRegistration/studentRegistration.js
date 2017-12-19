var elements = {};

$(document).ready(function () {

    elements = {
        studentRegSubmitBtn : $('#student_reg_submit_btn'),
        facultyName : $('#student_faculty'),
        specialityName : $('#student_speciality')
    };

    getFaculties();

    elements.facultyName.change(function(){
        getSpecialitiesByFacultyId()
    });

    elements.studentRegSubmitBtn.click(function(){
        registrationStudent()
    });


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

            success: function () {
                alert("Student '" + $('#student_firstName').val() + " " + $('#student_firstName').val() + "' registered successfully");
                window.location.href = "/adminPage"
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
                elements.facultyName.append($("<option></option>").attr("value", data[i].id).text(data[i].name));
            }
            getSpecialitiesByFacultyId();
        }
    });
}


function getSpecialitiesByFacultyId() {
    $.ajax({
        url: 'faculty/'+elements.facultyName.val()+'/specialities',
        type: 'GET',
        contentType: "application/json; charset=UTF-8",
        success: function (data) {
            elements.specialityName.empty();
            for(var i = 0; i < Object.keys(data).length; i++){
                elements.specialityName.append($("<option></option>").attr("value", data[i].id).text(data[i].name));
            }
        }
    });
}