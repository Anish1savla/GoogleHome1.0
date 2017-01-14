
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class htmlReport
{
  String reportHeader = null;
  String finalHTMLReportString = "";
  String reportNotes = "</table>\n</center>\n<h3>\nTest Cases Not Executed-\n";
  
  public void createHTMLReport(String turnONAll, String turnOFFAll, String changeColorRed, String changeColorGreen, String setBrightness100, String turnONhueColorLamp1)
    throws IOException
  {
	  
	  //System.out.println("Inside Create Report");
    if (turnONAll == null)
    {
      turnONAll = "Turn ON All Lights";
      this.reportNotes = (this.reportNotes + "<h5>" + turnONAll + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += turnONAll;
    }
    if (turnOFFAll == null)
    {
      turnOFFAll = "Turn OFF All Lights";
      this.reportNotes = (this.reportNotes + "<h5>" + turnOFFAll + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += turnOFFAll;
    }
    
    if (changeColorRed == null)
    {
      changeColorRed = "Turn All Lights Red";
      this.reportNotes = (this.reportNotes + "<h5>" + changeColorRed + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += changeColorRed;
    }
    
    if (changeColorGreen == null)
    {
      changeColorGreen = "Turn All Lights Green";
      this.reportNotes = (this.reportNotes + "<h5>" + changeColorGreen + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += changeColorGreen;
    }
    /*
    if (setBrightness100 == null)
    {
      setBrightness100 = "Set Brightness for All Lights to 100%";
      this.reportNotes = (this.reportNotes + "<h5>" + setBrightness100 + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += setBrightness100;
    }
    if (turnONhueColorLamp1 == null)
    {
      turnONhueColorLamp1 = "Turn ON Hue Color Lamp 1";
      this.reportNotes = (this.reportNotes + "<h5>" + turnONhueColorLamp1 + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += turnONhueColorLamp1;
    }
    */
    this.reportHeader = "<!DOCTYPE html>\n<html>\n<head>\n<title>GoogleHome-Hue Daily Report</title>\n</head>\n<body bgcolor=\"#E6E6FA\">\n<h1>\n<center>\nGoogle Home - Philips Hue Daily Test Report</center>\n</h1>\n<h2>\n<center>\nLocal Integration</center>\n</h2>\n\n";
    
    //System.out.println("Creating Report HTML file");
    
    File ArchiveFolder = new File("C:\\Users\\310235474\\Desktop\\eclipse\\GHHue\\Archive");
    File OldFile = new File("C:\\Users\\310235474\\Desktop\\eclipse\\GHHue\\");
    File[] oldFiles = OldFile.listFiles();
    File[] arrayOfFile1;
    int j = (arrayOfFile1 = oldFiles).length;
    for (int i = 0; i < j; i++)
    {
      File oldF = arrayOfFile1[i];
      if (oldF.getName().substring(0, 6).contains("Report")) {
        oldF.renameTo(new File(ArchiveFolder + "\\" + oldF.getName()));
      }
    }
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMDDYY HH-mm-ss");
    String curDate = dateFormat.format(date);
    
    File f = new File("C:\\Users\\310235474\\Desktop\\eclipse\\GHHue\\Report " + curDate + ".html");
    f.createNewFile();
    try
    {
      BufferedWriter bf = new BufferedWriter(new FileWriter(f));
      bf.write(this.reportHeader);
      bf.write(this.finalHTMLReportString);
      bf.write(this.reportNotes);
      bf.close();
      System.out.println(f.exists());
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }
  }
}
