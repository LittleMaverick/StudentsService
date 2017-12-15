
$(document).ready(function ()
{
    var s = window.location.href;
    s = s.match(new RegExp('userPage' + '\/([^&=]+)'));
    var id = s ? s[1] : null;

    var studentsOptions = $('#studentProfileTable').bootstrapTable('getOptions');
    studentsOptions.url = '/students/'+id;
    $('#studentProfileTable').bootstrapTable('refreshOptions', studentsOptions);
    $('#studentProfileTable').bootstrapTable('refresh');


});
