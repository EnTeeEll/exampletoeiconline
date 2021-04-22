<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<html>
<head>
    <title><fmt:message key="label.home" bundle="${lang}"/></title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="<c:url value="/template/web/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/template/web/css/bootstrap-responsive.css"/>">
    <link rel="stylesheet" href="<c:url value="/template/web/css/style.css"/>">
    <!--Font-->
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <!-- SCRIPT
    ============================================================-->
    <script src="<c:url value="http://code.jquery.com/jquery.js"/>"></script>
    <script src="<c:url value="/template/web/js/bootstrap.min.js"/>"></script>


    <dec:head/>
</head>

<body>
    <%@include file="/common/web/header.jsp"%>
    
    <div class="container">
        <dec:body/>
    </div>
    
    <%@include file="/common/web/footer.jsp"%>
</body>
</html>