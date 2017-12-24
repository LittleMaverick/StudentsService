
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <script src="../resources/js/custom/studentActions/registration/studentRegistration.js"></script>
    <script src="../resources/js/libs/jquery.validate.min.js"></script>
    <script src="../resources/js/custom/studentActions/validation/studentValidation.js"></script>
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
        <form class="registrationStudentForm" id="registrationStudentForm">

            <div class="form-group">
                <label class="control-label" for="student_username">Username:</label>
                    <input id="student_username" name="student_username" type="text" class="form-control" placeholder="Username" onfocus="removeError()" autocomplete="off">
                <div class="validation-form" id="name-error"></div>
            </div>

            <div class="form-group">
                <label class="control-label" for="student_password">Password:</label>
                    <input id="student_password" name="student_password" type="password" class="form-control" placeholder="Password">
            </div>


            <div class="form-group">
                <label class="control-label" for="password_repeat">Repeat password:</label>
                <input id="password_repeat" name="password_repeat" type="password" class="form-control" placeholder="Password" >
            </div>


            <div class="form-group">
                <label class="control-label" for="student_firstName">First name:</label>
                    <input id="student_firstName" name="student_firstName" type="text" class="form-control" placeholder="First name" autocomplete="off">
            </div>

            <div class="form-group">
                <label class="control-label" for="student_lastName">Last name:</label>
                    <input id="student_lastName" name="student_lastName" type="text" class="form-control" placeholder="Last name" autocomplete="off">
            </div>

            <div class="form-group">
                <label class="control-label" for="student_email">Email:</label>
                    <input id="student_email" name="student_email" type="email" class="form-control" placeholder="E-mail" onfocus="removeError()" autocomplete="off">
                <div class="validation-form" id="email-name-error"></div>
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
                    <input id="student_groupNumber" name="student_groupNumber" type="text" class="form-control" placeholder="473903" autocomplete="off">
            </div>

            <div class="form-group">
                <button id="student_reg_submit_btn" type="button" class="btn btn-primary btn-block" disabled="disabled">Register</button>
            </div>

         </form>
        </div>
    </div>
</div>

<br/>

<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>
