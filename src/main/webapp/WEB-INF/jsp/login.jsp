<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/login.css">
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="block">
   	<div class="logo">
   		<img src="/images/pubsub-logo.png" class="img">
   	</div>
   	<div>
   		<h1 class="header">Login</h1>
   		<div class="form-body">
   			<form action="/pubsub/home1" method="post">
   			  <div class="img-pos">
   				<img src="/images/img_avatar2.png" height="50%" width="50%">
   			</div>
				<label><b>Enter Email</b></label> 
				<br>
				<input type="text" class="input"
					placeholder="Enter Email" class="old" name="email" required>
				<br>
				
				<br> 
				<label><b>Enter Password</b></label> 
				<br>
				<input type="password" class="input"
				placeholder="Enter Password" class="old"
					name="password" required>
					<br>
					<br>
					<a href="/pubsub/reset_password" style="float:right;color:#ff6c00;">Forget password?</a>
					<br>
					<br>
					<div class="center">
					 <input
						type="submit" value="Login"
				     	class="btn btn-primary btn-block">
				     	</div>
			</form>
   		</div>
   	</div>
   </div>
</body>
</html>