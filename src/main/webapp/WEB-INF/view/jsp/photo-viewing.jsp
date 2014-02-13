<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${report.user.photo == null}">
        <img class="photo" src='<c:url value="/resources/images/photos/nophoto.png" />' />
    </c:when>
    <c:when test="${report.user.photo eq ''}">
        <img class="photo" src='<c:url value="/resources/images/photos/nophoto.png" />' />
    </c:when>
    <c:otherwise>
        <img class="photo" src='<c:url value="/resources/images/photos/${report.user.photo}" />' />
    </c:otherwise>
</c:choose>