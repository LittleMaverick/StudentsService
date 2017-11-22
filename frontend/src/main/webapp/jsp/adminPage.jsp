<%--
  Created by IntelliJ IDEA.
  User: littleF
  Date: 15.10.2017
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Administration</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
</head>
<body>




<div class="container">
    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Information about all students" />
    </jsp:include>

    <div class="btn-toolbar">

            <a href="practices" class="btn btn-primary">Show all requests</a>



            <a href="#" class="btn btn-primary"><span></span> Create faculty</a>
            <a href="#" class="btn btn-primary"><span></span> Create speciality</a>
            <a href="#" class="btn btn-primary"><span></span> Register student</a>
            <a href="#" class="btn btn-primary"><span></span> Register head of practice</a>


            <button type="submit" class="btn btn-primary">Assign student(s)</button>
            <button type="submit" class="btn btn-primary">Release student(s)</button>





            <button type="submit" class="btn btn-danger">Delete student(s)</button>


    </div>
</div>



<br/>
<div class="container">

    <table class="table table-hover" data-toggle="table"
           data-click-to-select="true">
        <thead>
        <tr>
            <th>#</th>
            <th>L. Name</th>
            <th>F. Name</th>
            <th>Faculty</th>
            <th>Speciality</th>
            <th>Group</th>
            <th>Status</th>
            <th>Company</th>
            <th>Practice period</th>
            <th></th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <th></th>
            <th>Otto</th>
            <th>Mark</th>
            <th>test</th>
            <th>test</th>
            <th>test</th>
            <th>On practice</th>
            <th>Integral</th>
            <th>1.09.2017 - 1.10.2017</th>
            <th><button type="submit" class="btn btn-primary">Show</button></th>
        </tr>
        <tr>
            <th></th>
            <th>Otto</th>
            <th>Mark</th>
            <th>test</th>
            <th>test</th>
            <th>test</th>
            <th>On practice</th>
            <th>Integral</th>
            <th>1.09.2017 - 1.10.2017</th>
            <th><button type="submit" class="btn btn-primary">Show</button></th>
        </tr>
        <tr>
            <th></th>
            <th>Otto</th>
            <th>Mark</th>
            <th>test</th>
            <th>test</th>
            <th>test</th>
            <th>On practice</th>
            <th>Integral</th>
            <th>1.09.2017 - 1.10.2017</th>
            <th><button type="submit" class="btn btn-primary">Show</button></th>
        </tr>
        </tbody>
    </table>
</div>



<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>