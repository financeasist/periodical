<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ua.com.periodical.model.Periodical"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="..\css\style.css">
<link rel="stylesheet" type="text/css" href="..\css\800px.css"
	media="screen and (max-width:800px)" />
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
						href="Login.jsp" class="registration-link"> Login</a>
				</div>
			</div>
		</div>
		<div class="container">
			<div id="content">
				<div id="mesage-block" class="${info}">${String}</div>
				<div id="form-container">
					<form action="../pages/SearchServlet" method="get">
						<input id="search" type="text" name="title" placeholder="search by title here ">
						<input type="submit" value="Search" id="searchBatton">
					</form>
				</div>
				<br> <br> <br>
				<div id="table-container">

					<table id="displayTable">
						<thead>
							<tr>
								<th class="border" colspan="7">Periodicals List:</th>
							</tr>
							<tr class="border">
								<td class="dashboard">id</td>
								<td class="dashboard">title</td>
								<td class="dashboard">price</td>
								<td class="thDescription"><a href="#">description</a></td>
								<td class="dashboard">isAdded</td>
								<td class="dashboard">isPaided</td>
								<td class="dashboard">Operation</td>
							</tr>
						</thead>

						<c:forEach items="${requestScope.list}" var="periodical">
							<tr>
								<td class="dashboard">${periodical.id}</td>
								<td class="dashboard">${periodical.title}</td>
								<td class="dashboard">${periodical.price}</td>
								<td class="dashboard"><a href="#" class="description">${periodical.discription}</a></td>
								<td class="dashboard">false</td>
								<td class="dashboard">false</td>
								<td class="dashboard">
									<form action="../pages/RemoveServlet" method="post">
										<input type="hidden" name="id" value="${periodical.id}">
										<input type="submit" class="button-delete" value="delete">
									</form>
								</td>
							</tr>
						</c:forEach>

					</table>

				</div>
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
