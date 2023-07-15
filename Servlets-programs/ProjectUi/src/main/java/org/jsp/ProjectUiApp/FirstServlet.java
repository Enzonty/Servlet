package org.jsp.ProjectUiApp;
import java.io.*;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/fsr")
public  class FirstServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		//Fetch UI/Form data
		String name=req.getParameter("ne");
		String place=req.getParameter("pc");
		//presentation logic
		PrintWriter out =resp.getWriter();
		out.println("<html><body bgcolor='green'>"
		+"<h1>Student name is "+name+" from "+place+
		"</h1>"+"</body></html>");
		out.close();
	}
}
