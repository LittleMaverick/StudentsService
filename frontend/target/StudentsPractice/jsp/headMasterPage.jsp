
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
    <jsp:include page="/jsp/blocks/header.jsp"/>
</head>
<body>
<jsp:include page="/jsp/blocks/navigationBar.jsp"/>

<div class="container">

    <jsp:include page="/jsp/blocks/title.jsp">
        <jsp:param name="heading" value="Head Master's profile" />
    </jsp:include>


</div>


<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>