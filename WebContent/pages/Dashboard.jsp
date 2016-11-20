<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="..\css\style.css">
<link rel="stylesheet" type="text/css" href="..\css\800px.css"
	media="screen and (max-width:900px)" />
<title>dashboard</title>
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
		<div class="container">
			<div class="textShadow" id="content">
				<div id="form-container">
					<form action="periodicalList" method="post">
						<input id ="search" type="text" name="title" placeholder="search by title here " >
						<input type="submit" value="Search" id="searchBatton">
					</form>
				</div>
				<br>
				<br>
				<br>
		<div id="table-container">
			
           <table width="61%"    id="displayTable">
                <thead>
                    <tr>
                        <th colspan="7">Periodicals List:</th>
                    </tr>
                </thead>
				<tr class="border" >
					<td class="dashboard">id</td>
					<td class="dashboard">title</td>
					<td class="dashboard">price</td>
					<td class="dashboard"><a href="#" class="description">description</a></td>
					<td class="dashboard">isAdded</td>
					<td class="dashboard">isPaided</td>
					<td class="dashboard"><button class="button-delete" >delete</button></td>
				</tr>
				<tr>
					<td class="dashboard">1</td>
					<td class="dashboard">Men's Helth</td>
					<td class="dashboard">2.1</td>
					<td class="dashboard"><a href="#" class="description">link to description</a></td>
					<td class="dashboard">false</td>
					<td class="dashboard">false</td>
					<td class="dashboard"><button class="button-delete" >delete</button></td>
				</tr>
				<tr>
					<td class="dashboard">2</td>
					<td class="dashboard">Cosmopolitan</td>
					<td class="dashboard">1.5</td>
					<td class="dashboard"><a href="#" class="description">link to description</a></td>
					<td class="dashboard">false</td>
					<td class="dashboard">false</td>
					<td class="dashboard"><button class="button-delete" >delete</button></td>
				</tr>
				<tr>
					<td class="dashboard">3</td>
					<td class="dashboard">Moda</td>
					<td class="dashboard">1.0</td>
					<td class="dashboard"><a href="#" class="description">link to description</a></td>
					<td class="dashboard">false</td>
					<td class="dashboard">false</td>
					<td class="dashboard"><button class="button-delete" >delete</button></td>
				</tr>
				<tr>
				  <td class="dashboard">&nbsp;</td>
				  <td class="dashboard">&nbsp;</td>
				  <td class="dashboard">&nbsp;</td>
				  <td class="dashboard">&nbsp;</td>
				  <td class="dashboard">&nbsp;</td>
				  <td class="dashboard">&nbsp;</td>
				  <td class="dashboard">&nbsp;</td>
		     </tr>
				<tr>
					<td class="dashboard">4</td>
					<td class="dashboard">Forbs</td>
					<td class="dashboard">4.0</td>
					<td class="dashboard"><a href="#" class="description">link to description</a></td>
					<td class="dashboard">false</td>
					<td class="dashboard">false</td>
					<td class="dashboard"><button class="button-delete" >delete</button></td>
				</tr>
			</table>
		
		</div> 
			</div>
		</div>
		<div id="footer">
			<address id="footer-container">author: Roman Grupskyi <sup>&#174;</sup></address>
		</div>
	</div>
</body>
</html>
