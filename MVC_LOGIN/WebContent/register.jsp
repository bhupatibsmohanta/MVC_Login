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
	<font color="green" >
		<%
			if(request.getParameter("msg1") != null)
				out.print(request.getParameter("msg1"));
		%>
		</font>
	<font color="red" >
		<%
			if(request.getParameter("msg2") != null)
				out.print(request.getParameter("msg2"));
		%>
		</font>
	<form action="login.controller.Register" method="post">
		<pre>
			Username 	:	<input type="text" name="username">	 <br>
			Password 	:	<input type="password" name="password">	 <br>
			Email 		:	<input type="text" name="email">	 <br>
			Phone 		:	<input type="text" name="phone">	 <br>
			Regd No 	:	<input type="text" name="regdno">	 <br>
			College 	:	<input type="text" name="college">	 <br>
							<input type="submit" value="REGISTER" 
							class="btn btn-primary">
		</pre>
	</form>
</body>
</html>















