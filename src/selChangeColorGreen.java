import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.philips.lighting.model.PHBridge;

public class selChangeColorGreen
{
  String returnChangeColorGreen;
  
  public String selChangeColorToRed(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    System.out.println("Inside selenium change red color");
    Pattern commandLineImage = new Pattern("C:\\Users\\310235474\\Desktop\\eclipse\\CommandLineImage.PNG");
    
    Screen turnOFFAllLightsTestScreen = new Screen();
    turnOFFAllLightsTestScreen.mouseMove(commandLineImage);
    turnOFFAllLightsTestScreen.click();
    
    turnOFFAllLightsTestScreen.type("turn all lights Green");
    turnOFFAllLightsTestScreen.type("\n");
    
    HBCheckAllLightsGreen hballgreen = new HBCheckAllLightsGreen();
    
    System.out.println("Now calling HB check for Red lights");
    this.returnChangeColorGreen = hballgreen.HBCheckAllLightsToGreen(bridge);
    
    return this.returnChangeColorGreen;
  }
}

