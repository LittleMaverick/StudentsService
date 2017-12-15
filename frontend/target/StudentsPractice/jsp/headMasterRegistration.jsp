
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <script src="../resources/js/custom/HeadMasterRegistration.js"></script>
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
            <form >

                <div class="form-group">
                    <label class="control-label">Username:</label>
                    <input id="headMaster_username" type="text" class="form-control" placeholder="Username">
                </div>

                <div class="form-group">
                    <label class="control-label">Password:</label>
                    <input id="headMaster_password" type="password" class="form-control" placeholder="Password">
                </div>

                <div class="form-group">
                    <label class="control-label">First name:</label>
                    <input id="headMaster_name" type="text" class="form-control" placeholder="Name">
                </div>

                <div class="form-group">
                    <button id="headMaster_reg_submit_btn" type="button" class="btn btn-primary btn-block">Register</button>
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
