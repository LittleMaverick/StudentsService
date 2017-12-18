<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <script src="../resources/js/custom/specialityRegistration.js"></script>
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

        <form class="commonForm">

            <div class="form-group">
                <label class="control-label">Choose faculty:</label>
                <select id="existing_faculties" class="form-control">
                </select>
            </div>


            <div class="form-group">
                <label class="control-label">Enter speciality:</label>
                <input id="speciality_name" type="text" class="form-control" placeholder="Name" minlength="2" required>
            </div>

            <div class="form-group">
                <button id="speciality_reg_submit_btn" type="submit" class="btn btn-primary btn-block">Create</button>
            </div>

        </form>

    </div>
</div>

<br/>


<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>