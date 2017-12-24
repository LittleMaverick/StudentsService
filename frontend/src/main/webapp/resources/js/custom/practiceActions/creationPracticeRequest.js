


function test() {
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=UTF-8",
        url:"/test",


        success: function () {
            alert("yspex");
        }

    });
}