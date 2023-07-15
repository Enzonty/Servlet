package org.jsp.PostApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch UI/Form data
		String sid=req.getParameter("i");
		int id=Integer.parseInt(sid);
		String name=req.getParameter("nm");
		String dept=req.getParameter("dp");
		String sperc=req.getParameter("pr");
		double perc=Double.parseDouble(sperc);
		//Presentation Logic//servlet configuration
		PrintWriter out=resp.getWriter();
		out.print("<html> <body bgcolor='blue'>"
				+ "<h1>Student Name is "+name+"From"+dept+"<h1>"
						+ "</body></html>");
		out.close();
		//persistence Logic
		Connection con=null;
		String qry="insert into student.btmstudent value(?,?,?,?)";
		PreparedStatement pstmt=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root & password=admin");
			pstmt=con.prepareStatement(qry);
			//set the datat for placeholder before excution
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, perc);
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			if (pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if (con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	

}
