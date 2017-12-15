
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access denied</title
    <jsp:include page="/jsp/blocks/header.jsp"/>
</head>

<jsp:include page="/jsp/blocks/navigationBar.jsp"/>

<div class="container" style="text-align: center">
    <br>
    <h3>Доступ закрыт.</h3>
    <h4>${errorMsg}</h4>
</div>

    <jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>
