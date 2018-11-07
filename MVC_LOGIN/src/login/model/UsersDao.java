package login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import login.db.Provider;
import login.db.Users;

public class UsersDao 
{

	public static int saveUser(Users u) 
	{
		int status=0;
		try
		{
			Connection con=Provider.getConnection();
			String sql="insert into Users values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getEmail());
			pst.setString(4, u.getPhone());
			pst.setString(5, u.getRegdno());
			pst.setString(6, u.getCollege());

			status=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

	public static int validate(Users u) 
	{
		int status=0;
		try
		{
			Connection con=Provider.getConnection();
			String sql="select * from users where email=? and password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
				status=1;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}

	public static void updatePassword(Users u) 
	{
		try
		{
			Connection con=Provider.getConnection();
			String sql="update Users set password=? where email=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(2, u.getEmail());
			pst.setString(1, u.getPassword());
			
			pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public static String getPassword(Users u) 
	{
		String pass=null;
		try
		{
			Connection con=Provider.getConnection();
			String sql="select password from users where email=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u.getEmail());
		
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				pass=rs.getString("password");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pass;
	}	
}
