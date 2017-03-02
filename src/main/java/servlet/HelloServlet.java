package servlet;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {""}
    )
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*ServletOutputStream out = resp.getOutputStream();
        out.write("hello heroku QQ".getBytes());
        out.flush();
        out.close();*/
		
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(HelloServlet.class, "/");
		// Some other recommended settings:
		//cfg.setDirectoryForTemplateLoading(new File("src/webapp/"));
		//cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		
		//load template
		Template template = cfg.getTemplate("index.ftl");
		Map<String,Object> data = new HashMap<String,Object>();
		//set datas
		data.put("message","HI RICK");
		List<String> lang = new ArrayList<String>();
		lang.add("Chinese");
		lang.add("English");
		lang.add("Genemar");
		data.put("lang", lang);
		
		//Writer  out = new OutputStreamWriter(System.out);
		StringWriter out = new StringWriter();
		ServletOutputStream outs = resp.getOutputStream();
		try{
			template.process(data,out);
			String tmp = out.getBuffer().toString();
			outs.write(tmp.getBytes());
			//System.out.println(out.getBuffer().toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		out.flush();
		out.close();
		
		////////////////////////////////////////////////////////////////////
		
		/*String path = req.getContextPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
		req.setAttribute("path",basePath);
		req.setAttribute("test","TEST MESSAGE");
		req.setAttribute("lang",lang);
		System.out.println(req.getRequestDispatcher("index.ftl").toString());
		req.getRequestDispatcher("index.ftl").forward(req, resp);*/
		
    }

}