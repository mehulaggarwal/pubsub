<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.pos-1 {
	text-align: center;
	min-height: 20%;
}

.btn-primary {
	background-color: #28a745;
	background-image: linear-gradient(-180deg, #34d058 0%, #28a745 90%);
}

.full {
	width: 100%;
	height: 60%;
}

body, html {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
	font-family: 'Raleway', sans-serif;
	background-color: #80808005;
}

.img {
	width: 30%;
	margin-top: 1%;
	margin-bottom: 1%;
}

.header {
	margin: 0;
	font-weight: 5;
	text-align: center;
	color: #00000075;
	margin-bottom: 2%;
}

.form-body {
	padding: 20px;
	border-radius: 5px;
	background-color: white;
	border: 1px solid #d8dee2;
	width: 20%;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
}

label {
	font-weight: 600;
	color: #000000b3;
}

.pos-3 {
	margin-top: 2%;
	margin-bottom: 5%;
	width: 100%;
	border-radius: 3px;
	outline: none;
	border: 1px solid #cccccc;
	float:left;
}

input {
	padding-top: 3%;
	padding-bottom: 3%;
	padding-left: 2%;
}
</style>
</head>
<body>
	<div class="full">
		<div class="pos-1">
			<img src="/images/pubsub-logo.png" class="img">
		</div>
		<div>
			<h1 class="header">Reset Your Password</h1>

			<div class="form-body">
				<form action="/pubsub/change_password" method="post">
					<label style="float: left;">Password</label> <br> <input type="password" class="pos-3"
						placeholder="Enter Password" name="password" required> 
					<label style="float: left;">Confirm Password</label> <br> <input type="password" class="pos-3"
						placeholder="Confirm Your Password" name="password_again" required> 

						<input
						type="submit" value="Change Password"
						class="btn btn-primary btn-block">
				</form>
			</div>

		</div>
</body>
</html>