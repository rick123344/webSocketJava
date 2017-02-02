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
		req.setAttribute("msg","Test MSG<br>");
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		String p1 = req.getParameter("key").toString();
		String p2 = req.getParameter("key2").toString();
		//String p3 = req.getParameter("key3");
		//System.out.println(p1+" "+p2);
		PrintWriter out = resp.getWriter();
		String msg = p1+" "+p2; 
		/*StringBuffer str = new StringBuffer();
		BufferedReader reader = req.getReader();
		String line = "";
		while((line = reader.readLine())!=null){
			str.append(line);
		}
		String msg = str.toString();*/
		out.write(msg);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			
		PrintWriter out = resp.getWriter();
		StringBuffer str = new StringBuffer();
		BufferedReader reader = req.getReader();
		String line = "";
		while((line = reader.readLine())!=null){
			str.append(line);
		}
		String msg = str.toString();
		out.write(msg);	
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			
		PrintWriter out = resp.getWriter();
		StringBuffer str = new StringBuffer();
		BufferedReader reader = req.getReader();
		String line = "";
		while((line = reader.readLine())!=null){
			str.append(line);
		}
		String msg = str.toString();
		out.write(msg);	
	}

}