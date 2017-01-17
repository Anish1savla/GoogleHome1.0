

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;

import com.philips.lighting.model.PHBridge;

public class HueGoogleHome
{
  public static String userNameStored;
  public static String ipAddressStored;
  public static int TestCaseIdCounter=0;
  public static void main(String[] args)
    throws FindFailed, InterruptedException
  {
    initializeHue(connectCallback);
    TimeUnit.SECONDS.sleep(5L);
  }
  
  private static ConnectCallback connectCallback = new ConnectCallback()
  {
    public void onConnected(PHBridge bridge)
    {
      System.out.println("Inside onConnected and about to start test");
      try
      {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        HueGoogleHome.startTests(bridge, driver);
      }
      catch (FindFailed e)
      {
        e.printStackTrace();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  };
  
  private static void initializeHue(ConnectCallback connectCallback)
    throws InterruptedException
  {
/*    
    */
    try
    {
    	
      HueBridgeConnection bh = new HueBridgeConnection();
      File BridgeConnectionFile = new File("BridgeProperty.txt");
      if (BridgeConnectionFile.exists()==true){
    	  BufferedReader br = new BufferedReader(new FileReader("BridgeProperty.txt"));
    	  String userNamefromText;
    	  int CounterExecution=0;
    	  while ((userNamefromText = br.readLine()) != null)
          {
    		  System.out.println("Inside While Loop");
            //String userNamefromText;
            if (userNamefromText.length() >= 15)
            {
              userNameStored = userNamefromText.toString();
              System.out.println("Stored Username is:" + userNameStored);
            }
            else
            {
              ipAddressStored = userNamefromText.toString();
              System.out.println("Stored IP is:" + ipAddressStored);
            }
            CounterExecution++;
            System.out.println(CounterExecution+": Counter Execution");
          }
    	  bh.connectToBridgeWithIp(ipAddressStored,userNameStored,connectCallback);
      }else {
    	  bh.connectToBridgeWithIp("192.168.86.23"," " ,connectCallback);
    	    TimeUnit.SECONDS.sleep(5);
    	   // System.out.println("Hue Bridge connection is done");
      }
      
      
      /*
      if (((userNameStored == null) || (userNameStored == "")) && ((ipAddressStored == null) || (ipAddressStored == "")))
      {
        System.out.println("Sending New IP and NULL User");
        bh.connectToBridgeWithIp("192.168.1.7", null, connectCallback);
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Hue Bridge connection is done");
      }
      else
      {
        System.out.println("Sending store ip and user");
        System.out.println("IP Send :" + ipAddressStored);
        System.out.println("UserName Send :" + userNameStored);
        
      }*/
    }
    catch (IOException localIOException) {
    	
    }
  }
  
  private static void startTests(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException, IOException
  {
	  
    System.out.println("Inside start Test");
    TestCases tc = new TestCases();
    
    tc.turnonalllights(bridge, driver);
    
    tc.turnoffalllights(bridge, driver);
    
    tc.changeColorToRed(bridge, driver);
    
    tc.changeColorGreen(bridge, driver);
    
    
    tc.turnoffalllights(bridge, driver);
    
    tc.turnONHueColorLamp1(bridge, driver);
    
    tc.SetBrightnessTo100(bridge, driver);
    
    tc.turnoffalllights(bridge, driver);
    
    tc.turnoffalllights(bridge, driver);
   
    System.out.println("Calling HTML Report create now");
    
    tc.createHTMLReport();
    
    driver.close();
  
    
    SendEmailForReport sendEmail = new SendEmailForReport();
    sendEmail.sendEmail();
    
    System.exit(0);
    
  }  
  	
 
    //TimeUnit.SECONDS.sleep(3);
   
}
