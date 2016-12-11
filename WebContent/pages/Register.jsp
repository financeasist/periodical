<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="..\css\style.css">
<link rel="stylesheet" type="text/css" href="..\css\800px.css"
	media="screen and (max-width:900px)" />
<title>Registration</title>
</head>

<body>
	<div id="page-container">
		<div id="header">
			<div class="container">
				<div id="buttons-area">
					<ul>
						<li><a href="Home.jsp" class="button">Home</a></li>
						<li><a href="AddServlet" class="button">Add</a></li>
						<li><a href="periodicalList" class="button">Dashboard</a></li>
					</ul>
				</div>
				<div id="registration-area">
					<span class="registration-link"><a>Register | </a></span> <a
						href="Login.jsp" class="registration-link"> Login</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="textShadow" id="content">
			<div class="text-center">
				<h3>To registration please fill the table:</h3>
			</div>
			<hr>
			<div id="${info}">${String}</div>
			<form id="form" action="RegisterServlet" method="post">

				<table class="registerForm">
					<thead>
						<tr>
							<th colspan="2" style="padding-top: 10px;">Enter Information
								Here:<br> <br>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td width="100"><label for="userName"> User Name: </label></td>
							<td width="182"><input type="text" name="userName"
								placeholder="Enter your user name here"><br>
							<br></td>
						</tr>
							<tr>
							<td ><label for="email"> Email: </label></td>
							<td width="182"><input type="text" name="email"
								placeholder="Enter your email here"><br>
							<br></td>
						</tr>
						<tr>
							<td><label for="password">Password: </label></td>
							<td><input type="password" name="password"
								placeholder="Enter your password here"><br> <br></td>
						</tr>
						<tr>
							<td><input type="reset" value="Reset" style="width: 60px;" /></td>
							<td><input type="submit" value="Submit" style="width: 120px;"><br><br></td>
						</tr>
						
						<tr>
							<td colspan="2">Already registered ?! <a href="Register.jsp"
								style="text-decoration: none"> : Login Here</a></td>
						</tr>
						</tbody>
				</table>
			</form>

		</div>
	</div>
	<div id="footer">
		<address id="footer-container">
			author: Roman Grupskyi <sup>&#174;</sup>
		</address>
	</div>

</body>
</html>