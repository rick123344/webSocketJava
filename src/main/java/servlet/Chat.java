package servlet;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(
        name = "Chat",
        urlPatterns = {"/chat"}
    )
public class Chat extends HttpServlet {
	Config config = new Config();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		
		System.out.println(basePath);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		
		String message = "CopyRick";
		
        req.setAttribute("message", message);
		req.setAttribute("path",basePath);
        req.getRequestDispatcher("chat.jsp").forward(req, resp);
    }
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		/*String p1 = req.getParameter("key").toString();
		String p2 = req.getParameter("key2").toString();
		PrintWriter out = resp.getWriter();
		String msg = p1+" "+p2;
		
		out.write(msg);*/
	}
	
}