import java.util.List;

import org.openqa.selenium.WebDriver;

import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResourcesCache;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

public class HBBrightenAllLights {

	public String BrightenAllLights(PHBridge bridge, WebDriver driver){
		
		System.out.println("/***************************Inside BRIGHTEN ALL LIGHTS class*********************************/");
	    
		 PHBridgeResourcesCache cache = bridge.getResourceCache();
		    
		    List<PHLight> allLights = cache.getAllLights();
		    
		    for (PHLight lights : allLights)
		    {
		    	PHLightState lightState = lights.getLastKnownLightState();
		    	
		    	
		    	
		    }
		
		return null;
	}
	
}
