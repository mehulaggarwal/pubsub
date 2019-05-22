<!DOCTYPE html>
<html>
<head>
	<title>Register</title>
	<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="/css/register.css">
</head>
<body>
   <div class="block">
   	<div class="logo">
   		<img src="/images/pubsub-logo.png" class="img">
   	</div>
   	<div>
   		<h1 class="header">Sign up</h1>
   		<div class="form-body">
   			<form action="/pubsub/home" method="post">
   			<label><b>Your Name</b></label>
   			<br>
   			 <input taype="text" class="input"
					placeholder="Enter Name" class="old" name="userName" required>
				<br>
		
				<br> 
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
					<div class="center">
					 <input
						type="submit" value="Register"
				     	class="btn btn-primary btn-block">
				     	</div>
			</form>
   		</div>
   	</div>
   </div>
</body>
</html>