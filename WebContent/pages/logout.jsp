<%
session.setAttribute("email", null);
session.invalidate();
response.sendRedirect("Login.jsp");
%>