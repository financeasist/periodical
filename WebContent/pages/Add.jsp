<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="..\css\style.css">
<link rel="stylesheet" type="text/css" href="..\css\800px.css"
	media="screen and (max-width:900px)" />
<title>add</title>
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
						href="#" class="registration-link"> Login</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="textShadow" id="content">
			<span class="text-center" >
					<h3>To ADD new periodical, enter the value to requred
						filds in the table:</h3>
			</span>
			<hr>
			<div id="<%= request.getAttribute("info") %>">
			<% String s = (String) request.getAttribute("String");
			if(s== null){
				s="";
			}
			%>
			<%=s %>
			</div>
			<form id="form" action="AddServlet" method="post">
				
					<table height="298" border="1" id="addForm">
						<thead>
							<tr>
								<th colspan="2" style="padding-top: 10px;">Please add
									Periodical<br> <br>
								</th>
							</tr>
						</thead>
						<tr>
							<td width="110"><label for="id"> Id: </label></td>
							<td width="182"><input type="text" name="id"
								placeholder="Enter periodicals's id here"><br> <br></td>
						</tr>
						<tr>
							<td><label for="title">Title: </label></td>
							<td><input type="text" name="title"
								placeholder="Enter title here"><br> <br></td>
						</tr>
						<tr>
							<td><label for="price">Price: </label></td>
							<td><input type="text" name="price"
								placeholder="Enter price here"><br> <br></td>
						</tr>
						<tr>
							<td><label for="description">Description: </label></td>
							<td><textarea rows="2" cols="21" name="description"
									placeholder="Enter description here"></textarea><br></td>
						</tr>
						<tr>
							<td><label for="checkbox">Type: </label></td>
							<td><input type="checkbox" name="checkbox"><br></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Save" style="width: 160px;"><br></td>
						</tr>
					</table>
			</form>
	
		</div>
	</div>
		<div id="footer">
		<address id="footer-container">
			author: Roman Grupskyi <sup>&#174;</sup>
		</address>
	</div>
	</div>
</body>
</html>
