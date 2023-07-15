package org.jsp.UiApp2;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/ss")
public class FirstServlet extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
		//Fetch UI/Form data
				String name=req.getParameter("nms");
				String place=req.getParameter("pls");
				//presentation logic
				PrintWriter out =resp.getWriter();
				out.println("<html><body bgcolor='orange'>"
				+"<h1>Student name is "+name+" from "+place+
				"</h1>"+"</body></html>");
				out.close();
	}
}
