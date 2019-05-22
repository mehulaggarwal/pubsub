<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
<head>
<title>Chat</title>
<link type="text/css" rel="stylesheet" href="/css/Chat.css" />
<link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/sockjs-client/sockjs.min.js"></script>
<script src="/webjars/stomp-websocket/stomp.min.js"></script>
<script type="text/javascript" src="/js/Chat.js"></script>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<body>
     <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/userinformation"
         user = "root"  password = "root"/>
 
      
	<div id="wrapper">
		<button id="connect" class="btn btn-default" type="submit">Connect</button>
		<button id="disconnect" class="btn btn-default" type="submit"
			disabled="disabled">Disconnect</button>
		<div id="menu">
			<p class="welcome">
				Welcome, <b></b>
			</p>
			<p class="logout">
				<a id="exit" href="">Exit Chat</a>
			</p>
			<div style="clear: both"></div>
		</div>

		<div id="chatbox">
		<%-- <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from Chat_information where unique_id=12;
      </sql:query> --%>
			<div class="row">
				<div class="col-md-12">
					<table id="conversation" class="table table-striped">
						<tbody id="userinfo">
							 <c:if test="${not empty chat}">

								<c:forEach var="listValue" items="${chat}">
									<p class="container">${listValue.messages}</p>
									<%-- <a class="dis" href="/pubsub/deleteMessage/${listValue.channel_name}/${listValue.channel_id}/${listValue.notification_id}.html">delete</a> --%>
								</c:forEach>
						  </c:if> 
						</tbody>
					</table>
				</div>
			</div>


		</div>

		<form class="form-inline">
			<input name="messages" type="text" id="message" size="63" />
			<button id="send" class="btn btn-default">Send</button>
		</form>
	</div>
	<script>
	var stompClient = null;
	/*  var parse=window.location.pathname;
	    console.log(parse);
	    var id=parse.split("/");
	    var num=Number(id[4]);
    console.log(typeof ${subscriber_user_id}); */
	function setConnected(connected) {
	    $("#connect").prop("disabled", connected);
	    $("#disconnect").prop("disabled", !connected);
	    if (connected) {
	        $("#conversation").show();
	    }
	    else {
	        $("#conversation").hide();
	    }
	    $("#userinfo").html("");
	}

	function connect() {
	    var socket = new SockJS('/websocket-example');
	    stompClient = Stomp.over(socket);
	    stompClient.connect({}, function (frame) {
	        setConnected(true);
	        console.log('Connected: ' + frame);
	        stompClient.subscribe('/topic/user', function (greeting) {
	        	 var parse=window.location.pathname;
	        	    console.log(parse);
	        	    var id=parse.split("/");
	        	    var num1=Number(id[3]);
	        	    var num2=Number(id[4]);
	        	    var num=num1+num2;
	        	    console.log(num1);
	        	    console.log(num2);
	        	    console.log(JSON.parse(greeting.body).unique_id);
	        	    if(num===JSON.parse(greeting.body).unique_id)
	        	    	{
	        	    	showGreeting(JSON.parse(greeting.body).name);
	        	    	}
	           
	        });
	    });
	}

	function disconnect() {
	    if (stompClient !== null) {
	        stompClient.disconnect();
	    }
	    setConnected(false);
	    console.log("Disconnected");
	}

	function sendName() {
	    stompClient.send("/app/user", {}, JSON.stringify({'messages': $("#message").val(),'admin_id':${user_id},'subscriber_id':${subscriber_user_id},
	    	 'unique_id':${user_id}+${subscriber_user_id}
	    }));
	}

	function showGreeting(message) {
	    $("#userinfo").append("<tr><td>" + message + "</td></tr>");
	}

	$(function () {
	    $("form").on('submit', function (e) {
	        e.preventDefault();
	    });
	    $( "#connect" ).click(function() { connect(); });
	    $( "#disconnect" ).click(function() { disconnect(); });
	    $( "#send" ).click(function() { sendName(); 
	    
	    });
	});
	</script>
	<script type="text/javascript">
		// jQuery Document
		$(document).ready(function() {
			 /* setTimeout(fetchdata,3000); */
		});
		function fetchdata(){
			 $('#chatbox').load("${subscriber_user_id}"+' #chatbox');
		}
	</script>

</body>
</html>