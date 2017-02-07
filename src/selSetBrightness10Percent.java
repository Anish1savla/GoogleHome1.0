
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.philips.lighting.model.PHBridge;

public class selSetBrightness10Percent {

	public String SetBrightnessto10;
	
	public String SetBrightness10Percent(PHBridge bridge, WebDriver driver) throws InterruptedException, FindFailed{
		
		 Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
		    
		    Screen setBrightness10Percent = new Screen();
		    setBrightness10Percent.mouseMove(commandLineImage);
		    setBrightness10Percent.click();
		    
		    setBrightness10Percent.type("Set the lights to 10%");
		    setBrightness10Percent.type("\n");
		    
		    HBSetBrightnessTo10Percent hbsetbrightness10percent = new HBSetBrightnessTo10Percent();
		    SetBrightnessto10 = hbsetbrightness10percent.SetBrightness10Percent(bridge,driver);
		    
		    //System.out.println("In Turn off hue color lamp one in Selenium:"+SetBrightnessto10);
		    
		    return SetBrightnessto10;
	    	
		
	}
	
}
