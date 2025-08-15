<%@page pageEncoding="UTF-8" contentType="text/html" %>
<%@ page isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.directmedia.onlinestore.core.entity.Artist" %>
<%@page import="com.directmedia.onlinestore.core.entity.Work" %>
<%@page import="com.directmedia.onlinestore.core.entity.Catalog" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Catalogue</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${works}" var="work">
                <li>${work.title} (${work.release})</li>
            </c:forEach>
        </ul>
    </body>
</html>
