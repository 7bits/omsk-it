<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="footer">
    <div class="page">
        <div class="subscription">
            <div class="subscription-title">
                Узнайте о начале регистрации вовремя:
            </div>

            <%@ include file="/WEB-INF/view/jsp/_subscription_form.jsp" %>

        </div>
        <div class="site-minor-logo">
             <a class="link-clear" href='<c:url value="/"/>'><img src='<c:url value="/resources/images/site-minor-logo.png"/>'></a>
        </div>
        <div class="tracking inline-item">
            <div class="tracking-title inline-item">
               Следите за новостями:
            </div>

            <div class="inline-item">
                <a class="link-clear" href="https://twitter.com/OmskIT" target="_blank"><img src='<c:url value="/resources/images/twitter-logo.png"/>'></a>
                <a class="link-clear" href="http://vk.com/omskit" target="_blank"><img src='<c:url value="/resources/images/vk-logo.png"/>'></a>
            </div>
        </div>
        <div class="copyright">
            &copy; OmskIT, 2014
        </div>
    </div>
</div>
