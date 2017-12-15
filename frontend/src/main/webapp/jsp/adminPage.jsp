<%--
  Created by IntelliJ IDEA.
  User: littleF
  Date: 15.10.2017
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Administration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <jsp:include page="/jsp/blocks/navigationBar.jsp"/>
    <link href="../resources/css/libs/bootstrap-table.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="../resources/js/libs/bootstrap-table.js"></script>
</head>
<body>

<div class="container">

    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Information about all students" />
    </jsp:include>

    <div class="btn-toolbar">

            <a href="#" class="btn btn-primary">Show all requests</a>

            <a href="#" class="btn btn-primary"><span></span> Create faculty</a>
            <a href="#" class="btn btn-primary"><span></span> Create speciality</a>
            <a href="/studentRegistrationPage" class="btn btn-primary"><span></span> Register student</a>
            <a href="/headMasterRegistrationPage" class="btn btn-primary"><span></span> Register head of practice</a>

    </div>
</div>

<div class="container">

    <table  data-toggle="table"
           data-click-to-select="true"
           data-pagination="true"
           data-page-size="4"
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
            <th data-field="id" data-formatter="LinkFormatter">Show</th>
        </tr>
        </thead>
    </table>
</div>
<br/>

    <div class="container">
        <div class="btn-toolbar">
            <button type="submit" class="btn btn-danger">Delete student(s)</button>
            <button type="submit" class="btn btn-primary">Assign student(s)</button>
            <button type="submit" class="btn btn-primary">Release student(s)</button>
        </div>
    </div>


<script>
    function LinkFormatter(value, row, index) {
        return "<a href=\"userPage/"+value+"\" class=\"btn btn-primary\">Show</a>";
    }
</script>


<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>