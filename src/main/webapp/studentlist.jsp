<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息列表</title>
</head>
<body>
<table border=2 cellspacing="0" align="center" width="80%">
    <caption><h3>学生信息列表</h3></caption>
    <th width="10%">编号</th>
    <th width="10%">姓名</th>
    <th width="20%">出生日期</th>
    <th width="10%">备注</th>
    <th width="10%">平均分</th>
    <th width="10%">更新</th>
    <th width="10%">删除</th>
    </tr>
    <form name="form" action="StudentListServlet">
        <c:forEach items="${studentList}" var="students">
        <tr onmouseover=" this.bgColor='gray'" onmouseout=" this.bgColor='white'">
            <td>${students.id}</td>
            <td>${students.name}</td>
            <td><fmt:formatDate value="${students.birthday}" type="date" pattern="yyyy-MM-dd"/></td>
            <td>${students.description}</td>
            <td>${students.avgscore}</td>
            <td><a href="StudentDeleteServletofupdate?ids=${students.ids}"><center>修改</center></a></td>
            <td><a href="StudentDeleteServlet?ids=${students.ids}" onclick="return confirm('您确定要删除[${students.id}]吗')"><center>删除</center></a></td>
        </tr>
        </c:forEach>
        <th colspan="7" bgcolor="#5f9ea0" align="center" >
            <a href="studentadd.jsp">新增</a>
        </th>
    </form>
</table>
<table align="center">
    <div align="center">
        <a href="${pageContext.request.contextPath}/PageBeanServlet?currentPage=${currentPage - 1} "><b>上一页</b></a>
        第${currentPage + 1}页,本页共${size}条信息，共${total}页.
        <a href="${pageContext.request.contextPath}/PageBeanServlet?currentPage=${currentPage + 1}"><b>下一页</b></a>
    </div>
</table>
</body>
</html>
