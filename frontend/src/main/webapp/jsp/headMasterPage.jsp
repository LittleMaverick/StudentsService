
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Head of practice page</title>

    <link href="../resources/css/libs/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../resources/css/libs/bootstrap-table.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../resources/css/main.css" rel="stylesheet" type="text/css" media="all"/>

</head>
<body>
<jsp:include page="/jsp/blocks/navigationBar.jsp"/>

<div class="container">
    <h5 class="description">Information on the supervised students</h5>
</div>

<div class="container">
    <table data-toggle="table"
           id="headAndStudentTable"
           data-classes="table table-hover"
           data-pagination="true"
           data-page-size="2"
           data-page-list=""
           data-pagination-pre-text="Previous"
           data-pagination-next-text="Next"
           data-search="true"
           data-id-field="id"
           data-url="">
        <thead>
        <tr>

            <th data-field="firstName">First name</th>
            <th data-field="lastName">Last Name</th>
            <th data-field="company">Company</th>
            <th data-field="practicePeriod">Practice period</th>
            <th data-field="status">Status</th>
            <th data-field="faculty">Faculty</th>
            <th data-field="speciality">Speciality</th>
            <th data-field="studentId" data-formatter="LinkFormatter">More</th>

        </tr>
        </thead>
    </table>
</div>


<div class="container">
    <h5 class="description">Information on the supervised practices</h5>
</div>


<div class="container">
    <table data-toggle="table"
           id="headAndPracticeTable"
           data-classes="table table-hover"
           data-pagination="true"
           data-page-size="2"
           data-page-list=""
           data-pagination-pre-text="Previous"
           data-pagination-next-text="Next"
           data-search="true"
           data-id-field="id"
           data-url="">
        <thead>
        <tr>
            <th data-field="headOfPractice">Head of practice</th>
            <th data-field="company">Company name</th>
            <th data-field="startDate"> Start date </th>
            <th data-field="finishDate"> Finish date </th>
            <th data-field="status">Status</th>
            <th data-field="faculty">Faculty</th>
            <th data-field="speciality">Speciality</th>
            <th data-field="totalQuantity">Total</th>
            <th data-field="availableQuantity">Available</th>
        </tr>
        </thead>
    </table>
</div>

<script>
    function LinkFormatter(value) {
        return "<a href=\"/userPage/"+value+"\" class=\"btn btn-primary customBtnMore\">more...</a>";
    }
</script>

<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/libs/bootstrap.min.js"></script>
<script src="../resources/js/libs/bootstrap-table.js"></script>
<script src="../resources/js/custom/curatorPageFunc.js"></script>
<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>