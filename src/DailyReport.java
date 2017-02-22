import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class DailyReport {
	
	public void createSpreadsheetForDailyReport() throws IOException, EncryptedDocumentException, InvalidFormatException, MessagingException{

		File f = new File ("C:\\Users\\310235474\\git\\GoogleHome1.0\\DailyReportSpreadsheet.xls");
		if(f.exists()==false){
			System.out.println("Inside IF to create new file");
			CreateNewDailySummaryReport newFile = new CreateNewDailySummaryReport();
			newFile.NewDailyReport();
		}else
		{
			System.out.println("Inside ELSE to create new report");
		CreateNewDailySummaryReport createtotalfield = new CreateNewDailySummaryReport();
		System.out.println("Calling function to create total field in xls");
		createtotalfield.createTotalField();
		
		CreateSummaryReport sr = new CreateSummaryReport();
		System.out.println("Calling function to create Summary Report");
		sr.SummaryReport();
		
		ArchiveOldDailyReportFile ArchFile = new ArchiveOldDailyReportFile();
		System.out.println("Calling function to Archive File");
		ArchFile.ArchiveFile();
		
		CreateNewDailySummaryReport newFile = new CreateNewDailySummaryReport();
		newFile.NewDailyReport();
		}
		
//		SendDailyReportEmail dre = new SendDailyReportEmail ();
//		dre.DailyReportemail();
		
		return;
	}

}
