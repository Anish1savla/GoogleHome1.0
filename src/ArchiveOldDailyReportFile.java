import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArchiveOldDailyReportFile {
	
	public void ArchiveFile(){
		System.out.println("Inside Archiving Old File");
		File ArchiveFolder = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\Archive\\Daily Report");
		File OldFile = new File("C:\\Users\\310235474\\git\\GoogleHome1.0\\");
		File[] oldFiles = OldFile.listFiles();
		
		Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMDDYY HH-mm-ss");
	    String curDate = dateFormat.format(date);
		
		for (int i = 0; i < oldFiles.length; i++)
	    {
	    	
	    	if(oldFiles[i].getName().contains("DailyReportSpreadsheet")){
	    		System.out.println("File:"+oldFiles[i].getName());
	    		oldFiles[i].renameTo(new File(ArchiveFolder + "\\" + oldFiles[i].getName()+curDate+".xls"));
	    	}
	    }	
	    
		return;
	}

}
