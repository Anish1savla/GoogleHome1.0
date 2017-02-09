import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class selTurnOFFDummy {
	
	public void SelTurnOFFALLDummy() throws FindFailed{
		 Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
		    
		    Screen turnOFFAllLightsTestScreenDummy = new Screen();
		    turnOFFAllLightsTestScreenDummy.mouseMove(commandLineImage);
		    turnOFFAllLightsTestScreenDummy.click();
		    
		    turnOFFAllLightsTestScreenDummy.type("turn off lights");
		    turnOFFAllLightsTestScreenDummy.type("\n");
	}

}
