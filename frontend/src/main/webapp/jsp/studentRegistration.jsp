
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <script src="../resources/js/custom/StudentRegistration.js"></script>
</head>
<body>

<jsp:include page="/jsp/blocks/navigationBar.jsp"/>

<div class="container">

    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Registration page" />
    </jsp:include>

</div>


<div class="container">

    <div class="row">
        <div class="col">
        </div>
        <div class="col login-border">
        <form class="registrationStudentForm">

            <div class="form-group">
                <label class="control-label">Username:</label>
                    <input id="student_username" type="text" class="form-control" placeholder="Username">
            </div>

            <div class="form-group">
                <label class="control-label">Password:</label>
                    <input id="student_password" type="password" class="form-control" placeholder="Password">
            </div>

            <div class="form-group">
                <label class="control-label">First name:</label>
                    <input id="student_firstName" type="text" class="form-control" placeholder="First name">
                    <p></p>
            </div>

            <div class="form-group">
                <label class="control-label">Last name:</label>
                    <input id="student_lastName" type="text" class="form-control" placeholder="Last name">
            </div>

            <div class="form-group">
                <label class="control-label">Email:</label>
                    <input id="student_email" type="email" class="form-control" placeholder="E-mail">
            </div>

            <div class="form-group">
                <label class="control-label">Choose faculty:</label>
                    <select id="student_faculty" class="form-control">
                    </select>
            </div>

            <div class="form-group">
                <label class="control-label">Choose speciality:</label>
                    <select id="student_speciality" class="form-control">
                    </select>
            </div>

            <div class="form-group">
                <label class="control-label">Group:</label>
                    <input id="student_groupNumber" type="text" class="form-control" placeholder="473903">
            </div>

            <div class="form-group">
                <button id="student_reg_submit_btn" type="button" class="btn btn-primary btn-block">Register</button>
            </div>

        </form>
        </div>
        <div class="col">  </div>
    </div>
</div>

<br/>


<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>
