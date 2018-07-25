<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2018/7/23
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增学生信息</title>

</head>
<body>
    <h2 align="center">新增学生信息</h2>
    <hr/>
    <form action="StudentUpdateServlet" method="post">
        <table align="center">
            <tr>
                <td><input size="15" type="hidden"name="ids" value=""></td>
            </tr>
            <tr>
                <td align="right">学号：</td>
                <td><input size="15" type="text"name="id" placeholder="请输入学号" value="${id}"></td>
            </tr>
            <tr>
                <td align="right">姓名：</td>
                <td><input size="15" type="text"name="name" placeholder="请输入姓名" value="${name}"></td>
            </tr>
            <tr>
                <td align="right">生日：</td>
                <td><input  type="date"name="birthday" placeholder="请输入生日" value="${birthday}"></td>
            </tr>
            <tr>
                <td align="right">描述：</td>
                <td><input type="text" name="description"  size="15"placeholder="请输入描述" value="${description}"></td>
            </tr>
            <tr>
                <td align="right">平均分：</td>
                <td><input  size="15" type="text"name="avgscore" placeholder="请输入平均分" value="${avgscore}"></td>
            </tr>
            <tr>
            </tr>
            <th colspan="2" align="center"><input align="middle" type="submit" value="提交"></th>
        </table>

    </form>
</body>
</html>
