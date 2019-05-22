<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">

<head>
<meta charset="utf-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body {
  font-family: tahoma;
}

* {
  box-sizing: border-box;
}

body {
  background-color: #8080805c;
}
/* Full-width input fields */
/* input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
} */
.old {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

.new {
  position: absolute;
  width: 40%;
  padding: 10px;
  background-color: #ddd;
  outline: none;
  border: none;
  left: 50%;
  transform: translateX(-50%);
}

.new1 {
  position: absolute;
  width: 40%;
  padding: 10px;
  left: 50%;
  transform: translateX(-50%);
}
/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

.animate {
  -webkit-animation: animatezoom 0.6s;
  animation: animatezoom 0.6s
}

to {
  -webkit-transform: scale(1)
}


to {
  transform: scale(1)
}

}
/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}

img.avatar {
  width: 25%;
  border-radius: 50%;
}
/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 8px 16px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  opacity: 0.9;
  border-radius: 12px;
}
.navitem a:focus{color:#000;}

.right {
  float: right;
  padding:1%;
  font-size: 16px;
  color: white;
}

.upper {
  position: absolute;
  left: 50%;
  top: 10%;
  transform: translate(-50%, 0%);
}

.error {
  color: #ff0000;
}

button:hover {
  opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  width: auto;
  padding: 14px 20px;
  background-color: #f44336;
}

.cancelbtn1 {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}
/* Float cancel and signup buttons and add an equal width */
.cancelbtn {
  float: left;
}

.signupbtn {
  padding: 14px 20px;
  float: right;
  width: auto;
}
/* Add padding to container elements */
.container {
  padding: 16px;
}

.cenup {
  float: right;
  width: auto;
  margin-right: 30px;
  font-size: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}
/* The Modal (background) */
.modal1 {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: #474e5d;
  padding-top: 50px;
}

/* Modal Content/Box */
.modal-content1 {
  background-color: #fefefe;
  margin: 5% auto 15% auto;
  /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* The Close Button (x) */
.close1{
  position: absolute;
  right: 35px;
  top: 15px;
  font-size: 40px;
  font-weight: bold;
  color: black;
}

.close1:hover, .close1:focus {
  color: #f44336;
  cursor: pointer;
}
button.close{
  padding-right: 2%;
}
.login_button {
  position: absolute;
  left: 50%;
  transform: translate(-50%, 0%);
}
/*while hovering*/
a:hover{
 cursor:pointer;
 text-decoration: none;
 color: white;
}
/*after visiting*/
a:visited {
    color: white;
}
a{
opacity:0.9;
}
/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
    width: 100%;
  }
}
</style>
<body>

  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <h2 style="margin-top: 12.5px; color: skyblue;">Pubsub</h2>
      </div>
      <ul class="nav navbar-nav" style="margin-top: 2.5px">
        <li><a >Home</a></li>
        <li><a  data-toggle="modal" data-target="#About" >About Us</a></li>
        <li><a data-toggle="modal" data-target="#Contact" >Contact Us</a></li>
      </ul>
      <!-- About Modal -->
      <div class="modal fade" id="About" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <br>
            <br>
            <div class="modal-body">
              <p>We here are trying to make groups more closer. Now sharing of files with your friends and groups become more easier with PUBSUB</p>
              <p>PUBSUB provides you the following facilities:</p>
              <li>You can chat with admin of your subscribed channel</li>
              <li>Create your own channel</li>
              <li>You can create a group in which all are admin</li>
              <p>So let be a part of a community and help each other to grow and get one step more closer to each other</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default"
                data-dismiss="modal">Close</button>
            </div>
          </div>

        </div>
      </div>

            <!-- Contact Modal -->
            <div class="modal fade" id="Contact" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <br>
            <br>
            <div class="modal-body">
              <p style="text-align: center;">If you have any query then you can cotanct us on:</p>
              <p style="text-align: center;">+91 8851795365</p>
            
              <p style="text-align: center;">or</p>
              <p style="text-align: center;">or you can drop an email on mehulaggarwal29@gmail.com</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default"
                data-dismiss="modal">Close</button>
            </div>
          </div>

        </div>
      </div>

      <a href="/pubsub/register" class="right" >Sign Up</a>
      <form action="/pubsub/login" method="get">
      <button 
        class="cenup">Log in</button>
      </form>

    </div>
  </nav>

</body>
<!-- <script>
document.getElementById('id01').style.display = 'block';
</script> -->
</html>
