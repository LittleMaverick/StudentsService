
$(document).ready(function () {

    getFaculties();
    getHeadMasters();

    $('#student_faculty').change(function(){
        getSpecialitiesByFacultyId()
    });

    $('#request_submit_btn').click(function(){
        createPracticeRequest()
    });

    function createPracticeRequest() {
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=UTF-8",
            url:"/practice",
            data:JSON.stringify(
                {
                    "company":$('#request_company_name').val(),

                    "startDate":($('#request_start_date').val()),
                    "finishDate":$('#request_finish_date').val(),

                    "facultyId":$('#student_faculty').val(),
                    "specialityId":$('#student_speciality').val(),

                    "totalQuantity":$('#request_totalQuantity').val(),

                    "headOfPracticeId":$('#request_headMaster').val()
                }),

            success: function () {
                    alert("Request for practice in the company '" + $('#request_company_name').val() + "' created successfully");
                    window.location.href = "/adminPage"
            }

/*            success: function (data) {
                if(data.company){
                    $("#name-error").html(data.company);
                }
                else{
                    alert("Request for practice in the company '" + $('#request_company_name').val() + "' created successfully");
                    window.location.href = "/adminPage"
                }

            }*/

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

    function getHeadMasters() {
        $.ajax({
            url: '/headMaster',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            data: '',
            success: function (data) {
                for(var i = 0; i < Object.keys(data).length; i++){
                    $('#request_headMaster').append($("<option></option>").attr("value", data[i].id).text(data[i].name));
                }
            }
        });
    }

});

function removeError() {
    $("#name-error").html("");
    $("#email-name-error").html("");
}