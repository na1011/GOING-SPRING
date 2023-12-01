<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${message.data != null}">
    <form id="redirectForm" action="${message.redirectURI}" method="${message.method}" style="display: none">
        <c:forEach items="${message.data}" var="map">
            <input type="hidden" name="${map.key}" value="${map.value}">
        </c:forEach>
    </form>
</c:if>
    <script>
        window.onload = () => {
            const message = ${message.message};
            if (message) {
                alert(message);
            }

            const form = document.getElementById('redirectForm');
            if (form) {
                form.submit();
                return false;
            }

            const redirectURI = ${message.redirectURI};
            location.href = redirectURI;
        }
    </script>

</body>
</html>
