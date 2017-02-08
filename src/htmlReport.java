
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
  
  public void createHTMLReport(String turnONAll, String turnOFFAll, String changeColorRed, String changeColorGreen, 
		  String setBrightness100, String turnONhueColorLamp1, String turnOFFhueColorLamp1,String DimAll, String DimHueGo2, 
		  String SetBrighteness10Percent,String BrightenAllLightsBy10P, String TurnLightStripBlue)
    throws IOException
  {
	  
	  System.out.println("Inside Create HTML Report");
	  
	/*Turn ON All Lights*/  
    if (turnONAll == null)
    {
      turnONAll = "Turn ON All Lights";
      this.reportNotes = (this.reportNotes + "<h5>" + turnONAll + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += turnONAll;
    }
    
    /* Turn OFF All Lights */
    if (turnOFFAll == null)
    {
      turnOFFAll = "Turn OFF All Lights";
      this.reportNotes = (this.reportNotes + "<h5>" + turnOFFAll + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += turnOFFAll;
    }
    
    /* Turn Color Red for All Lights */
    if (changeColorRed == null)
    {
      changeColorRed = "Turn All Lights Red";
      this.reportNotes = (this.reportNotes + "<h5>" + changeColorRed + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += changeColorRed;
    }
    
    /* Turn Color Green for All Lights */
    if (changeColorGreen == null)
    {
      changeColorGreen = "Turn All Lights Green";
      this.reportNotes = (this.reportNotes + "<h5>" + changeColorGreen + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += changeColorGreen;
    }
    
    /* Set all Lights to 100% */
    if (setBrightness100 == null)
    {
      setBrightness100 = "Set Brightness for All Lights to 100%";
      this.reportNotes = (this.reportNotes + "<h5>" + setBrightness100 + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += setBrightness100;
    }
    /* Turn ON Hue Color Lamp 1 */
    if (turnONhueColorLamp1 == null)
    {
      turnONhueColorLamp1 = "Turn ON Hue Color Lamp 1";
      this.reportNotes = (this.reportNotes + "<h5>" + turnONhueColorLamp1 + "</h5>\n");
    }
    else
    {
      this.finalHTMLReportString += turnONhueColorLamp1;
    }
    
    /* Turn OFF Hue Color Lamp 1 */
    if (turnOFFhueColorLamp1 == null)
    {
    	System.out.println("In html report:"+turnOFFhueColorLamp1);
      turnOFFhueColorLamp1 = "Turn OFF Hue Color Lamp 1";
      this.reportNotes = (this.reportNotes + "<h5>" + turnOFFhueColorLamp1 + "</h5>\n");
    }
    else
    {
    	System.out.println("In html report ELSE:"+turnOFFhueColorLamp1);
      this.finalHTMLReportString += turnOFFhueColorLamp1;
    }
    
    /* Dim All Lights */
    if (DimAll == null)
    {
    	System.out.println("In html report:"+DimAll);
    	DimAll = "Dim All Lights";
      this.reportNotes = (this.reportNotes + "<h5>" + DimAll + "</h5>\n");
    }
    else
    {
    	System.out.println("In html report ELSE:"+DimAll);
      this.finalHTMLReportString += DimAll;
    }
    
    /* Dim Hue Go 2 */
    if (DimHueGo2 == null)
    {
    	System.out.println("In html report:"+DimHueGo2);
    	DimHueGo2 = "Dim Hue Go 2";
      this.reportNotes = (this.reportNotes + "<h5>" + DimHueGo2 + "</h5>\n");
    }
    else
    {
    	System.out.println("In html report ELSE:"+DimHueGo2);
      this.finalHTMLReportString += DimHueGo2;
    }
    
    /* Set All Lights to 10% */
    if (SetBrighteness10Percent == null)
    {
    	System.out.println("In html report:"+SetBrighteness10Percent);
    	DimHueGo2 = "Brighten All Lights";
      this.reportNotes = (this.reportNotes + "<h5>" + SetBrighteness10Percent + "</h5>\n");
    }
    else
    {
    	System.out.println("In html report ELSE:"+SetBrighteness10Percent);
      this.finalHTMLReportString += SetBrighteness10Percent;
    }
    
    /* Brighten All Lights By 10% */
    if (BrightenAllLightsBy10P == null)
    {
    	System.out.println("In html report:"+BrightenAllLightsBy10P);
    	DimHueGo2 = "Brighten All Lights by 10%";
      this.reportNotes = (this.reportNotes + "<h5>" + BrightenAllLightsBy10P + "</h5>\n");
    }
    else
    {
    	System.out.println("In html report ELSE:"+BrightenAllLightsBy10P);
      this.finalHTMLReportString += BrightenAllLightsBy10P;
    }
    
    /* Turn Hue LightStrip Plus 1 Blue*/
    if (TurnLightStripBlue == null)
    {
    	System.out.println("In html report:"+TurnLightStripBlue);
    	DimHueGo2 = "Turn Hue LightStrip Plus 1 Blue";
      this.reportNotes = (this.reportNotes + "<h5>" + TurnLightStripBlue + "</h5>\n");
    }
    else
    {
    	System.out.println("In html report ELSE:"+TurnLightStripBlue);
      this.finalHTMLReportString += TurnLightStripBlue;
    }
    
    
    this.reportHeader = "<!DOCTYPE html>\n<html>\n<head>\n<title>GoogleHome-Hue Daily Report</title>\n</head>\n"
    		+ "<body bgcolor=\"#E6E6FA\">\n<h1>\n<center>\nGoogle Home - Philips Hue Daily Test Report</center>\n</h1>\n"
    		+ "<h2>\n<center>\nLocal Integration</center>\n</h2>\n\n"
    		+"<center>\n<table width=\"80%\" style=\"border:1px solid black;border-collapse:collapse\">\n"
    		+ "<tr>\n<th style=\"border:1px solid black;border-collapse:collapse\">\nTest ID</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nTest Command Name</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nExpected Results</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nActual Results</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nStatus</th>\n"
    		+ "<th style=\"border:1px solid black;border-collapse:collapse\">\nRemarks</th>\n</tr>\n";
    
    System.out.println("Creating Report HTML file");
    
    File ArchiveFolder = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\Archive");
    //System.out.println(ArchiveFolder);
    
    File OldFile = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\");
    //System.out.println(OldFile.listFiles());
    File[] oldFiles = OldFile.listFiles();
    //File[] arrayOfFile1;
    //int j = (arrayOfFile1 = oldFiles).length;
    //System.out.println("J is :"+j);
    for (int i = 0; i < oldFiles.length; i++)
    {
    	
    	if(oldFiles[i].getName().contains("Report")){
    		System.out.println("File:"+oldFiles[i].getName());
    		oldFiles[i].renameTo(new File(ArchiveFolder + "\\" + oldFiles[i].getName()));
    	}
    
      /*
      System.out.println(j);
      
      System.out.println(oldF);
      System.out.println(oldF.getName().substring(0,6));
      if (oldF.getName().substring(0, 6).contains("Report")) {
        oldF.renameTo(new File(ArchiveFolder + "\\" + oldF.getName()));
      }*/
    }
    //System.out.println("For Loop is complete");
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMDDYY HH-mm-ss");
    String curDate = dateFormat.format(date);
    System.out.println("Date is Set for Report");
    File f = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\Report " + curDate + ".html");
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
