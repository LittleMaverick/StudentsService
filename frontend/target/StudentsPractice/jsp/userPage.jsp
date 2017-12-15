
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>

    <jsp:include page="/jsp/blocks/header.jsp"/>
    <link href="../resources/css/libs/bootstrap-table.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="../resources/js/libs/bootstrap-table.js"></script>
    <script src="../resources/js/custom/userPageFunc.js"></script>
</head>
<body>
    <jsp:include page="/jsp/blocks/navigationBar.jsp"/>

    <div class="container">
        <jsp:include page="/jsp/blocks/title.jsp">
            <jsp:param name="heading" value="Student's profile" />
        </jsp:include>
    </div>

    <div class="container">
        <table data-toggle="table"
               id="studentProfileTable"
               data-classes="table table-hover"
               data-url="">
            <thead>
            <tr>
                <th data-field="lastName">Last Name</th>
                <th data-field="firstName">Name</th>
                <th data-field="faculty">Faculty</th>
                <th data-field="speciality">Speciality</th>
                <th data-field="status">Status</th>
                <th data-field="company">Company</th>
                <th data-field="practicePeriod">Period</th>
                <th data-field="groupNumber" >Group</th>
                <th data-field="email">Email</th>
            </tr>
            </thead>
        </table>
    </div>


    <jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>
