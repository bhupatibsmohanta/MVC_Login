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
		<li> <a href="index.jsp">HOME</a></li>
		<li> <a href="login.jsp">LOGIN</a></li>
		<li> <a href="register.jsp">REGISTER</a></li>
		
		
	</ul>
	<font color="red" ><h1>
		<%
			if(request.getParameter("msg") != null)
				out.print(request.getParameter("msg"));
		%></h1>
		</font>
	<form action="login.controller.Login" method="post">
		<pre>
			Email 		:	<input type="text" name="email">	 <br>
			Password 	:	<input type="password" name="password">	 <br>
							<input type="submit" value="Login" 
							class="btn btn-primary">
		</pre>
	</form>
	<a href="forgot.jsp">FORGOT PASSWORD</a>
</body>
</html>















