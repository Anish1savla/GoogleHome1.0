
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.philips.lighting.model.PHBridge;

public class selChangeColorRed
{
  String returnChangeColorRed;
  
  public String selChangeColorToRed(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    System.out.println("Inside selenium change red color");
    TimeUnit.SECONDS.sleep(2);
    Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
    
    Screen turnOFFAllLightsTestScreen = new Screen();
    turnOFFAllLightsTestScreen.mouseMove(commandLineImage);
    turnOFFAllLightsTestScreen.click();
    
    turnOFFAllLightsTestScreen.type("turn all lights Red");
    turnOFFAllLightsTestScreen.type("\n");
    
    HBCheckAllLightsRed hballred = new HBCheckAllLightsRed();
    
    System.out.println("Now calling HB check for Red lights");
    this.returnChangeColorRed = hballred.HBCheckAllLightsTurnedRed(bridge);
    
    return this.returnChangeColorRed;
  }
}
