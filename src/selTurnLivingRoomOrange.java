import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.philips.lighting.model.PHBridge;

public class selTurnLivingRoomOrange {

	public String LivingRoomOrange;
	
	public String TurnLROrange(PHBridge bridge, WebDriver driver) throws InterruptedException, FindFailed{
		
		TimeUnit.SECONDS.sleep(2);
		 Pattern commandLineImage = new Pattern("CommandLineImage.PNG");
		    
		    Screen LROrange = new Screen();
		    LROrange.mouseMove(commandLineImage);
		    LROrange.click();
		    
		    LROrange.type("Turn Living Room Lights Orange");
		    LROrange.type("\n");
		    
		    HBTurnLROrange hbtlror = new HBTurnLROrange();
		    LivingRoomOrange = hbtlror.TurnLivingRoomOrange(bridge,driver);
		    
		    //System.out.println("In Turn off hue color lamp one in Selenium:"+SetBrightnessto10);
		    
		    return LivingRoomOrange;
		
		
	}
	
}
