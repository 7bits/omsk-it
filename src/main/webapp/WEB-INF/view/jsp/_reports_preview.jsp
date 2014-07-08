<c:forEach items="${reports}" var="report">
    <div class="report">
        <div class="reporter inline-item">
            <div class="name">
                <a href='<c:url value="/user/${report.user.id}"/>'><c:out value="${report.user.firstName}"/>&nbsp;<c:out value="${report.user.secondName}"/></a>
            </div>
            <div class="position">
                <%@ include file="/WEB-INF/view/jsp/job-position-viewing.jsp" %>
            </div>
            <%@ include file="/WEB-INF/view/jsp/photo-viewing.jsp" %>
        </div>
        <div class="description inline-item">
            <h2 class="description-title">
                <a href='<c:url value="/report/${report.id}"/>'>&laquo;<c:out value="${report.title}"/>&raquo;</a>
            </h2>

            <div class="text">
                <c:out value="${report.description}"/>
            </div>
        </div>
        <hr class="bottom-line">
    </div>
</c:forEach>
