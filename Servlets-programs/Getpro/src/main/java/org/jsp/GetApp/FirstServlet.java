package org.jsp.GetApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//fetching the data
		String sid=req.getParameter("i");//"1"
		int id=Integer.parseInt(sid);//1
		
		//Taking data from the database |JDBC technology
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from student.btmstudent where id=?";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			PrintWriter out=resp.getWriter();
			if (rs.next())
			{
				String name=rs.getString("name");
				String dept=rs.getString("dept");
				out.println("<html><body bgcolor='green'>"
				+ "<h1>Student name is: "+name+" from the department of :"+dept+"<h1>"
						+ "</body></html>");
				out.close();
			}
			else
			{
			   out.println("<html><body bgcolor='green'>"
				+ "<h1>No data found+<h1>"+"</body></html>");
			   out.close();
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		} 
		finally {
			if (rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
