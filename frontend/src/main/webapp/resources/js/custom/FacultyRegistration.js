var elements ={};

$(document).ready( function () {

    elements = {
        existingFaculties: $('#existing_faculties'),
        facultyRegSubmitBtn : $('#faculty_reg_submit_btn')
    };


        getFaculties();


    elements.facultyRegSubmitBtn.click(function () {
        registrationFaculty();
    });
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

        success: function () {
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
                elements.existingFaculties.append($("<option></option>").attr("value", data[i].id).text(data[i].name));
            }
        }
    });
}