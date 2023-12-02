<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: EZEN302-17
  Date: 2023-12-01
  Time: 오후 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${itemList != null}">
    <c:forEach var="item" items="${itemList}">
        <p>${item.itemName}</p>
        <p>${item.price}</p>
    </c:forEach>
    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
        <b>${num}, </b>
    </c:forEach>
</c:if>
<c:if test="${itemDetail != null}">
    <p>${itemDetail.itemName}</p>
    <p>${itemDetail.price}</p>
</c:if>
</body>
</html>
