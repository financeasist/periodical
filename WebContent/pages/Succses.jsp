<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="..\css\style.css">
<link rel="stylesheet" type="text/css" href="..\css\800px.css"
	media="screen and (max-width:900px)" />
<title>Authemtification</title>
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
					<span class="registration-link"><a>${userName} | </a></span> <a
						href="logout.jsp" class="registration-link"> LogOut</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="textShadow" id="content">
			<div class="text-center">
				<h3>To Login please enter your email and password in the table:</h3>
			</div>
			<hr>
			<div id="${info}">
				WELCOME ${userName} ! <br> <br> <a href='logout.jsp'>Log
					out</a>

			</div>
		</div>
	</div>

	<div id="footer">
		<address id="footer-container">
			author: Roman Grupskyi <sup>&#174;</sup>
		</address>
	</div>

</body>
</html>