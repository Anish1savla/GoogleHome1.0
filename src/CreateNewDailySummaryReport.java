import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;

public class CreateNewDailySummaryReport {
	
	public HSSFSheet sheet1;
	public HSSFSheet sheet2;
	public HSSFSheet sheet3;
	public HSSFSheet sheet4;
	public HSSFSheet sheet5;
	public HSSFSheet sheet6;
	public HSSFSheet sheet7;
	public HSSFSheet sheet8;
	public HSSFSheet sheet9;
	public HSSFSheet sheet10;
	public HSSFSheet sheet11;
	public HSSFSheet sheet12;
	public HSSFSheet sheet13;
	public HSSFSheet sheet14;
	public HSSFSheet sheet15;
	public HSSFSheet sheet16;
	public HSSFSheet sheet17;
	public HSSFSheet sheet18;
	public HSSFSheet sheet19;
	public HSSFSheet sheet20;
	public HSSFSheet sheet21;
	public SimpleDateFormat sdftime; 
	
	 
	
	//public HSSFCell cellType=row.createCell(1);
	HSSFWorkbook workbook = new HSSFWorkbook();
	
	public void NewDailyReport() throws IOException, EncryptedDocumentException, InvalidFormatException{
		
//PREPARE LIST OR ARRAY LIST FOR NAME OF TEST CASE AND USE FOR LOOP TO CREATE SPREADSHEET	
//		Date date = new Date();
//	    sdftime = new SimpleDateFormat("HH:mm:ss");
//	    SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
//	    String time = sdftime.format(date);
//	    String date1 = sdfdate.format(date);
		
		String fileName = "C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls";
	    	
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		/*sheet21 = workbook.createSheet("Total");
			
		HSSFRow row22;
		
		row22=sheet21.createRow((short)0);
		row22.createCell(0).setCellValue("Time");
		row22.createCell(1).setCellValue("PASS");
		row22.createCell(2).setCellValue("FAIL");*/
			
		sheet1 = workbook.createSheet("Turn ON All Lights");
		
			HSSFRow row;
			
		
			row=sheet1.createRow((short)0);
			row.createCell(0).setCellValue("Time");
			row.createCell(1).setCellValue("PASS");
			row.createCell(2).setCellValue("FAIL");
		
						
		sheet2 = workbook.createSheet("Turn OFF All Lights");
		
			HSSFRow row2;
			row2=sheet2.createRow((short)0);
			row2.createCell(0).setCellValue("Time");
			row2.createCell(1).setCellValue("PASS");
			row2.createCell(2).setCellValue("FAIL");

			
		sheet3 = workbook.createSheet("Turn All Lights RED");
		
			HSSFRow row4;
					
			row4=sheet3.createRow((short)0);
			row4.createCell(0).setCellValue("Time");
			row4.createCell(1).setCellValue("PASS");
			row4.createCell(2).setCellValue("FAIL");

		sheet4 = workbook.createSheet("Turn All Lights GREEN");
		
			HSSFRow row6;
					
			row6=sheet4.createRow((short)0);
			row6.createCell(0).setCellValue("Time");
			row6.createCell(1).setCellValue("PASS");
			row6.createCell(2).setCellValue("FAIL");
		
		
		sheet5 = workbook.createSheet("Set All Lights to 100%");
		
			HSSFRow row8;
					
			row8=sheet5.createRow((short)0);
			row8.createCell(0).setCellValue("Time");
			row8.createCell(1).setCellValue("PASS");
			row8.createCell(2).setCellValue("FAIL");
		
		
		sheet6 = workbook.createSheet("Turn ON Hue Color Lamp 1");
		
			HSSFRow row10;
					
			row10=sheet6.createRow((short)0);
			row10.createCell(0).setCellValue("Time");
			row10.createCell(1).setCellValue("PASS");
			row10.createCell(2).setCellValue("FAIL");

		
		sheet7 = workbook.createSheet("Turn OFF Hue Color Lamp 1");
		
			HSSFRow row12;
				
			row12=sheet7.createRow((short)0);
			row12.createCell(0).setCellValue("Time");
			row12.createCell(1).setCellValue("PASS");
			row12.createCell(2).setCellValue("FAIL");

		
		sheet8 = workbook.createSheet("Dim All Lights");
		
			HSSFRow row14;
				
			row14=sheet8.createRow((short)0);
			row14.createCell(0).setCellValue("Time");
			row14.createCell(1).setCellValue("PASS");
			row14.createCell(2).setCellValue("FAIL");

		
		sheet9 = workbook.createSheet("Dim Hue Go 2");
		
			HSSFRow row16;
					
			row16=sheet9.createRow((short)0);
			row16.createCell(0).setCellValue("Time");
			row16.createCell(1).setCellValue("PASS");
			row16.createCell(2).setCellValue("FAIL");

		
		sheet10 = workbook.createSheet("Set Lights to 10%");
		
			HSSFRow row18;
					
			row18=sheet10.createRow((short)0);
			row18.createCell(0).setCellValue("Time");
			row18.createCell(1).setCellValue("PASS");
			row18.createCell(2).setCellValue("FAIL");

		sheet11 = workbook.createSheet("Brighten All Lights By 10%");
		
			HSSFRow row20;
					
			row20=sheet11.createRow((short)0);
			row20.createCell(0).setCellValue("Time");
			row20.createCell(1).setCellValue("PASS");
			row20.createCell(2).setCellValue("FAIL");
		
			
		sheet12 = workbook.createSheet("Turn Hue Light Strip Plus 1 Blue");
		
			HSSFRow row221;
				
			row221=sheet12.createRow((short)0);
			row221.createCell(0).setCellValue("Time");
			row221.createCell(1).setCellValue("PASS");
			row221.createCell(2).setCellValue("FAIL");
		
		
		sheet13 = workbook.createSheet("Dim the Lights By 20%");
			
			HSSFRow row24;
					
			row24=sheet13.createRow((short)0);
			row24.createCell(0).setCellValue("Time");
			row24.createCell(1).setCellValue("PASS");
			row24.createCell(2).setCellValue("FAIL");

		
		sheet14 = workbook.createSheet("Dim Hue Color Lamp 6 By 30%");
		
			HSSFRow row26;
					
			row26=sheet14.createRow((short)0);
			row26.createCell(0).setCellValue("Time");
			row26.createCell(1).setCellValue("PASS");
			row26.createCell(2).setCellValue("FAIL");

		
		sheet15 = workbook.createSheet("Brighten White Lamp by 20%");
		
			HSSFRow row28;
					
			row28=sheet15.createRow((short)0);
			row28.createCell(0).setCellValue("Time");
			row28.createCell(1).setCellValue("PASS");
			row28.createCell(2).setCellValue("FAIL");

		
		sheet16 = workbook.createSheet("Turn ON Lights in Living Room");
		
			HSSFRow row30;
					
			row30=sheet16.createRow((short)0);
			row30.createCell(0).setCellValue("Time");
			row30.createCell(1).setCellValue("PASS");
			row30.createCell(2).setCellValue("FAIL");

		
		sheet17 = workbook.createSheet("Turn OFF Lights in Living Room");
		
			HSSFRow row32;
					
			row32=sheet17.createRow((short)0);
			row32.createCell(0).setCellValue("Time");
			row32.createCell(1).setCellValue("PASS");
			row32.createCell(2).setCellValue("FAIL");

		
		sheet18 = workbook.createSheet("Turn ON Hue Amb in LR");
		
			HSSFRow row34;
				
			row34=sheet18.createRow((short)0);
			row34.createCell(0).setCellValue("Time");
			row34.createCell(1).setCellValue("PASS");
			row34.createCell(2).setCellValue("FAIL");

		
		sheet19 = workbook.createSheet("Turn OFF Hue Amb in LR");
		
			HSSFRow row36;
			row36=sheet19.createRow((short)0);
			row36.createCell(0).setCellValue("Time");
			row36.createCell(1).setCellValue("PASS");
			row36.createCell(2).setCellValue("FAIL");
			
			
		sheet20 = workbook.createSheet("Turn LR Orange");
			
			HSSFRow row37;
			row37=sheet20.createRow((short)0);
			row37.createCell(0).setCellValue("Time");
			row37.createCell(1).setCellValue("PASS");
			row37.createCell(2).setCellValue("FAIL");
		
		FileOutputStream fileOut = new FileOutputStream(fileName);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
		System.out.println("Your Excel File has been Generated");
		//ReportTurnONAllLights("PASS");
		
		return;
	}
	
	
public void ReportTurnONAllLights(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(0);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }

		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
	        outFile.close();
	        
