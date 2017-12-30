
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <link href="../resources/css/libs/sweetalert2.min.css" rel="stylesheet" type="text/css" media="all"/>
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

            <form class="commonForm" id="headMasterRegistrationForm">

                <div class="form-group">
                    <label class="control-label">Username:</label>
                    <input id="headMaster_username" name="headMaster_username" type="text" class="form-control" placeholder="Username" autocomplete="off" onfocus="removeError()">
                    <div class="validation-form" id="name-error"></div>
                </div>

                <div class="form-group">
                    <label class="control-label">Password:</label>
                    <input id="headMaster_password" name="headMaster_password" type="password" class="form-control" placeholder="Password" autocomplete="off">
                </div>

                <div class="form-group">
                    <label class="control-label" for="password_repeat">Repeat password:</label>
                    <input id="password_repeat" name="password_repeat" type="password" class="form-control" placeholder="Password" autocomplete="off">
                </div>

                <div class="form-group">
                    <label class="control-label">First name:</label>
                    <input id="headMaster_name" name="headMaster_name" type="text" class="form-control" placeholder="Name" autocomplete="off">
                </div>

                <div class="form-group">
                    <button id="headMaster_reg_submit_btn" type="button" class="btn btn-primary btn-block" disabled="disabled">Register</button>
                </div>

            </form>

    </div>
</div>

<br/>


<script src="../resources/js/custom/headMasterRegistration/HeadMasterRegistration.js"></script>
<script src="../resources/js/libs/jquery.validate.min.js"></script>
<script src="../resources/js/custom/headMasterRegistration/headMasterValidation.js"></script>
<script src="../resources/js/libs/sweetalert2.min.js"></script>
<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>
