package com.files.JMS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
 
@Service
public class EmailSenderServices  {

	@Autowired
	private JavaMailSender MailSender;
	 
	
	 
	public void sendMail(String toEmail,String subject,String body,User user) {
		
		SimpleMailMessage simpleMessage=new SimpleMailMessage();
		 String emailContent = "Name: " + user.getName() + "\n" +
		         "Mobile: "+user.getMobile()+ "\n"+
               //  "Address: " + user.getAdress() + "\n" +
                 "Message: " + user.getBody();
		simpleMessage.setTo(toEmail);
		simpleMessage.setSubject(subject);
		simpleMessage.setText(emailContent);
		
		MailSender.send(simpleMessage);
		
		System.out.println("Mail sent successfully.......");
		
	}
}
