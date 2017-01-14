import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;

import com.philips.lighting.model.PHBridge;

public class TestCases
  extends HueGoogleHome
{
  public String StringToCreateHTML = "";
  public String turnOFFAll;
  public String turnONAll;
  public String changeColorRed;
  public String changeColorGreen;
  public String setBrightness100;
  public String nullString = "";
  public String turnONhueColorLamp1;
  //htmlReport hr = new htmlReport();
  
  public void turnonalllights(PHBridge bridge, WebDriver driver)
    throws FindFailed, IOException, InterruptedException
  {
    selTurnONAll stonall = new selTurnONAll();
    this.turnONAll = stonall.seleniumTestToTurnAllLightsON(bridge, driver);
  }
  
  public void turnoffalllights(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    selTurnOFFAllLights stoffall = new selTurnOFFAllLights();
    this.turnOFFAll = stoffall.selTurnOFFAllLight1(bridge, driver);
  }
  
  public void changeColorToRed(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    selChangeColorRed sccred = new selChangeColorRed();
    this.changeColorRed = sccred.selChangeColorToRed(bridge, driver);
  }
  
  public void changeColorGreen(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    selChangeColorGreen sccgreen = new selChangeColorGreen();
    this.changeColorGreen = sccgreen.selChangeColorToRed(bridge, driver);
  }
 
  public void SetBrightnessTo100(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    selSetBrightnessTo100 ssb100 = new selSetBrightnessTo100();
    this.setBrightness100 = ssb100.SetBrightnessTo100(bridge, driver);
  }
   
  public void turnONHueColorLamp1(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    selTurnONHueColorLampOne stonhcl1 = new selTurnONHueColorLampOne();
    this.turnONhueColorLamp1 = stonhcl1.selTurnONHueColorLamp1(bridge, driver);
    //System.out.println("turnONHueColorLamp1:" + this.turnONhueColorLamp1);
  }
  
  public void createHTMLReport()
    throws IOException
  {
    htmlReport hr = new htmlReport();
    hr.createHTMLReport(this.turnONAll, this.turnOFFAll, this.changeColorRed, this.changeColorGreen, this.setBrightness100, this.turnONhueColorLamp1);
  }


}
