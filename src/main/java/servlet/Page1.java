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
		
		//resp.setCharacterEncoding("UTF-8");
		//resp.setHeader("content-type","text/html;charset=UTF-8");
		
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
		.append("�դl�A���A���g���ֹC�����G<br>")
		.append("�u�񤼻񤼡A��p�w���I�]�I�ӥ@���i�ݡA���@���i�l�]�C<br>")
		.append("�ѤU���D�A�t�H���j�F�ѤU�L�D�A�t�H�Ͳj�C�褵���ɡA�ȧK�D�j�C<br>")
		.append("�ֻ��G�СA���������F�׭��G�a�A�������סC�w�G�w�G�C<br>")
		.append("�{�H�H�w�I�p�G�p�G�A�e�a���͡I�g���g���A�L�˧^��I�^�������A�L�˧^���C�v<br>")
		.append("�s��۱F�]�A�I���۷Τ]�C<br>")
		.append("�ۥi���A�G�蠟�F���i�ΡA�G�Τ��C<br>")
		.append("�H�Ҫ����Τ��ΡA�Ӳ����L�Τ��Τ]�C<br>")
		.toString();
		
		String note = new StringBuilder()
		.append("�դl�h�췡��A�������h���֦��N�Ө�դl���e�A��<br>")
		.append("�u�񳾰ڡA�񳾰ڡI�A����h���j�w�o�Ө�o�I�Ѫ���a�I���Ӫ��@�ɤ��i���ݡA�L�h���ɤ�L�k�l�^�C<br>")
		.append("�ѤU�o��F�v�z�A�t�H�K���N�F�Ʒ~�F��g���t�ѤU�V�áA�t�H�]�u�o������y�e���ͦs�C���o�ӮɥN�A�ȴN�u��K�D�D�d�C<br>")
		.append("���֤�Ф��ٻ��A�Ӥ����D�����o�F�ױw��j�a�٭��A�Ӥ����D���^�סC��F�a�A��F�a�I<br>")
		.append("���n�b�H�e�Ŵ��A���w��I�M�I�ڡA�M�I�ڡI�H���a���X�@���D�����H�̥h��`�I�M�a����ưڡA���n��ê�ڪ��樫�I�����s�s���D���ڡA���n�ˮ`�ڪ����}�I�v<br>")
		.append("�s�W�����Ҧ]����i�ΦӦۨ��ۭP���A�o�׿U�_����Ҧ]�i�H�U�N�ө��Ӧۨ����ΡC<br>")
		.append("�۾�֪ڭ��i�H���ΡA�]�ӾD����A�𺣦]���i�H���W�γ��A�ҥH�D���M��ε��C<br>")
		.append("�H�̳����D���Ϊ��γB�A�o�����o�L�Ϊ���j�γB�C<br>")
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
		
		/*String subject = "Hola Test";
		String content = new StringBuilder()
		.append("�դl�A���A���g���ֹC�����G<br>")
		.append("�u�񤼻񤼡A��p�w���I�]�I�ӥ@���i�ݡA���@���i�l�]�C<br>")
		.append("�ѤU���D�A�t�H���j�F�ѤU�L�D�A�t�H�Ͳj�C�褵���ɡA�ȧK�D�j�C<br>")
		.append("�ֻ��G�СA���������F�׭��G�a�A�������סC�w�G�w�G�C<br>")
		.append("�{�H�H�w�I�p�G�p�G�A�e�a���͡I�g���g���A�L�˧^��I�^�������A�L�˧^���C�v<br>")
		.append("�s��۱F�]�A�I���۷Τ]�C<br>")
		.append("�ۥi���A�G�蠟�F���i�ΡA�G�Τ��C<br>")
		.append("�H�Ҫ����Τ��ΡA�Ӳ����L�Τ��Τ]�C<br>")
		.toString();
		List<String> receiver = new ArrayList<String>();
		receiver.add("rick123344@gmail.com");
		if(send_mail(receiver,subject,content)){
			System.out.println("sended");
		}*/
		
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