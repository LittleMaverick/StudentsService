
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <script src="../resources/js/custom/StudentRegistration.js"></script>
<%--    <script src="../resources/js/custom/validationForms.js"></script>--%>
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
        <form class="registrationStudentForm">

            <div class="form-group">
                <label class="control-label" for="student_username">Username:</label>
                    <input id="student_username" type="text" class="form-control" placeholder="Username" minlength="3" required>
                    <ul class="input-requirements">
                        <li>At least 3 characters long</li>
                        <li>Must only contain letters and numbers (no special characters)</li>
                    </ul>
            </div>

            <div class="form-group">
                <label class="control-label" for="student_password">Password:</label>
                    <input id="student_password" type="password" class="form-control" placeholder="Password" maxlength="30" minlength="4" required>
                    <ul class="input-requirements">
                        <li>At least 4 characters long (and less than 30 characters)</li>
                    </ul>
            </div>

            <div class="form-group">
                <label class="control-label" for="student_firstName">First name:</label>
                    <input id="student_firstName" type="text" class="form-control" placeholder="First name" maxlength="50" minlength="2" required>
                    <ul class="input-requirements">
                        <li>At least 2 characters long (and less than 50 characters)</li>
                    </ul>
            </div>

            <div class="form-group">
                <label class="control-label" for="student_lastName">Last name:</label>
                    <input id="student_lastName" type="text" class="form-control" placeholder="Last name" maxlength="50" minlength="2" required>
                    <ul class="input-requirements">
                        <li>At least 2 characters long (and less than 50 characters)</li>
                    </ul>
            </div>

            <div class="form-group">
                <label class="control-label" for="student_email">Email:</label>
                    <input id="student_email" type="email" class="form-control" placeholder="E-mail" maxlength="100" minlength="5" required>
                    <ul class="input-requirements">
                        <li>Use expression like this: testmail@gmail.com</li>
                        <li>At least 5 characters long (and less than 100 characters)</li>
                    </ul>
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
                    <input id="student_groupNumber" type="text" class="form-control" placeholder="473903" maxlength="10" minlength="2" required>
                    <ul class="input-requirements">
                        <li>Only numbers, please</li>
                        <li>At least 2 characters long (and less than 10 characters)</li>
                    </ul>
            </div>

            <div class="form-group">
                <button id="student_reg_submit_btn" type="submit" class="btn btn-primary btn-block">Register</button>
            </div>

         </form>
        </div>
    </div>
</div>

<br/>


<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>
