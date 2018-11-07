package login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.db.Users;
import login.model.UsersDao;

@WebServlet("/login.controller.ChangePassword")
public class ChangePassword extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String opass=request.getParameter("opass");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		
		Users u=new Users();
		HttpSession session=request.getSession();
		u.setEmail((String)session.getAttribute("email"));
		u.setPassword((String)session.getAttribute("email"));
		u.setPassword(opass);
		
		int status=UsersDao.validate(u);
		if(status>0)
		{
			if(npass.equals(cpass))
			{
				u.setPassword(npass);
				UsersDao.updatePassword(u);
				response.sendRedirect("changePassword.jsp?msg=Password Changed Sucessfully");
			}
			else
				response.sendRedirect("changePassword.jsp?msg=New Password and current Password mismatch");

			
		}
		else
			response.sendRedirect("changePassword.jsp?msg=Invalid Current Password");
	}

}
