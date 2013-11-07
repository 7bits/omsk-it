<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
    <head>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
        <meta charset="utf-8">
        <title><tiles:getAsString name="title" /></title>
        <link rel="stylesheet" href='<c:url value="/resources/css/styles.css"/>'>
        <link rel="icon" href='<c:url value="/resources/images/favicon.ico"/>' type="image/x-icon">
        <link rel="shortcut icon" href='<c:url value="/resources/images/favicon.ico"/>' type="image/x-icon">

        <script type="text/javascript">
            var subscribeUrl = '<c:url value="/subscribe"/>';
            var toGuestsUrl = '<c:url value="/to-reporters#suggest"/>';
            var toReportersUrl = '<c:url value="/to-reporters"/>';
            var toCompaniesUrl = '<c:url value="/to-companies"/>';
            var applyForReportUrl = '<c:url value="/apply-for-report"/>';
            var suggestUrl = '<c:url value="/suggest"/>'
        </script>
        <script type="text/javascript" src='<c:url value="/resources/js/jquery-1.10.2.min.js"/>'></script>
        <script type="text/javascript" src='<c:url value="/resources/js/buttons-action.js"/>'></script>
    </head>

    <body>
        <div class="light">

            <tiles:insertAttribute name="header" />

            <tiles:insertAttribute name="content" />

            <tiles:insertAttribute name="footer" />

        </div>
    </body>
</html>
