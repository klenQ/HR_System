<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
    <style>
        #container {
            width: 700px;
            margin: 10px auto;
        }

        #container form .align {
            margin: 8px 0;
        }
    </style>
</head>
<body>

<div id="container">
    <form action="add">
        <div class="align">
            <label>编号</label>
            <input type="text" placeholder="请输入编号"
                   name="number" class="form-control">
        </div>
        <div class="align">
            <label>名字</label>
            <input type="text" placeholder="请输入名字" name="name" class="form-control">
        </div>
        <div class="align">
            <label>性别</label>
            <label class="radio-inline">
                <input type="radio" value="男" name="gender"/>男
            </label>
            <label class="radio-inline">
                <input type="radio" value="女" name="gender"/>女
            </label>
        </div>
        <div class="align">
            <label>年龄</label>
            <input type="text" placeholder="请输入年龄" name="age" class="form-control">
        </div>
        <div class="align">
            <label>部门</label>
            <select name="dep.id" class="form-control">
                <c:forEach var="dep" items="${depList }">
                    <option value="${dep.id }">${dep.name }</option>
                </c:forEach>
            </select>
        </div>
        <div class="align">
            <button type="submit" class="btn btn-primary">保存</button>
        </div>
    </form>
</div>
</body>
</html>