<%@page import="java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">
</head>
<style>
*{
 font-family: 'Lato', sans-serif;
}

.middle {
	position: absolute;
	left: 50%;
	top: 15%;
	transform: translate(-50%, -15%);
}

.middle1 {
	position: absolute;
	left: 50%;
	transform: translate(-50%, 0%);
}
ul.a{
list-style-type: none;
}
.dlink{
text-decoration: none;
}
.fontsize{
font-size: 40px;
}
.font1{
 font-size: 100px;
}
.logout{
 position: absolute;
 top:90%;
 left:90%;
}
</style>
<body>
	<h1 class="middle1" class="font1">Subscriber's List</h1>
	<h1 class="middle1" class="font1">Click on the name to start chatting</h1>
	<div class="middle">
		<c:if test="${not empty lists}">

			<ul class="a">
				<c:forEach var="listValue" items="${lists}">
					<li><a
						href="/pubsub/chat/${user_id}/${listValue}" class="dlink" class="fontsize">${listValue}</a></li>
						<br>
				</c:forEach>
			</ul>

		</c:if>
	</div>
	<a class="logout" href="/pubsub/logout">Log out</a>
</body>
</html>