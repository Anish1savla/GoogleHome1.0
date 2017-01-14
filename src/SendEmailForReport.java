import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
//import javax.mail.Authenticator;
import javax.mail.Message;




public class SendEmailForReport {

	public void sendEmail() throws InterruptedException {
		// TODO Auto-generated method stub
		String filename = null;
		String host = "smtp.gmail.com";
		String user = "HueGHAutomation@gmail.com";
		Properties props = System.getProperties();
		
		props.put("mail.smtp.host",host);
		props.put("mail.smtp.user",user);
		props.put("mail.smtp.password","HueAutomation");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable", true);
		
		
		
		Session session = Session.getDefaultInstance(props,null);
		MimeMessage message = new MimeMessage(session);
		
		System.out.println("Port:"+session.getProperty("mail.smtp.port"));
		
		try{
			InternetAddress from = new InternetAddress("HueGHAutomation@gmail.com");
			message.setSubject("Google home daily test report");
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("anish.savla@philips.com"));
			
			Multipart multipart = new MimeMultipart("alternative");
			
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Google home body part");
			
			messageBodyPart = new MimeBodyPart();
			String htmlMessage = "Google Home HTML Text";
			messageBodyPart.setContent(htmlMessage,"text/html");
			
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			File OldFile = new File("C:\\Users\\310235474\\Desktop\\eclipse\\GHHue\\");
			File[] oldFiles = OldFile.listFiles();
			File[] arrayOfFile1;
			int j = (arrayOfFile1 = oldFiles).length;
		    for (int i = 0; i < j; i++)
		    {
		      File oldF = arrayOfFile1[i];
		      if (oldF.getName().substring(0, 6).contains("Report")) {
		    	  filename = oldF.getName();
		    	  System.out.println(filename);
		      }
		      else{
		    	  filename="No File";
		      }
		    }
			
			String finalFilename = "C:\\Users\\310235474\\Desktop\\eclipse\\GHHue\\"+filename;
			System.out.println("Final File name:"+finalFilename);
			DataSource source = new FileDataSource(finalFilename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(new File(finalFilename).getName());
			multipart.addBodyPart(messageBodyPart);
			
			message.setContent(multipart);
			
			Transport transport = session.getTransport("smtp");
			TimeUnit.SECONDS.sleep(3);
			transport.connect("smtp.gmail.com","HueGHAutomation@gmail.com","HueAutomation");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("Transport:"+transport.toString());
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("message sent");
			transport.close();
			
			return;
		}catch (AddressException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (MessagingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	
	
	}

}
