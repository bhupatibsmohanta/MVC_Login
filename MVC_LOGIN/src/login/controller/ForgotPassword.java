package login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.db.Users;
import login.model.UsersDao;
import login.service.SendPassword;

@WebServlet("/login.controller.ForgotPassword")
public class ForgotPassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Users u=new Users();
		u.setEmail(request.getParameter("email"));
		
		String pass=UsersDao.getPassword(u);
		u.setPassword(pass);
		if(pass!=null)
		{
			SendPassword.sendForgetPassword(u);
			response.sendRedirect("login.jsp?msg=Password send to Mail");
		}
		else
			response.sendRedirect("forgot.jsp?msg=Invalid Email id");
	}

}