			return;
		}
		
		
		public void ReportTurnOFFAllLights(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(1);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }

		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
	        outFile.close();
	        
			return;
		}
		
		public void ReportTurnAllLightsRED(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(2);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }

		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
	        outFile.close();
	        
			return;
		}
		
		public void ReportTurnGreenAllLights(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(3);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }

		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
	        outFile.close();
	        
			return;
		}

public void ReportSetAllLightsTo100P(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(4);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }

		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
	        outFile.close();
	        
			return;
		}
	
		public void ReportTurnONHueColorLamp1(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(5);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}
	
		public void ReportTurnOFFHueColorLamp1(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(6);
		    System.out.println("Sheet Name:"+sheet.getSheetName());
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}

		
			/*public void ReportTurnONHueColorLamp1(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(7);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}*/
	
		public void ReportDimAllLights(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(7);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}

		public void ReportDimHueGo2(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(8);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}
		
		
		public void ReportSetLightsTo10P(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(9);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}

		public void ReportBrightenBy10P(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(10);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}

		public void ReportTurnLightStrip100P(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(11);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}

		public void ReportDimLightsBy20P(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(12);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}
		
		public void ReportDimHueColorLamp6By30P(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(13);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}
		
		public void ReportWhiteLampBy20P(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(14);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}

		public void ReportTurnONAllLR(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(15);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}
		
		public void ReportTurnOFFAllLR(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(16);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}

		public void ReportTONAmbLR(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(17);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}

		public void ReportTurnOFFAmbLR(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(18);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}
		
		
		public void TurnLivingRoomOrange(String result) throws  InvalidFormatException, IOException{
			
			Date date = new Date();
		    sdftime = new SimpleDateFormat("HH:mm:ss");
		    //SimpleDateFormat sdfdate = new SimpleDateFormat("MMddyyyy");
		    String newtime = sdftime.format(date);
			
			FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
			
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			
		     HSSFSheet sheet = workbook.getSheetAt(19);
		    
		     int lastrow = sheet.getLastRowNum();
		     int newrow = sheet.getLastRowNum()+1;
		     System.out.println(lastrow);
		     System.out.println(newrow);
		    
		     Row row = sheet.createRow(newrow);
		     row.createCell(0).setCellValue(newtime);
		     if(result.contains("PASS")==true){
		    	 
			     row.createCell(1).setCellValue(1);
			     row.createCell(2).setCellValue(0);
		     }else if(result.contains("FAIL")==true){
			     
			     row.createCell(1).setCellValue(0);
			     row.createCell(2).setCellValue(1);
		     }
		
		    file.close();
		    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		    workbook.write(outFile);
		    outFile.close();
		    
			return;
			}
		
	
	public void createTotalField() throws IOException{
		System.out.println("Inside creating Total Field function");
		FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		System.out.println("Test 1");
		
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
	         
	    Row row = sheet.createRow((short)55);
	       	row.createCell(0).setCellValue("Total");
			row.createCell(1).setCellFormula("SUM(B2:B51)");
			row.createCell(2).setCellFormula("SUM(C2:C51)");
			System.out.println("Test 4.1");
		
			
		sheet1 = workbook.getSheetAt(1);
		
		System.out.println("Test 5");	
		Row row1 = sheet1.createRow((short)55);
				 
		    row1.createCell(0).setCellValue("Total");
			row1.createCell(1).setCellFormula("SUM(B2:B51)");
			row1.createCell(2).setCellFormula("SUM(C2:C51)");
			
			 
		HSSFSheet sheet2 = workbook.getSheet("Turn All Lights RED");
			     
		Row row2 = sheet2.createRow((short)55);
			     
			row2.createCell(0).setCellValue("Total");
			row2.createCell(1).setCellFormula("SUM(B2:B51)");
			row2.createCell(2).setCellFormula("SUM(C2:C51)");
				

		HSSFSheet sheet3 = workbook.getSheetAt(3);
				     
		Row row3 = sheet3.createRow((short)55);
				     
		  	row3.createCell(0).setCellValue("Total");
			row3.createCell(1).setCellFormula("SUM(B2:B51)");
			row3.createCell(2).setCellFormula("SUM(C2:C51)");
					

		HSSFSheet sheet4 = workbook.getSheetAt(4);
					     
		Row row4 = sheet4.createRow((short)55);
					     
		    row4.createCell(0).setCellValue("Total");
			row4.createCell(1).setCellFormula("SUM(B2:B51)");
			row4.createCell(2).setCellFormula("SUM(C2:C51)");
						

		HSSFSheet sheet5 = workbook.getSheetAt(5);
						     
		Row row5 = sheet5.createRow((short)55);
						     
		    row5.createCell(0).setCellValue("Total");
			row5.createCell(1).setCellFormula("SUM(B2:B51)");
			row5.createCell(2).setCellFormula("SUM(C2:C51)");
							

		HSSFSheet sheet6 = workbook.getSheetAt(6);
							     
    	Row row6 = sheet6.createRow((short)55);
							     
		    row6.createCell(0).setCellValue("Total");
			row6.createCell(1).setCellFormula("SUM(B2:B51)");
			row6.createCell(2).setCellFormula("SUM(C2:C51)");
								

		HSSFSheet sheet7 = workbook.getSheetAt(7);
								     
		Row row7 = sheet7.createRow((short)55);
								     
		   row7.createCell(0).setCellValue("Total");
		   row7.createCell(1).setCellFormula("SUM(B2:B51)");
		   row7.createCell(2).setCellFormula("SUM(C2:C51)");
									

		 HSSFSheet sheet8 = workbook.getSheetAt(8);
									     
		 Row row8 = sheet8.createRow((short)55);
									     
		    row8.createCell(0).setCellValue("Total");
			row8.createCell(1).setCellFormula("SUM(B2:B51)");
			row8.createCell(2).setCellFormula("SUM(C2:C51)");
										

		HSSFSheet sheet9 = workbook.getSheetAt(9);
										     
     	Row row9 = sheet9.createRow((short)55);
										     
		    row9.createCell(0).setCellValue("Total");
			row9.createCell(1).setCellFormula("SUM(B2:B51)");
			row9.createCell(2).setCellFormula("SUM(C2:C51)");
											

		HSSFSheet sheet10 = workbook.getSheetAt(10);
											     
		Row row10 = sheet10.createRow((short)55);
											     
		    row10.createCell(0).setCellValue("Total");
			row10.createCell(1).setCellFormula("SUM(B2:B51)");
			row10.createCell(2).setCellFormula("SUM(C2:C51)");
												

		HSSFSheet sheet11 = workbook.getSheetAt(11);
												     
		 Row row11 = sheet11.createRow((short)55);
												     
		    row11.createCell(0).setCellValue("Total");
			row11.createCell(1).setCellFormula("SUM(B2:B51)");
			row11.createCell(2).setCellFormula("SUM(C2:C51)");
													
		HSSFSheet sheet12 = workbook.getSheetAt(12);
													     
    	 Row row12 = sheet12.createRow((short)55);
													     
		    row12.createCell(0).setCellValue("Total");
			row12.createCell(1).setCellFormula("SUM(B2:B51)");
			row12.createCell(2).setCellFormula("SUM(C2:C51)");

		HSSFSheet sheet13 = workbook.getSheetAt(13);
														     
		 Row row13 = sheet13.createRow((short)55);
														     
		    row13.createCell(0).setCellValue("Total");
			row13.createCell(1).setCellFormula("SUM(B2:B51)");
			row13.createCell(2).setCellFormula("SUM(C2:C51)");
															
															
		HSSFSheet sheet14 = workbook.getSheetAt(14);
															     
		 Row row14 = sheet14.createRow((short)55);
															     
		 	row14.createCell(0).setCellValue("Total");
			row14.createCell(1).setCellFormula("SUM(B2:B51)");
			row14.createCell(2).setCellFormula("SUM(C2:C51)");
																

		HSSFSheet sheet15 = workbook.getSheetAt(15);
																     
		 Row row15 = sheet15.createRow((short)55);
																     
		    row15.createCell(0).setCellValue("Total");
			row15.createCell(1).setCellFormula("SUM(B2:B51)");
			row15.createCell(2).setCellFormula("SUM(C2:C51)");
																	

		HSSFSheet sheet16 = workbook.getSheetAt(16);
																	     
		 Row row16 = sheet16.createRow((short)55);
																	     
		 	row16.createCell(0).setCellValue("Total");
			row16.createCell(1).setCellFormula("SUM(B2:B51)");
			row16.createCell(2).setCellFormula("SUM(C2:C51)");
																		

		HSSFSheet sheet17 = workbook.getSheetAt(17);
																		     
		 Row row17 = sheet17.createRow((short)55);
																		     
		    row17.createCell(0).setCellValue("Total");
			row17.createCell(1).setCellFormula("SUM(B2:B51)");
			row17.createCell(2).setCellFormula("SUM(C2:C51)");
																			

		HSSFSheet sheet18 = workbook.getSheetAt(18);
																			     
		 Row row18 = sheet18.createRow((short)55);
																			     
		    row18.createCell(0).setCellValue("Total");
			row18.createCell(1).setCellFormula("SUM(B2:B51)");
			row18.createCell(2).setCellFormula("SUM(C2:C51)");
			
		HSSFSheet sheet19 = workbook.getSheetAt(19);
		     
		Row row19 = sheet19.createRow((short)55);
																				     
			row19.createCell(0).setCellValue("Total");
			row19.createCell(1).setCellFormula("SUM(B2:B51)");
			row19.createCell(2).setCellFormula("SUM(C2:C51)");
		
		
	    file.close();
	    FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
	    workbook.write(outFile);
	    outFile.close();
	    System.out.println("Test 10");
	}
		
}
