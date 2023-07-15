package org.jsp.uiApp;
import java.io.*;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/fs")
public  class FirstServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		//Fetch UI/Form data
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
		//presentation logic
		PrintWriter out =resp.getWriter();
		out.println("<html><body bgcolor='orange'>"
		+"<h1>Student name is "+name+" from "+place+
		"</h1>"+"</body></html>");
		out.close();
	}
}
