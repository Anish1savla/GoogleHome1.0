import com.philips.lighting.model.PHBridge;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class selTurnOFFAllLights
{
  public String HBTurnOFFReturn;
  
  public String selTurnOFFAllLight1(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
    
    Screen turnOFFAllLightsTestScreen = new Screen();
    turnOFFAllLightsTestScreen.mouseMove(commandLineImage);
    turnOFFAllLightsTestScreen.click();
    
    turnOFFAllLightsTestScreen.type("turn off the lights");
    turnOFFAllLightsTestScreen.type("\n");
    
    HBcheckAllLightsOFF hboff = new HBcheckAllLightsOFF();
    
    this.HBTurnOFFReturn = hboff.HBTurnOFFAlllight(bridge);
    
    return this.HBTurnOFFReturn;
  }


}
