package org.jsp.PostProjApp;
import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class FirstServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//fetch and presentation logic | servlet technology
		String sid=req.getParameter("i");//"1"
		int id=Integer.parseInt(sid);//1
		String name=req.getParameter("nm");
		String dept=req.getParameter("dp");
		String sperc=req.getParameter("pr");//"78.40"
		double per=Double.parseDouble(sperc);//78.40
		
		PrintWriter out=resp.getWriter();
		out.println("<html><body bgcolor='orange'>"
				+ "<h1>Student name is: "+name+"from the department of :"+dept+"<h1>"
						+ "</body></html>");
		out.close();
		
		//persistence logic  || JDBC technology
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into student.btmstudent values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setDouble(4, per);
			pstmt.executeUpdate();
			System.out.println("inserted");
		}
		catch (ClassNotFoundException |SQLException e) 
		{
			e.printStackTrace();
		} 
		finally {
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
