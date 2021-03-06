

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
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
        
        HueGoogleHome.startTests(bridge);
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
	  
	  
    try
    {
    	
      HueBridgeConnection bh = new HueBridgeConnection();
      File BridgeConnectionFile = new File("BridgeProperty.txt");
       
      
       if (BridgeConnectionFile.exists()==true){
       
    	 // @SuppressWarnings("resource")
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
    	  bh.connectToBridgeWithIp("192.168.86.23"," ",connectCallback);
    	    TimeUnit.SECONDS.sleep(5);
    	   // System.out.println("Hue Bridge connection is done");
      }
      
    }
      
        catch (IOException localIOException) {
    	
    }
  }
  
  private static void startTests(PHBridge bridge)
    throws FindFailed, InterruptedException, IOException
  {
	
	  System.out.println("Inside start Test");
	  
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      
      driver.manage().deleteAllCookies();
      driver.get("https://developers.google.com/actions/tools/web-simulator");
      
      driver.manage().window().maximize();
      System.out.println("Chrome Window Maximized");
      Screen screen = new Screen();
      TimeUnit.SECONDS.sleep(2);
      
      
      ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,250)");
      
      TimeUnit.SECONDS.sleep(1);
      
      Pattern image1 = new Pattern("Start.PNG");
      //wait(30);
      
      //wait(30);
      screen.click(image1);
      
      String winHandleBefore = driver.getWindowHandle();
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
      for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle);
      }
      driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//*[@id='Email']")).click();
      driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(new CharSequence[] { "HueGHAutomation@gmail.com" });
      driver.manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);
      driver.findElement(By.id("next")).click();
      driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
      driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(new CharSequence[] { "HueAutomation" });
      driver.findElement(By.xpath("//*[@id='PersistentCookie']")).click();
      driver.findElement(By.id("signIn")).click();
      
      driver.switchTo().window(winHandleBefore);
      
	System.out.println("Starting Test Case Execution");
    
    TestCases tc = new TestCases();
    
    selTurnOFFDummy std = new selTurnOFFDummy();
    
    selBrightness100PDummy b100pd = new selBrightness100PDummy();
   
    tc.turnonalllights(bridge, driver);
    
    tc.SetBrightnessTo10Percent(bridge,driver);
    
    tc.turnOFFHueColorLamp1(bridge, driver);
         
    b100pd.selBrightnessTo100PDummy();
    
    tc.changeColorToRed(bridge, driver);
    
    tc.changeColorGreen(bridge, driver);
    
    tc.turnoffalllights(bridge, driver);
    
    tc.turnONHueColorLamp1(bridge, driver);
    
    tc.SetBrightnessTo100(bridge, driver);
    
    tc.TurnLightStripBlue(bridge,driver);

    tc.DimHueGo2(bridge,driver);
    
    tc.DimAllLights(bridge,driver);
    
    tc.BrightenAllLightsBy10P(bridge,driver);
        
    b100pd.selBrightnessTo100PDummy();
    
    tc.DimAllLightsBy20P(bridge,driver);
          
    tc.DimHueColorLamp6By30P(bridge,driver);
       
    tc.BrightenWhiteLampBy20P(bridge,driver);
    
    std.SelTurnOFFALLDummy();
    
    tc.TurnONAllLivingRoomLights(bridge,driver);
    
    tc.TurnOFFAllLivingRoomLights(bridge,driver);
    
    tc.TurnONAmbLivingRoomLight(bridge,driver);
    
    tc.TurnOFFAmbLivingRoomLight(bridge, driver);
    
    std.SelTurnOFFALLDummy();
    
    //tc.TurnLivingRoomOrange(bridge, driver);
    
    std.SelTurnOFFALLDummy();
   
    System.out.println("Calling HTML Report create now");
    
    tc.createHTMLReport();
    
    driver.close();
  
    SendEmailForReport sendEmail = new SendEmailForReport();
    sendEmail.sendEmail();
    
    System.exit(0);
    
  }
   
}
