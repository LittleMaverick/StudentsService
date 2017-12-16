<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<nav class="navbar navbar-light navCustom " >
    <div class="container">
    <div class="navbar-header">
        <a class="brandLogo navbar-brand " ><span>Student Service </span> </a>
        <a class="brandHome navbar-brand " href="/home" ><span> Home</span></a>
    </div>


    <div class="nav-item navAuthor">
        <span> You are logged as </span> <strong> <%=SecurityContextHolder.getContext().getAuthentication().getName()%> </strong>
    </div>

    <ul class="nav navbar-nav navbar-right">
        <li>
            <a href="/j_spring_security_Logout" class="btn btn-outline-success">Log out</a>
        </li>
    </ul>
    </div>
</nav>



