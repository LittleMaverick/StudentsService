var elements ={};

$(document).ready( function () {

    elements = {
        existingFaculties: $('#existing_faculties'),
        specialityRegSubmitBtn : $('#speciality_reg_submit_btn')
    };

    getFaculties();

    elements.specialityRegSubmitBtn.click(function () {
        registrationSpeciality();
    });
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

            })

    });
    window.location.href = "/adminPage"
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