
$(document).ready(function () {

    var selectedRow = [];

    $('#delete_student_btn').click(function () {
        deleteStudent();
    });

    $('#assign_student_btn').click(function () {
        getAvailablePractices();
    });

    $('#confirmAssign').click(function () {
       assignStudent();
    });



    $('#adminTable').bootstrapTable().click(function () {
        getSelectedRows();
        disableDeleteStudentBtn();
        disableAssignStudentBtn();
        disableReleaseStudentBtn();
    });


    function deleteStudent(){

        var studentIDs = [];

        for(var i in selectedRow){
            studentIDs.push(selectedRow[i].id);
        }

        $.ajax({
            type: "DELETE",
            contentType: "application/json; charset=UTF-8",
            url:"/students",
            data:JSON.stringify(studentIDs),
            success: function () {
                selectedRow = [];
                $('#adminTable').bootstrapTable('refresh');
                disableDeleteStudentBtn();
                disableAssignStudentBtn();
                disableReleaseStudentBtn();
            }
        });
    }

    function getSelectedRows() {

        selectedRow = $('#adminTable').bootstrapTable('getSelections');
    }

    function disableDeleteStudentBtn() {

        if(selectedRow.length !== 0){
            $('#delete_student_btn').prop("disabled", false);

        }else {
            $('#delete_student_btn').prop("disabled", "disabled");
        }
    }

    function disableAssignStudentBtn() {

        if(selectedRow.length !== 0){
            $('#assign_student_btn').prop("disabled", false);

        }else {
            $('#assign_student_btn').prop("disabled", "disabled");
        }
    }

    function disableReleaseStudentBtn() {

        if(selectedRow.length !== 0){
            $('#release_student_btn').prop("disabled", false);

        }else {
            $('#release_student_btn').prop("disabled", "disabled");
        }
    }

    function getAvailablePractices() {
        $.ajax({
            url: '/AvailablePractice',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            data: '',
            success: function (data) {
                $('#availablePractices').empty();

                for(var i = 0; i < Object.keys(data).length; i++)
                {
                    $('#availablePractices').append($("<option></option>")
                        .attr("value", data[i].id)
                        .attr("faculty", data[i].faculty)
                        .attr("speciality", data[i].speciality)
                        .text(data[i].company + " - Available quantity: " +  data[i].availableQuantity + " (Faculty: " + data[i].faculty + "; Speciality: " + data[i].speciality + " )" ));
                }
            }
        });
    }
    
    function assignStudent() {

        var studentIDs = [];

        for(var i in selectedRow){
            studentIDs.push(selectedRow[i].id);
        }

        var confirmData = {
            practiceId:   $('#availablePractices').val(),
            studentIDs: studentIDs
        };


        $.ajax({
            type: "POST",
            contentType: "application/json; charset=UTF-8",
            url:"/appointStudents",
                data:JSON.stringify(confirmData),

                success: function () {
                    selectedRow = [];
                    $('#adminTable').bootstrapTable('refresh');
                    disableDeleteStudentBtn();
                    disableAssignStudentBtn();
                    disableReleaseStudentBtn();
                    alert("Student(s) assign successfully");
                    $('#assignModalForm').modal('toggle');
                }
            })

    }

});