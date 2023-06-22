package com.sp.otp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.imap.protocol.MailboxInfo;

public class SendResponseMail {
	public static void SendMail(String to,String name,String msg)
	{
		final String user="umeshjaiswal355@gmail.com";
		final String pass="qxnwiqjznxbyyims";
		
		String subject="Shree Pharma Company Mail";
		
		//1.get session object
		Properties props=new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.auth", "true");
		
		Session session=Session.getDefaultInstance(props,
				new javax.mail.Authenticator()
				{
			      protected PasswordAuthentication getPasswordAuthentication()
			      {
			    	  return new PasswordAuthentication(user, pass);
			      }
				});
		//2.compose message
		try {
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(msg);
			
			//3.send message
			Transport.send(message);
			System.out.println("Mail Sent");
		}
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
		}
		
	}

}
