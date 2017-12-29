
$(document).ready(function () {

    var selectedRow = [];

    $('#delete_practice_btn').click(function () {
        deletePractice();
    });

    $('#allPracticeTable').click(function () {
        getSelectedRows();
        disableDeletePracticeBtn();
        disableEditPracticeBtn();
    });


    function deletePractice(){

        var practiceIDs = [];

        for(var i in selectedRow){
            practiceIDs.push(selectedRow[i].id);
        }

        $.ajax({
            type: "DELETE",
            contentType: "application/json; charset=UTF-8",
            url:"/practices",
            data:JSON.stringify(practiceIDs),
            success: function () {

                alert("Practice(s) deleted successfully");

                selectedRow = [];
                $('#allPracticeTable').bootstrapTable('refresh');
                disableDeletePracticeBtn();
                disableEditPracticeBtn();
            }
        });
    }


    function getSelectedRows() {

        selectedRow = $('#allPracticeTable').bootstrapTable('getSelections');
    }

    function disableDeletePracticeBtn() {

        if(selectedRow.length !== 0){
            $('#delete_practice_btn').prop("disabled", false);

        }else {
            $('#delete_practice_btn').prop("disabled", "disabled");
        }
    }

    function disableEditPracticeBtn() {

        if(selectedRow.length === 1){
            $('#edit_practice_btn').prop("disabled", false);

        }else {
            $('#edit_practice_btn').prop("disabled", "disabled");
        }
    }

});