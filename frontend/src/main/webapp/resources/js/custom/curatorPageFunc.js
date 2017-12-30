$(document).ready(function ()
{
    var s = window.location.href;
    s = s.match(new RegExp('headMasterPage' + '\/([^&=]+)'));
    if (s) {
        var id = s[1];
    } else {
        var id = null;
    }

    var headAndPracticeOptions =  $('#headAndPracticeTable').bootstrapTable('getOptions');
    headAndPracticeOptions.url = '/practices/headMaster/' + id;
    $('#headAndPracticeTable').bootstrapTable('refreshOptions', headAndPracticeOptions);
    $('#headAndPracticeTable').bootstrapTable('refresh');

    var headAndStudentsOptions =  $('#headAndStudentTable').bootstrapTable('getOptions');
    headAndStudentsOptions.url = '/students/headMaster/' + id;
    $('#headAndStudentTable').bootstrapTable('refreshOptions', headAndStudentsOptions);
    $('#headAndStudentTable').bootstrapTable('refresh');

});
