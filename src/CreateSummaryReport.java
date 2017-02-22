import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CreateSummaryReport {
	
	public void SummaryReport() throws IOException{
		System.out.println("Inside Creating Summary Report Chart");
		
		FileInputStream file = new FileInputStream(new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		System.out.println("Sheet Name inside Creating summary Report:"+sheet.getSheetName());
		
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		
		//Turn ON All Lights GRAPH.
		Cell cell = sheet.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS =(int)evaluator.evaluate(cell).getNumberValue();
		System.out.println(PASS+":PASS");
		
		Cell cell1 = sheet.getRow(55).getCell(2);
		int FAIL =(int)evaluator.evaluate(cell1).getNumberValue();
		System.out.println(FAIL+":FAIL");

		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(FAIL,"FAIL","Turn ON ALl Lights");
		dataset.addValue(PASS,"PASS","Turn ON ALl Lights");
		
		
		//Turn OFF All Lights GRAPH.
		HSSFSheet sheet1 = workbook.getSheetAt(1);
		
		Cell cell2 = sheet1.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS1 =(int)evaluator.evaluate(cell2).getNumberValue();
		System.out.println(PASS1+":PASS1");
		
		Cell cell3 = sheet1.getRow(55).getCell(2);
		int FAIL1 =(int)evaluator.evaluate(cell3).getNumberValue();
		System.out.println(FAIL1+":FAIL1");

		dataset.addValue(FAIL1,"FAIL","Turn OFF ALl Lights");
		dataset.addValue(PASS1,"PASS","Turn OFF ALl Lights");
		
		//Turn All Lights RED
		
		HSSFSheet sheet2 = workbook.getSheetAt(2);
		
		Cell cell4 = sheet2.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS2 =(int)evaluator.evaluate(cell4).getNumberValue();
		System.out.println(PASS2+":PASS2");
		
		Cell cell5 = sheet2.getRow(55).getCell(2);
		int FAIL2 =(int)evaluator.evaluate(cell5).getNumberValue();
		System.out.println(FAIL2+":FAIL2");

		dataset.addValue(FAIL2,"FAIL","Turn All Lights RED");
		dataset.addValue(PASS2,"PASS","Turn All Lights RED");

		//Turn All Lights GREEN
		
		HSSFSheet sheet3 = workbook.getSheetAt(3);
		
		Cell cell6 = sheet3.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS3 =(int)evaluator.evaluate(cell6).getNumberValue();
		System.out.println(PASS3+":PASS3");
		
		Cell cell7 = sheet3.getRow(55).getCell(2);
		int FAIL3 =(int)evaluator.evaluate(cell7).getNumberValue();
		System.out.println(FAIL3+":FAIL3");

		dataset.addValue(FAIL3,"FAIL","Turn All Lights GREEN");
		dataset.addValue(PASS3,"PASS","Turn All Lights GREEN");
		
		//Set All Lights to 100%
		
		HSSFSheet sheet4 = workbook.getSheetAt(4);
		
		Cell cell8 = sheet4.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS4 =(int)evaluator.evaluate(cell8).getNumberValue();
		System.out.println(PASS4+":PASS4");
		
		Cell cell9 = sheet4.getRow(55).getCell(2);
		int FAIL4 =(int)evaluator.evaluate(cell9).getNumberValue();
		System.out.println(FAIL4+":FAIL4");

		dataset.addValue(FAIL4,"FAIL","Set All Lights to 100%");
		dataset.addValue(PASS4,"PASS","Set All Lights to 100%");
		
		//Turn ON Hue Color Lamp 1
		
		HSSFSheet sheet5 = workbook.getSheetAt(5);
		
		Cell cell10 = sheet5.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS5 =(int)evaluator.evaluate(cell10).getNumberValue();
		System.out.println(PASS5+":PASS5");
		
		Cell cell11 = sheet5.getRow(55).getCell(2);
		int FAIL5 =(int)evaluator.evaluate(cell11).getNumberValue();
		System.out.println(FAIL5+":FAIL5");

		dataset.addValue(FAIL5,"FAIL","Turn ON Hue Color Lamp 1");
		dataset.addValue(PASS5,"PASS","Turn ON Hue Color Lamp 1");
		
		//Turn OFF Hue Color Lamp 1
		
		HSSFSheet sheet6 = workbook.getSheetAt(6);
		
		Cell cell12 = sheet6.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS6 =(int)evaluator.evaluate(cell12).getNumberValue();
		System.out.println(PASS6+":PASS6");
		
		Cell cell13 = sheet6.getRow(55).getCell(2);
		int FAIL6 =(int)evaluator.evaluate(cell13).getNumberValue();
		System.out.println(FAIL6+":FAIL6");

		dataset.addValue(FAIL6,"FAIL","Turn OFF Hue Color Lamp 1");
		dataset.addValue(PASS6,"PASS","Turn OFF Hue Color Lamp 1");
		
		//Dim All Lights
		
		HSSFSheet sheet7 = workbook.getSheetAt(7);
		
		Cell cell14 = sheet7.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS7 =(int)evaluator.evaluate(cell14).getNumberValue();
		System.out.println(PASS7+":PASS7");
		
		Cell cell15 = sheet7.getRow(55).getCell(2);
		int FAIL7 =(int)evaluator.evaluate(cell15).getNumberValue();
		System.out.println(FAIL7+":FAIL7");

		dataset.addValue(FAIL7,"FAIL","Dim All Lights");
		dataset.addValue(PASS7,"PASS","Dim All Lights");
		
		//Dim Hue Go 2
		
		HSSFSheet sheet8 = workbook.getSheetAt(8);
		
		Cell cell16 = sheet8.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS8 =(int)evaluator.evaluate(cell16).getNumberValue();
		System.out.println(PASS8+":PASS8");
		
		Cell cell17 = sheet7.getRow(55).getCell(2);
		int FAIL8 =(int)evaluator.evaluate(cell17).getNumberValue();
		System.out.println(FAIL8+":FAIL8");

		dataset.addValue(FAIL8,"FAIL","Dim Hue Go 2");
		dataset.addValue(PASS8,"PASS","Dim Hue Go 2");
		
		//Set the Lights to 10%
		
		HSSFSheet sheet9 = workbook.getSheetAt(9);
		
		Cell cell18 = sheet9.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS9 =(int)evaluator.evaluate(cell18).getNumberValue();
		System.out.println(PASS9+":PASS9");
		
		Cell cell19 = sheet9.getRow(55).getCell(2);
		int FAIL9 =(int)evaluator.evaluate(cell19).getNumberValue();
		System.out.println(FAIL9+":FAIL9");

		dataset.addValue(FAIL9,"FAIL","Set The Lights to 10%");
		dataset.addValue(PASS9,"PASS","Set The Lights to 10%");
		

		//Brighten all Lights by 10%
		
		HSSFSheet sheet10 = workbook.getSheetAt(10);
		
		Cell cell20 = sheet10.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS10 =(int)evaluator.evaluate(cell20).getNumberValue();
		System.out.println(PASS10+":PASS10");
		
		Cell cell21 = sheet10.getRow(55).getCell(2);
		int FAIL10 =(int)evaluator.evaluate(cell21).getNumberValue();
		System.out.println(FAIL10+":FAIL10");

		dataset.addValue(FAIL10,"FAIL","Brighten all Lights by 10%");
		dataset.addValue(PASS10,"PASS","Brighten all Lights by 10%");
		
		//Turn Hue Light Strip Plus 1 Blue
		
		HSSFSheet sheet11 = workbook.getSheetAt(11);
		
		Cell cell22 = sheet11.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS11 =(int)evaluator.evaluate(cell22).getNumberValue();
		System.out.println(PASS11+":PASS11");
		
		Cell cell23 = sheet11.getRow(55).getCell(2);
		int FAIL11 =(int)evaluator.evaluate(cell23).getNumberValue();
		System.out.println(FAIL11+":FAIL11");

		dataset.addValue(FAIL11,"FAIL","Turn Hue Light Strip Plus 1 Blue");
		dataset.addValue(PASS11,"PASS","Turn Hue Light Strip Plus 1 Blue");
		
		//Dim the Lights By 20%
		
		HSSFSheet sheet12 = workbook.getSheetAt(12);
		
		Cell cell24 = sheet12.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS12 =(int)evaluator.evaluate(cell24).getNumberValue();
		System.out.println(PASS12+":PASS12");
		
		Cell cell25 = sheet12.getRow(55).getCell(2);
		int FAIL12 =(int)evaluator.evaluate(cell25).getNumberValue();
		System.out.println(FAIL12+":FAIL12");

		dataset.addValue(FAIL12,"FAIL","Dim the Lights By 20%");
		dataset.addValue(PASS12,"PASS","Dim the Lights By 20%");
		
		//Dim Hue Color Lamp 6 By 30%
		
		HSSFSheet sheet13 = workbook.getSheetAt(13);
		
		Cell cell26 = sheet13.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS13 =(int)evaluator.evaluate(cell26).getNumberValue();
		System.out.println(PASS13+":PASS13");
		
		Cell cell27 = sheet13.getRow(55).getCell(2);
		int FAIL13 =(int)evaluator.evaluate(cell27).getNumberValue();
		System.out.println(FAIL13+":FAIL13");

		dataset.addValue(FAIL13,"FAIL","Dim Hue Color Lamp 6 By 30%");
		dataset.addValue(PASS13,"PASS","Dim Hue Color Lamp 6 By 30%");
		
		//Brighten White Lamp by 20%
		
		HSSFSheet sheet14 = workbook.getSheetAt(14);
		
		Cell cell28 = sheet14.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS14 =(int)evaluator.evaluate(cell28).getNumberValue();
		System.out.println(PASS14+":PASS14");
		
		Cell cell29 = sheet14.getRow(55).getCell(2);
		int FAIL14 =(int)evaluator.evaluate(cell29).getNumberValue();
		System.out.println(FAIL14+":FAIL14");

		dataset.addValue(FAIL14,"FAIL","Brighten White Lamp by 20%");
		dataset.addValue(PASS14,"PASS","Brighten White Lamp by 20%");
		
		//Turn ON Lights in Living Room

		HSSFSheet sheet15 = workbook.getSheetAt(15);
		
		Cell cell30 = sheet15.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS15 =(int)evaluator.evaluate(cell30).getNumberValue();
		System.out.println(PASS15+":PASS15");
		
		Cell cell31 = sheet15.getRow(55).getCell(2);
		int FAIL15 =(int)evaluator.evaluate(cell31).getNumberValue();
		System.out.println(FAIL15+":FAIL15");

		dataset.addValue(FAIL15,"FAIL","Turn ON Lights in Living Room");
		dataset.addValue(PASS15,"PASS","Turn ON Lights in Living Room");
		
		//Turn OFF Lights in Living Room
		
		HSSFSheet sheet16 = workbook.getSheetAt(16);
		
		Cell cell32 = sheet16.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS16 =(int)evaluator.evaluate(cell32).getNumberValue();
		System.out.println(PASS16+":PASS16");
		
		Cell cell33 = sheet16.getRow(55).getCell(2);
		int FAIL16 =(int)evaluator.evaluate(cell33).getNumberValue();
		System.out.println(FAIL16+":FAIL16");

		dataset.addValue(FAIL16,"FAIL","Turn OFF Lights in Living Room");
		dataset.addValue(PASS16,"PASS","Turn OFF Lights in Living Room");
		
		//Turn ON Hue Amb in LR
		
		HSSFSheet sheet17 = workbook.getSheetAt(17);
		
		Cell cell34 = sheet17.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS17 =(int)evaluator.evaluate(cell34).getNumberValue();
		System.out.println(PASS17+":PASS17");
		
		Cell cell35 = sheet17.getRow(55).getCell(2);
		int FAIL17 =(int)evaluator.evaluate(cell35).getNumberValue();
		System.out.println(FAIL17+":FAIL17");

		dataset.addValue(FAIL17,"FAIL","Turn ON Hue Amb in LR");
		dataset.addValue(PASS17,"PASS","Turn ON Hue Amb in LR");
		
		
		//Turn OFF Hue Amb in LR
		
		HSSFSheet sheet18 = workbook.getSheetAt(18);
		
		Cell cell36 = sheet18.getRow(55).getCell(1);
		//System.out.println("Cell"+cell);
		
		int PASS18 =(int)evaluator.evaluate(cell36).getNumberValue();
		System.out.println(PASS18+":PASS18");
		
		Cell cell37 = sheet18.getRow(55).getCell(2);
		int FAIL18 =(int)evaluator.evaluate(cell37).getNumberValue();
		System.out.println(FAIL18+":FAIL18");

		dataset.addValue(FAIL18,"FAIL","Turn OFF Hue Amb in LR");
		dataset.addValue(PASS18,"PASS","Turn OFF Hue Amb in LR");
		
		//Archiving old JPEG files
		
		Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMDDYY HH-mm-ss");
	    String curDate = dateFormat.format(date);
		
		File ArchiveFolder = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\Archive\\BarCharts");
	    File OldFile = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\");
	    File[] oldFiles = OldFile.listFiles();

	    for (int i = 0; i < oldFiles.length; i++)
	    {
	      	if(oldFiles[i].getName().contains("BarChart")){
	    		System.out.println("File:"+oldFiles[i].getName());
	    		oldFiles[i].renameTo(new File(ArchiveFolder + "\\" + oldFiles[i].getName()+curDate+".jpg"));
	    	}
	    
	    }
		
		JFreeChart barChart = ChartFactory.createBarChart("Test Case Metrix",
			"Test Case Name","Status",dataset,PlotOrientation.VERTICAL,true,true,false);
			
			CategoryAxis axis = barChart.getCategoryPlot().getDomainAxis();
			axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
			
			int width = 2000;
			int height = 600;
			
			File BarChart = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\BarChart.jpg");
			ChartUtilities.saveChartAsJPEG(BarChart,barChart,width,height);
			
		
		return;
	}
}
