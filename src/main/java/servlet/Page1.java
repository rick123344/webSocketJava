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

import javax.mail.*;
import javax.mail.internet.*; 

@WebServlet(
        name = "Page1",
        urlPatterns = {"/page1"}
    )
public class Page1 extends HttpServlet {
	Conn c = new Conn();
	Config config = new Config();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type","text/html;charset=UTF-8");
		
		List<Map> msg = c.doDbRequest();
		String str = "";
		for(Map<Object,Object> obj : msg){
			for(Map.Entry<Object,Object> row : obj.entrySet()){
				//System.out.println(row.getKey());
				//System.out.println(row.getValue());
				str += row.getKey()+" : "+row.getValue()+"<br>";
			}
		}
		
		String message = "CopyRick";
		
		String ori = new StringBuilder()
		.append("孔子適楚，楚狂接輿遊其門曰：<br>")
		.append("「鳳兮鳳兮，何如德之衰也！來世不可待，往世不可追也。<br>")
		.append("天下有道，聖人成焉；天下無道，聖人生焉。方今之時，僅免刑焉。<br>")
		.append("福輕乎羽，莫之知載；禍重乎地，莫之知避。已乎已乎。<br>")
		.append("臨人以德！殆乎殆乎，畫地而趨！迷陽迷陽，無傷吾行！吾行郤曲，無傷吾足。」<br>")
		.append("山木自寇也，膏火自煎也。<br>")
		.append("桂可食，故伐之；漆可用，故割之。<br>")
		.append("人皆知有用之用，而莫知無用之用也。<br>")
		.toString();
		
		String note = new StringBuilder()
		.append("孔子去到楚國，楚國隱士接輿有意來到孔子門前，說<br>")
		.append("「鳳鳥啊，鳳鳥啊！你怎麼懷有大德卻來到這衰敗的國家！未來的世界不可期待，過去的時日無法追回。<br>")
		.append("天下得到了治理，聖人便成就了事業；國君昏暗天下混亂，聖人也只得順應潮流苟全生存。當今這個時代，怕就只能免遭刑辱。<br>")
		.append("幸福比羽毛還輕，而不知道怎麼取得；禍患比大地還重，而不知道怎麼回避。算了吧，算了吧！<br>")
		.append("不要在人前宣揚你的德行！危險啊，危險啊！人為地劃出一條道路讓人們去遵循！遍地的荊棘啊，不要妨礙我的行走！曲曲彎彎的道路啊，不要傷害我的雙腳！」<br>")
		.append("山上的樹木皆因材質可用而自身招致砍伐，油脂燃起燭火皆因可以燃燒照明而自取熔煎。<br>")
		.append("桂樹皮芳香可以食用，因而遭到砍伐，樹漆因為可以派上用場，所以遭受刀斧割裂。<br>")
		.append("人們都知道有用的用處，卻不懂得無用的更大用處。<br>")
		.toString();
		
        req.setAttribute("message", message);
		req.setAttribute("ori", ori);
		req.setAttribute("note", note);
		req.setAttribute("dbdata",str);
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
		
		
		if(p1.equals("mail")){
			String subject = "Hola Test";
			String content = new StringBuilder()
			.append("孔子適楚，楚狂接輿遊其門曰：<br>")
			.append("「鳳兮鳳兮，何如德之衰也！來世不可待，往世不可追也。<br>")
			.append("天下有道，聖人成焉；天下無道，聖人生焉。方今之時，僅免刑焉。<br>")
			.append("福輕乎羽，莫之知載；禍重乎地，莫之知避。已乎已乎。<br>")
			.append("臨人以德！殆乎殆乎，畫地而趨！迷陽迷陽，無傷吾行！吾行郤曲，無傷吾足。」<br>")
			.append("山木自寇也，膏火自煎也。<br>")
			.append("桂可食，故伐之；漆可用，故割之。<br>")
			.append("人皆知有用之用，而莫知無用之用也。<br>")
			.toString();
			List<String> receiver = new ArrayList<String>();
			receiver.add("rick123344@gmail.com");
			if(send_mail(receiver,subject,content)){
				//System.out.println("sended");
			}
		}
		
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

	private boolean send_mail(List receiver,String subject,String content){
		
		Session session = config.mail_config();
		
		try{
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("Rick.com"));
			for(Object r : receiver){
				msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(r.toString()));
			}
			msg.setSubject(subject);
			msg.setContent(content,"text/html; charset=utf-8");
			Transport.send(msg);
			return true;
		}catch(MessagingException e){
			//System.out.println(e.toString());
			e.printStackTrace();
			return false;
			//throw new RuntimeException(e);
		}
	}
	
}