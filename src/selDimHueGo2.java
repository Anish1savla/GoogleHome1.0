import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.philips.lighting.model.PHBridge;

public class selDimHueGo2 {
String DimHueGo2;
	
	public void selDimHueGo2(PHBridge bridge, WebDriver driver) throws FindFailed, InterruptedException{
		Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
	    
	    Screen turnONHueColorLamp1 = new Screen();
	    turnONHueColorLamp1.mouseMove(commandLineImage);
	    turnONHueColorLamp1.click();
	    
	    turnONHueColorLamp1.type("Dim Hue Go 2");
	    turnONHueColorLamp1.type("\n");
	}
}
