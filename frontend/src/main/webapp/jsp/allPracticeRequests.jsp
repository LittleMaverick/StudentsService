
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Practice requests</title>
    <jsp:include page="/jsp/blocks/navigationBar.jsp"/>

    <link href="../resources/css/libs/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../resources/css/libs/bootstrap-table.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../resources/css/main.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../resources/css/libs/sweetalert2.min.css" rel="stylesheet" type="text/css" media="all"/>

</head>
<body>

<%--<div class="modal fade" id="assignModalForm" tabindex="-1" role="dialog" aria-labelledby="assignModalForm" aria-hidden="true">
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
</div>--%>

<div class="container">

    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Information about all practices" />
    </jsp:include>

</div>

<div class="container">

    <table  data-toggle="table"
            id="allPracticeTable"
            data-click-to-select="true"
            data-pagination="true"
            data-page-size="4"
            data-page-list=""
            data-pagination-pre-text="Previous"
            data-pagination-next-text="Next"
            data-search="true"
            data-classes="table table-hover"
            data-id-field="id"
            data-url="/allPractices">
        <thead>
        <tr>
            <th data-checkbox="true"></th>
            <th data-field="company">Company name</th>
            <th data-field="headOfPractice">Head of practice</th>
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

    <br/>

    <div class="btn-toolbar">
        <button type="submit" class="btn btn-danger" id="delete_practice_btn" disabled="disabled">Delete practice(s)</button>

        <button type="submit" class="btn btn-primary customBtn" id="edit_practice_btn" disabled="disabled">Edit practice</button>
    </div>
</div>

<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/libs/bootstrap.min.js"></script>
<script src="../resources/js/libs/bootstrap-table.js"></script>
<script src="../resources/js/libs/sweetalert2.min.js"></script>
<script src="../resources/js/custom/practiceActions/deleteUpdateActions.js"></script>

<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>