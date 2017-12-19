<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <script src="../resources/js/custom/specialityRegistration/specialityRegistration.js"></script>
    <script src="../resources/js/libs/jquery.validate.min.js"></script>
    <script src="../resources/js/custom/specialityRegistration/specialityValidation.js"></script>
</head>
<body>

<jsp:include page="/jsp/blocks/navigationBar.jsp"/>

<div class="container">

    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Page for speciality creation" />
    </jsp:include>

</div>


<div class="container">

    <div class="row">

        <form class="commonForm" id="specialityRegistrationForm">

            <div class="form-group">
                <label class="control-label">Choose faculty:</label>
                <select id="existing_faculties" class="form-control">
                </select>
            </div>


            <div class="form-group">
                <label class="control-label">Enter speciality:</label>
                <input id="speciality_name" name="speciality_name" type="text" class="form-control" placeholder="Name">
            </div>

            <div class="form-group">
                <button id="speciality_reg_submit_btn" type="button" class="btn btn-primary btn-block" disabled="disabled">Create</button>
            </div>

        </form>

    </div>
</div>

<br/>


<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>