<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%--
  Created by IntelliJ IDEA.
  User: LoveAutumn
  Date: 4/6/2021
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title><dec:title default="Admin Page"/></title>
    <dec:head/>
</head>
<body>
    <%@ include file="/common/admin/header.jsp"%>
    <%@ include file="/common/admin/menu.jsp"%>
    <dec:body/>
    <%@ include file="/common/admin/footer.jsp"%>
</body>
</html>
