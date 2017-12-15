<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<nav class="navbar navbar-light" style="background-color: #07f7f4;">
    <div class="container">
    <div class="navbar-header">
        <a class="navbar-brand" href="/login"><em>Student Service</em></a>
        <a class="navbar-brand" href="/home" style="color: #0ac46c;"> Home </a>
    </div>


    <div class="nav-item">
        <span class="navbar-text"> You are logged as </span> <strong> <%=SecurityContextHolder.getContext().getAuthentication().getName()%> </strong>
    </div>

    <ul class="nav navbar-nav navbar-right">
        <li>
            <a href="/j_spring_security_Logout" class="btn btn-outline-success">Log out</a>
        </li>
    </ul>
    </div>
</nav>



