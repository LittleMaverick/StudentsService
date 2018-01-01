<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title
    <jsp:include page="/jsp/blocks/header.jsp"/>
</head>

<nav class="navbar navbar-light navCustom " >
    <div class="container">
        <div class="navbar-header">
            <a class="brandLogo navbar-brand " ><span>Practice Service </span> </a>
            <a class="brandHome navbar-brand " href="/home" ><span> Home</span></a>
        </div>

        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="/j_spring_security_Logout" class="btn btn-outline-success">Log out</a>
            </li>
        </ul>
    </div>
</nav>

<br>
<div class="container">
    <h4 class="errorPage">${errorMsg}</h4>
</div>

<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>
