import java.io.File;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendDailyReportEmail {

	public void DailyReportemail() throws MessagingException{
		
		System.out.println("Sending Daily Report via Email");
		
		File f = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\BarChart.jpeg");
		if(f.exists()==true){
		System.out.println("File Exist");
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.starttls.enable","true");
		prop.setProperty("mail.transport.protocol", "smtp");
	    prop.setProperty("mail.smtp.auth", "true");
	    prop.setProperty("mail.smtp.host", "smtp.gmail.com");
	    
	    prop.setProperty("mail.smtp.port", "587");
	    prop.setProperty("mail.smtp.user", "HueGHAutomation@gmail.com");
	    prop.setProperty("mail.smtp.password", "HueAutomation");
	    
	    Session mailSession = Session.getDefaultInstance(prop,null);
	    mailSession.setDebug(true);
	    Transport transport = mailSession.getTransport();
	    
	    MimeMessage message = new MimeMessage(mailSession);
	    message.setSubject("Daily Execution Summary - Google Home Automation");
		message.setFrom(new InternetAddress("HueGHAutomation@gmail.com"));
		

		message.setContent("<h1> Test</h1>"+ "<img src=\"cid:C:\\Users\\310235474\\git\\GoogleHome1.0\\BarChart.jpeg\">", 
			       "text/html");
		message.addRecipient(Message.RecipientType.TO,new InternetAddress("anish.savla@philips.com"));
		
		transport.connect("smtp.gmail.com","HueGHAutomation@gmail.com","HueAutomation");
		transport.sendMessage(message,message.getRecipients(Message.RecipientType.TO));
		transport.close();
		System.out.println("Daily Report Email Sent");
		return;
		}
		else{
			System.out.println("Bar Chart Doesnt exist");
			return;
		}
		
	}
	
	
}
