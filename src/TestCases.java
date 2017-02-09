
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
  public String turnOFFhueColorLamp1;
  public String DimAll;
  public String DimHueGo2;
  public String BrightenAllLightsBy10P;
  public String SetBrighteness10Percent;
  public String TurnLightStripBlue;
  public String DimAllLightsBy20P;
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
  
  
  public void turnOFFHueColorLamp1(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    selTurnOFFHueColorLampOne stoffhcl1 = new selTurnOFFHueColorLampOne();
    this.turnOFFhueColorLamp1 = stoffhcl1.selTurnOFFHueColorLamp1(bridge, driver);
    System.out.println("turnOFFHueColorLamp1 in Test Case:" + this.turnOFFhueColorLamp1);
  }
  
  
  public void DimAllLights(PHBridge bridge, WebDriver driver)
		    throws FindFailed, InterruptedException
		  {
		    HBDimAllLights hbdimall = new HBDimAllLights();
		    this.DimAll = hbdimall.HBDimLights(bridge,driver);
		    //System.out.println("turnOFFHueColorLamp1 in Test Case:" + this.DimAll);
		  }

  public void DimHueGo2(PHBridge bridge, WebDriver driver)
		  throws FindFailed, InterruptedException{
	  HBDimHueGo2 hbdhg2 = new HBDimHueGo2();
	  DimHueGo2 = hbdhg2.DimHueGo2(bridge,driver);
  }
  

  public void SetBrightnessTo10Percent(PHBridge bridge, WebDriver driver)
		  throws FindFailed, InterruptedException{
	  selSetBrightness10Percent sb10p = new selSetBrightness10Percent();
	  SetBrighteness10Percent = sb10p.SetBrightness10Percent(bridge,driver);
  }
  
  public void BrightenAllLightsBy10P(PHBridge bridge, WebDriver driver)
		  throws FindFailed, InterruptedException{
	  HBBrightenAllLightsBy10P hbball = new HBBrightenAllLightsBy10P();
	  BrightenAllLightsBy10P = hbball.BrightenAllLights(bridge, driver);
  }  

  public void TurnLightStripBlue(PHBridge bridge, WebDriver driver)
		  throws FindFailed, InterruptedException{
	  selTurnHueLightStripBlue stlb = new selTurnHueLightStripBlue();
	  TurnLightStripBlue = stlb.TurnHueLightStripBlue(bridge,driver);
  }  

  public void DimAllLightsBy20P(PHBridge bridge, WebDriver driver)
		  throws FindFailed, InterruptedException{
	  HBDimLightsBy20P dlb20p = new HBDimLightsBy20P();
	  DimAllLightsBy20P=dlb20p.DimAllLightsBy20Percent(bridge,driver);
  }  

  
  public void createHTMLReport()
    throws IOException
  {
    htmlReport hr = new htmlReport();
    hr.createHTMLReport(this.turnONAll, this.turnOFFAll, this.changeColorRed, this.changeColorGreen, 
    		this.setBrightness100, this.turnONhueColorLamp1,this.turnOFFhueColorLamp1,DimAll,DimHueGo2,
    		SetBrighteness10Percent,BrightenAllLightsBy10P,TurnLightStripBlue,DimAllLightsBy20P);
  }




}
