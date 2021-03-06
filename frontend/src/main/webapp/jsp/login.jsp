<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Login page</title>
</head>

<body>
<jsp:include page="/jsp/blocks/header.jsp"/>

<div class="container">
    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Welcome to login page" />
    </jsp:include>

    <div class="row">
            <form class="commonForm" name="form_login" action="j_spring_security_check" method="post" >

                <c:if test="${not empty error}">
                        <span class="text-danger">${error}</span>
                </c:if>

                <div class="form-group">
                    <label >Login</label>
                    <input type="text" class="form-control form-username" name="username" placeholder="Enter login" required minlength="2">
                </div>

                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control form-password" name="password" placeholder="Password" required minlength="4">
                </div>

                <div class="form-check">
                    <label class="form-check-label rememberMe">
                        <input name="remember-me" type="checkbox">Remember me</label>
                    </label>
                </div>

                <button type="submit" name="submit" class="btn btn-primary btn-block">Log in</button>
            </form>
    </div>
</div>

    <jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>