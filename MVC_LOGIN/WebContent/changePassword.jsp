<!DOCTYPE html>
<html>
<head>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<style type="text/css">
	li
	{
		float: left;
	}
	ul
	{
	
		list-style-type: none;
		margin: 0;
		padding: 0;
		overflow: hidden;
		background-color:#333; 
	}
	li a
	{
		display: inline-block;
		color: white;
		text-align: center;
		padding: 14px 16px;
		text-decoration: none; 
	}
	li a:HOVER {
	background-color: aqua;
}
</style>
<title>HOME</title>

</head>
<body>
	<ul>
		<li> <a href="welcome.jsp">HOME</a></li>
		<li> <a href="changePassword.jsp">CHANGE PASSWORD</a></li>
		<li> <a href="com.controller.Logout">LOGOUT</a></li>
		
		
	</ul>
	<font color="red" >
		<%
			if(request.getParameter("msg") != null)
				out.print(request.getParameter("msg"));
		%>
		</font>
		<%
			if(session.getAttribute("email") == null)
				response.sendRedirect("login.jsp");
		%>
	<form action="login.controller.ChangePassword" method="post">
		<pre>
			Current Password 	:	<input type="password" name="opass">	 <br>
			New Password 		:	<input type="password" name="npass">	 <br>
			Conform Password 	:	<input type="password" name="cpass">	 <br>
			
							<input type="submit" value="Change Password" 
							class="btn btn-primary">
		</pre>
	</form>
</body>
</html>















