import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.philips.lighting.model.PHBridge;

public class selTurnONAll
{
  String HBTurnONAllLights;
  
  public String seleniumTestToTurnAllLightsON(PHBridge bridge, WebDriver driver)
    throws FindFailed, IOException, InterruptedException
  {
    driver.get("https://developers.google.com/actions/tools/web-simulator");
    
    driver.manage().window().maximize();
    System.out.println("Chrome Window Maximized");
    Screen screen = new Screen();
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
    
    Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
    
    Screen turnOnAllLightsTestScreen = new Screen();
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    turnOnAllLightsTestScreen.mouseMove(commandLineImage);
    turnOnAllLightsTestScreen.click();
    turnOnAllLightsTestScreen.type("turn on all lights");
    turnOnAllLightsTestScreen.type("\n");
    
    HBcheckAllLightsON hbturnonalllights = new HBcheckAllLightsON();
    
    this.HBTurnONAllLights = hbturnonalllights.HBTurnONAllLight(bridge);
    
    return this.HBTurnONAllLights;
  }
}
