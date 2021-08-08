<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新书籍</title>

    <%--BootStrap 美化界面，新 Bootstrap 核心 CSS 文件--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>更新书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">

        <%--出现更新不成功的问题：提交了修改的 SQL 请求，但是修改失败，原因在于 id 没有传给 SQL 语句--%>
        <%--解决方案：前端传递隐藏域--%>
        <input type="hidden" name="bookID" value="${QBook.bookID}"/>

        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input type="text" name="bookName" class="form-control" value="${QBook.bookName}" id="bookName" required>
        </div>
        <div class="form-group">
            <label for="bookCount">书籍数量</label>
            <input type="text" name="bookCounts" class="form-control" value="${QBook.bookCounts}" id="bookCount" required>
        </div>
        <div class="form-group">
            <label for="bookDescription">书籍描述</label>
            <input type="text" name="detail" class="form-control" value="${QBook.detail}" id="bookDescription" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>

</div>

</body>
</html>
