<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Practice requests</title>

    <link href="../resources/css/libs/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="../resources/css/main.css" rel="stylesheet" type="text/css" media="all"/>

   <%-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">--%>
</head>

<jsp:include page="/jsp/blocks/navigationBar.jsp"/>

<br>

<div class="container">
    <div class="row mt-3">
        <div class="col-12">
            <button class="btn btn-success" data-toggle="modal" data-target="#firstModal">Открыть окно</button>

            <div class="modal fade" id="firstModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Название модального окна</h5>
                            <button class="close" data-dismiss="modal">×</button>
                        </div>
                        <div class="modal-body">
                            <p>Соображения высшего порядка, а также курс
                                на социально-ориентированный проект обеспечивает актуальность
                                позиций, занимаемых участниками в отношении поставленных задач?</p>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" data-dismiss="modal">Закрыть</button     >
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="../resources/js/libs/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js" integrity="sha384-a5N7Y/aK3qNeh15eJKGWxsqtnX/wWdSZSKp+81YjTmS15nvnvxKHuzaWwXHDli+4" crossorigin="anonymous"></script>--%>

<jsp:include page="/jsp/blocks/footer.jsp"/>
</body>
</html>