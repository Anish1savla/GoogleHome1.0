import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class selBrightness100PDummy {

	public void selBrightnessTo100PDummy() throws FindFailed{
		 Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
		    
		    Screen turnOFFAllLightsTestScreenDummy = new Screen();
		    turnOFFAllLightsTestScreenDummy.mouseMove(commandLineImage);
		    turnOFFAllLightsTestScreenDummy.click();
		    
		    turnOFFAllLightsTestScreenDummy.type("set the lights to 100%");
		    turnOFFAllLightsTestScreenDummy.type("\n");
		}
	}
	
