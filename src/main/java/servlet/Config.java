package servlet;

import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

class Config{
	Session mail_config(){
		Properties props = new Properties();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port","465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","465");
		
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				final String sender = "unitw.rick@gmail.com";
				final String pwd = "kevin86825";
				return new PasswordAuthentication(sender,pwd);
			}
		});
		
		return session;
		
	}
}