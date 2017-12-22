
$(document).ready(function ()
{
    var s = window.location.href;
    s = s.match(new RegExp('userPage' + '\/([^&=]+)'));
    if (s) {
        var id = s[1];
    } else {
        var id = null;
    }

    var studentsOptions = $('#studentProfileTable').bootstrapTable('getOptions');
    studentsOptions.url = '/students/'+id;
    $('#studentProfileTable').bootstrapTable('refreshOptions', studentsOptions);
    $('#studentProfileTable').bootstrapTable('refresh');

});
