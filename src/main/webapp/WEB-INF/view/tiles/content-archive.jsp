<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="content">
    <div class="page">
        <c:forEach items="${conferences}" var="conference">
            <div class="past-event-program">
                <div class="program-header">
                    <span class="order"><c:out value="${conference.ordinalNumber}"/>-й IT-субботник</span>
                    <span>прошел</span>
                    <span class="date"><c:out value="${conference.humanReadableDate}"/></span>
                    <span>в компании</span>
                    <span class="location"><a href='<c:url value="${conference.company.site}"/>'><c:out value="${conference.company.name}"/></a></span>
                </div>

                <div class="program-content">
                    <c:forEach items="${reports}" var="report">
                        <c:if test="${report.conference.id == conference.id}">
                            <div class="report">
                                <div class="reporter">
                                    <div class="name">
                                        <a href='<c:url value="/reporter/${report.reporter.id}"/>'><c:out value="${report.reporter.firstName}"/>&nbsp;<c:out value="${report.reporter.secondName}"/></a>
                                    </div>

                                    <div class="position">
                                        <c:out value="${report.reporter.jobPosition}"/>, <a href='<c:url value="${report.reporter.company.site}"/>'><c:out value="${report.reporter.company.name}"/></a>
                                    </div>

                                    <div class="photo">
                                        <img src='<c:url value="${report.reporter.photo}"/>'>
                                    </div>
                                </div>

                                <div class="description">
                                    <div class="title">
                                        <a href='<c:url value="/report/${report.id}"/>'>&laquo;<c:out value="${report.title}"/>&raquo;</a>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
