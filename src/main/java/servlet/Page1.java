package servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(
        name = "Page1",
        urlPatterns = {"/page1"}
    )
public class Page1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
				
		String message = "<h1>Hello World</h1>";
        req.setAttribute("message", message);
        req.getRequestDispatcher("hello.jsp").forward(req, resp);		
		
        /*PrintWriter out = resp.getWriter();
        out.write("<html><body>");
		out.write("		<h2>");
		out.write("			Hello Page1");
		out.write("		</h2>");
		out.write("</body></html>");
        out.flush();
        out.close();*/
    }

}