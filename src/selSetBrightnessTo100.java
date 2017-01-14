
import com.philips.lighting.model.PHBridge;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class selSetBrightnessTo100
{
  public String HBsetBright100;
  
  public <HBSetAllBrightessTo100> String SetBrightnessTo100(PHBridge bridge, WebDriver driver)
    throws FindFailed, InterruptedException
  {
    Pattern commandLineImage = new Pattern("C:\\Users\\310235474\\Desktop\\eclipse\\CommandLineImage.PNG");
    
    Screen setBrightness100 = new Screen();
    setBrightness100.mouseMove(commandLineImage);
    setBrightness100.click();
    
    setBrightness100.type("Set Brightness for all lights to 100%");
    setBrightness100.type("\n");
    
    HBSetAllBrightnessTo100 hbsetbright100 = new HBSetAllBrightnessTo100();
    return this.HBsetBright100 = hbsetbright100.HBSetBrightnessTo100Percent(bridge);
  }


}
