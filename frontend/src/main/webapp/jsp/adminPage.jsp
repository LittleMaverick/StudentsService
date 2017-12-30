
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Administration</title>
    <jsp:include page="/jsp/blocks/navigationBar.jsp"/>

    <link href="../resources/css/libs/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../resources/css/libs/bootstrap-table.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../resources/css/main.css" rel="stylesheet" type="text/css" media="all"/>

</head>
<body>

<div class="modal fade" id="assignModalForm" tabindex="-1" role="dialog" aria-labelledby="assignModalForm" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">

        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="assignModalLabel">Assign students</h4>
                <button class="close" type="button" data-dismiss="modal" aria-label="close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="assignForm">
                    <div class="form-group">
                        <label class="control-label">Choose practice: </label>
                        <select id="availablePractices" class="form-control">
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" id="confirmAssign" class="btn btn-primary customBtn">Assign</button>
            </div>
        </div>

    </div>
</div>

<div class="container">

    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Information about all students" />
    </jsp:include>

    <div class="btn-toolbar ">

            <a href="/practices" class="btn btn-primary customBtn">Show all requests</a>
            <a href="/createPracticeRequest" class="btn btn-primary customBtn"><span></span> Request for practice</a>

            <a href="/facultyRegistrationPage" class="btn btn-primary customBtn"><span></span> Create faculty</a>
            <a href="/specialityRegistrationPage" class="btn btn-primary customBtn"><span></span> Create speciality</a>
            <a href="/studentRegistrationPage" class="btn btn-primary customBtn"><span></span> Register student</a>
            <a href="/headMasterRegistrationPage" class="btn btn-primary customBtn"><span></span> Register head of practice</a>

    </div>
</div>

<div class="container">

    <table  data-toggle="table"
            id="adminTable"
           data-click-to-select="true"
           data-pagination="true"
           data-page-size="4"
           data-page-list=""
           data-pagination-pre-text="Previous"
           data-pagination-next-text="Next"
           data-search="true"
           data-classes="table table-hover"
           data-url="/students">
        <thead>
        <tr>
            <th  data-checkbox="true" >#</th>
            <th data-field="lastName" data-sortable="true">Last Name</th>
            <th data-field="firstName">Name</th>
            <th data-field="faculty">Faculty</th>
            <th data-field="speciality">Speciality</th>
            <th data-field="status" data-sortable="true">Status</th>
            <th data-field="company">Company</th>
            <th data-field="practicePeriod">Period</th>
            <th data-field="id" data-formatter="LinkFormatter">More</th>
        </tr>
        </thead>
    </table>

    <br/>

        <div class="btn-toolbar">
            <button type="submit" class="btn btn-danger" id="delete_student_btn" disabled="disabled">Delete student(s)</button>

            <button data-target="#assignModalForm" data-toggle="modal" type="submit" class="btn btn-primary customBtn" id="assign_student_btn" disabled="disabled" >Assign student(s)</button>

            <button type="submit" class="btn btn-primary customBtn" id="release_student_btn" disabled="disabled">Release student(s)</button>

        </div>
</div>

<script>
    function LinkFormatter(value) {
        return "<a href=\"/userPage/"+value+"\" class=\"btn btn-primary customBtnMore\">more...</a>";
    }
</script>

<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/libs/bootstrap.min.js"></script>
<script src="../resources/js/libs/bootstrap-table.js"></script>
<script src="../resources/js/custom/adminActions.js"></script>
<script src="../resources/js/libs/jquery.validate.min.js"></script>
<%--<script src="../resources/js/custom/assignStudentValidation.js"></script>--%>

<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>