<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${report.user.jobPosition == null}">
        <a href='<c:url value="${report.user.company.site}"/>' target="_blank"><c:out value="${report.user.company.name}"/></a>
    </c:when>
    <c:when test="${report.user.jobPosition eq ''}">
        <a href='<c:url value="${report.user.company.site}"/>' target="_blank"><c:out value="${report.user.company.name}"/></a>
    </c:when>
    <c:otherwise>
        <c:out value="${report.user.jobPosition}"/>, <a href='<c:url value="${report.user.company.site}"/>' target="_blank"><c:out value="${report.user.company.name}"/></a>
    </c:otherwise>
</c:choose>