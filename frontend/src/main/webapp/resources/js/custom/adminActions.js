
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

    $('#release_student_btn').click(function () {
        releaseStudent();
    });


    $('#adminTable').on ('check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table', function () {
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

                swal({
                    title: "Success",
                    text: "Student(s) deleted successfully",
                    type: "success",
                    confirmButtonText: "Ok"
                });

                selectedRow = [];
                $('#adminTable').bootstrapTable('refresh');
                disableDeleteStudentBtn();
                disableAssignStudentBtn();
                disableReleaseStudentBtn();
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

                    swal({
                       title: "Success",
                       text: "Student(s) assign successfully",
                       type: "success",
                       confirmButtonText: "Ok"
                    });

                    $('#assignModalForm').modal('toggle');
                }
            })

    }

    function releaseStudent(){

        var studentIDs = [];

        for(var i in selectedRow){
            studentIDs.push(selectedRow[i].id);
        }

        $.ajax({
            type: "DELETE",
            contentType: "application/json; charset=UTF-8",
            url:"/releaseStudents",
            data:JSON.stringify(studentIDs),
            success: function () {

                swal({
                    title: "Success",
                    text: "Student(s) released successfully",
                    type: "success",
                    confirmButtonText: "Ok"
                });

                selectedRow = [];
                $('#adminTable').bootstrapTable('refresh');
                disableDeleteStudentBtn();
                disableAssignStudentBtn();
                disableReleaseStudentBtn();
            }
        });
    }

    function getAvailablePractices() {

        var result = selectedRow.length;

        $.ajax({
            url: '/availablePractice',
            type: 'GET',
            contentType: "application/json; charset=UTF-8",
            data: '',
            success: function (data) {
                $('#availablePractices').empty();

                for(var i = 0; i < Object.keys(data).length; i++)
                {
                    if(data[i].availableQuantity < result ){

                    }else{
                        $('#availablePractices').append($("<option></option>")
                            .attr("value", data[i].id)
                            .attr("faculty", data[i].faculty)
                            .attr("speciality", data[i].speciality)
                            .text(data[i].company + " - Available quantity: " +  data[i].availableQuantity + " (Faculty: " + data[i].faculty + "; Speciality: " + data[i].speciality + " )" ));

                    }
               }
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

        var flag = true;

        for (var i in selectedRow){
            if(selectedRow[i].status === "Busy"){
                flag = false;
                break;
            }
            else {
                flag = true;
            }
        }

        if(selectedRow.length === 0){
            flag = false;
        }

        if(flag){
            $('#assign_student_btn').prop("disabled", false);

        }else {
            $('#assign_student_btn').prop("disabled", "disabled");
        }
    }

    function disableReleaseStudentBtn() {

        var flag = true;

        for (var i in selectedRow){
            if(selectedRow[i].status === "Available"){
                flag = false;
                break;
            }
            else {
                flag = true;
            }
        }

        if(selectedRow.length === 0){
            flag = false;
        }

        if(flag){
            $('#release_student_btn').prop("disabled", false);

        }else {
            $('#release_student_btn').prop("disabled", "disabled");
        }
    }

});