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
        <jsp:param name="heading" value="Page for faculty creation" />
    </jsp:include>

</div>


<div class="container">

    <div class="row">

            <form class="commonForm" id="facultyRegistrationForm">

                <div class="form-group">
                    <label class="control-label">Existing faculties:</label>
                    <select id="existing_faculties" class="form-control">
                    </select>
                </div>

                <div class="form-group">
                    <label class="control-label">Faculty name:</label>
                    <input id="faculty_name" name="faculty_name" type="text" class="form-control" placeholder="Name" onfocus="removeError()" autocomplete="off">
                    <div class="validation-form" id="name-error"></div>
                </div>

                <div class="form-group">
                    <button id="faculty_reg_submit_btn" type="button" class="btn btn-primary btn-block" disabled="disabled">Create</button>
                </div>

            </form>

    </div>
</div>

<br/>

<script src="../resources/js/custom/facultyRegistration/facultyRegistration.js"></script>
<script src="../resources/js/libs/jquery.validate.min.js"></script>
<script src="../resources/js/custom/facultyRegistration/facultyValidation.js"></script>
<script src="../resources/js/libs/sweetalert2.min.js"></script>
<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>