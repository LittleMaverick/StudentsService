
$(document).ready(function () {

    var selectedRow = [];

    $('#delete_student_btn').click(function () {
        deleteStudent();
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

});