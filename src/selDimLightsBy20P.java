import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class selDimLightsBy20P {
	
	public void selDimAllLightsBy20P() throws FindFailed{
		
		Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
	    
	    Screen DimAllLightsBy20P = new Screen();
	    DimAllLightsBy20P.mouseMove(commandLineImage);
	    DimAllLightsBy20P.click();
	    
	    DimAllLightsBy20P.type("Dim the Lights By 20%");
	    DimAllLightsBy20P.type("\n");
	}
	
}
