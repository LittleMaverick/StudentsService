
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Practice request</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
    <script src="../resources/js/libs/jquery.validate.min.js"></script>
    <script src="../resources/js/custom/practiceActions/creationPracticeRequest.js"></script>
</head>
<body>

<jsp:include page="/jsp/blocks/navigationBar.jsp"/>

<div class="container">

    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Create a practice request" />
    </jsp:include>

</div>

<div class="container">

    <div class="row">
        <form class="commonForm" id="practiceRequestCreation">

            <div class="form-group">
                <label class="control-label">Enter company name:</label>
                <input id="request_company_name" name="company_name" type="text" class="form-control" placeholder="Name">
            </div>

            <div class="form-group">
                <label class="control-label">Choose the start date:</label>
                <input id="request_start_date" name="request_start_date" type="date" class="form-control" placeholder="Start date">
            </div>


            <div class="form-group">
                <label class="control-label">Choose the finish date:</label>
                <input id="request_finish_date" name="request_finish_date" type="date" class="form-control" placeholder="Finish date">
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
                <label class="control-label">Total quantity:</label>
                <input id="request_totalQuantity" name="request_totalQuantity" type="text" class="form-control" placeholder="10">
            </div>

            <div class="form-group">
                <label class="control-label">Choose head of practice:</label>
                <select id="request_headMaster" class="form-control">
                </select>
            </div>

            <div class="form-group">
                <button id="request_submit_btn" type="button" class="btn btn-primary btn-block" disabled="disabled">Create</button>
            </div>

        </form>
    </div>
</div>
</div>

<br/>

<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>

